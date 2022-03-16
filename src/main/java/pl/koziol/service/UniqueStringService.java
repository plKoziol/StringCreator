package pl.koziol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.koziol.model.InputData;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Interface representing the basic functions of the program and the business logic.
 */
@Service
@RequiredArgsConstructor
public class UniqueStringService {
    private final DatabaseRelations dbRelations;
    private final FirstLevelProductWithoutPermutation firstLevelProductWithoutPermutation;
    private final SecondLevelProductSet secondLevelProductSet;
    private final CombinationAnalysis combinationAnalysis;
    int currentProcesses = 0;
    public synchronized void processesCounter(boolean active) {
        if(active){
            currentProcesses++;
        } else {
            currentProcesses--;
        }

    }
    public Set allUniqueWordGenerator(List<Map<Character,Long>> list, InputData inputData) {
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

    /**
     * The method that takes parameters, saves the process in the database, starts calculations and stores their results in the database.
     */
    public void createUniqueWords (int minLength, int maxLength, String inputCharacter, int numberOfString){

        Thread thread = new Thread(() ->{
            processesCounter(true);
            InputData inputData = new InputData();
            inputData.setMinLength(minLength);
            inputData.setMaxLength(maxLength);
            inputData.setInputCharacter(inputCharacter);
            inputData.setNumberOfString(numberOfString);
            int idProcess = dbRelations.insertInputData(inputData);
            System.out.println("Process id = " + idProcess + " save input data time = " + System.currentTimeMillis());
            inputData.setId(idProcess);
            Set<String> resultSet = new HashSet<>();
            List<Map<Character,Long>> list = firstLevelProductWithoutPermutation.listOfMapForOneCombination(inputData);
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
                }
            }

        });
        thread.start();
    }
    /**
     * The method that returns the number of active processes
     */
    public int getActiveProcesses (){
        int result = currentProcesses;
        System.out.println(result + "processes are currently active");
        return result;
    }
    /**
     * The method returns a list of strings with results for the process with the specified id.
     */
    public List<String> getResultById (int id){
        return dbRelations.presentResults(id);
    }




}
