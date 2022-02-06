package pl.koziol.service.impl;

import pl.koziol.model.InputData;
import pl.koziol.service.CombinationAnalysis;
import pl.koziol.service.DatabaseRelations;
import pl.koziol.service.SecondLevelProductSet;
import pl.koziol.service.UniqueStringService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UniqueStringServiceImp implements UniqueStringService {
    DatabaseRelations dbRelations = new DatabaseRelationsImpl();
    int currentProcesses = 0;
    public synchronized void processesCounter(boolean active) {
        if(active){
            currentProcesses++;
        } else {
            currentProcesses--;
        }

    }
    public Set allUniqueWordGenerator(List<Map<Character,Integer>> list, InputData inputData) {
        SecondLevelProductSet secondLevelProductSet = new SecondLevelProductSetImpl();
        Set<String> resultSet = new HashSet();
        int counter = 0;
        int counterSingleSave = 0;
        for(Map map : list){
            Set<String> strings = secondLevelProductSet.uniqueWordFor1CombinationGenerator(secondLevelProductSet.arrayCreator(map));
            resultSet.addAll(strings);
            counterSingleSave = resultSet.size();
            if(counterSingleSave<=1000){
                dbRelations.insertResult(inputData.getId(),resultSet,counter,inputData.getNumberOfString());
                counter +=counterSingleSave;
                resultSet = new HashSet<>();
            }
            if(inputData.getNumberOfString()<counter){
                return resultSet;
            }
        }
        return resultSet;
    }

    @Override
    public void createUniqueWords (int minLength, int maxLength, String inputCharacter, int numberOfString){

        Thread thread = new Thread(() ->{
            processesCounter(true);
            CombinationAnalysis combinationAnalysis = new CombinationAnalysisImpl();
            InputData inputData = new InputData(minLength,maxLength,inputCharacter,numberOfString);
            int idProcess = dbRelations.insertInputData(inputData);
            System.out.println("Process id = " + idProcess + " save input data time = " + System.currentTimeMillis());
            inputData.setId(idProcess);
            Set<String> resultSet = new HashSet<>();
            List<Map<Character,Integer>> list = new FirstLevelProductWithoutPermutationImpl().listOfMapForOneCombination(inputData);
            boolean sufficientNumber;
            try {
                sufficientNumber = combinationAnalysis.sufficientNumberOfCombinations(inputData,list);

            } catch (Exception e){
                sufficientNumber = false;
            }
            if(sufficientNumber){
                // in order to avoid out of memory exception, the maximum set is 1000. Larger values are in the database.
                try{
                    resultSet = allUniqueWordGenerator(list,inputData);
                    processesCounter(false);
                } catch (Exception e){
                    processesCounter(false);
                }
                System.out.println("Process id = " + idProcess + " save results time = " + System.currentTimeMillis());
            } else {
                processesCounter(false);
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e){
                    System.out.println("it is impossible to create so many unique words from the given parameters");
                    /*below is another is possible solution to replace this System.out.println

                    System.err.println("it is impossible to create so many unique words from the given parameters");
                    e.printStackTrace();

                     */
                }
            }

        });
        thread.start();
    }
    @Override
    public int getActiveProcesses (){
        int result = currentProcesses;
        System.out.println(result + "processes are currently active");
        return result;
    }
    @Override
    public List<String> getResultById (int id){
        return dbRelations.presentResults(id);
    }




}
