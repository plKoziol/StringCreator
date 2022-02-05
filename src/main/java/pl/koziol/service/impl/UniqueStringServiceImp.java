package pl.koziol.service.impl;

import pl.koziol.model.InputData;
import pl.koziol.service.DatabaseRelations;
import pl.koziol.service.FirstLevelProductWithoutPermutation;
import pl.koziol.service.SecondLevelProductSet;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UniqueStringServiceImp {
    DatabaseRelations dbRelations = new DatabaseRelationsImpl();
    int currentProcesses = 0;
    public synchronized void processesCounter(boolean active) {
        if(active){
            currentProcesses++;
        } else {
            currentProcesses--;
        }

    }

    public void createUniqueWords (int minLength, int maxLength, String inputCharacter, int numberOfString){

        Thread thread = new Thread(() ->{
            processesCounter(true);
            InputData inputData = new InputData(minLength,maxLength,inputCharacter,numberOfString);
            int idProcess = dbRelations.insertInputData(inputData);
            System.out.println("Process id = " + idProcess + " save input data time = " + System.currentTimeMillis());
            inputData.setId(idProcess);
            Set<String> resultSet = new HashSet<>();
            SecondLevelProductSet secondLevelProductSet = new SecondLevelProductSetImpl();
            List<Map<Character,Integer>> list = new FirstLevelProductWithoutPermutationImpl().listOfMapForOneCombination(inputData);
            if(new CombinationAnalysisImpl().sufficientNumberOfCombinations(inputData,list)){
                resultSet = secondLevelProductSet.allUniqueWordGenerator(list,inputData);
                dbRelations.insertResult(idProcess,resultSet);
                System.out.println("Process id = " + idProcess + " save results time = " + System.currentTimeMillis());
                processesCounter(false);
            } else {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e){
                    System.err.println("it is impossible to create so many unique words from the given parameters");
                    e.printStackTrace();
                }
            }

        });
        thread.start();
    }

    public int getActiveProcesses (){
        int result = currentProcesses;
        System.out.println(result + "processes are currently active");
        return result;
    }

    public List<String> getResultById (int id){
        return dbRelations.presentResults(id);
    }




}
