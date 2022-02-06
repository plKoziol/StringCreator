package pl.koziol.service.impl;

import pl.koziol.model.CharacterCollection;
import pl.koziol.model.InputData;
import pl.koziol.service.CharacterCollectionGenerator;
import pl.koziol.service.FirstLevelProductWithoutPermutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstLevelProductWithoutPermutationImpl implements FirstLevelProductWithoutPermutation {

    @Override
    public List<Map<Character, Integer>> listOfMapForOneCombination(InputData inputData) {
        CombinationAnalysisImpl combinationAnalysis = new CombinationAnalysisImpl();
        CharacterCollectionGenerator characterCollectionGenerator = new CharacterCollectionGeneratorImpl();
        CharacterCollection characterCollection = characterCollectionGenerator.collectionCreator(inputData);
        List<Integer> numberOperations = numberOperationCounter(characterCollection);
        List<Map<Character,Integer>> resultList = new ArrayList<>();
        int maxValueOperation = numberOperations.get(numberOperations.size()-1);
        int sumCombinationAnalysis = 0;
        for(int i = 0; i < maxValueOperation; i++){
            Map<Character,Integer> singleMap = singleSolution(characterCollection,numberOperations,i,inputData);
            if(!singleMap.isEmpty()){
                resultList.add(singleMap);
            }
            int lengthOfWord =0;
            for(Integer integer:singleMap.values()){
                lengthOfWord += integer;
            }
            if(lengthOfWord>=inputData.getMinLength() &&lengthOfWord<= inputData.getMaxLength()){
                sumCombinationAnalysis += combinationAnalysis.numberOfCombinationForm1Map(singleMap);
            }

            if(sumCombinationAnalysis>=inputData.getNumberOfString()){
                return resultList;
            }
        }
        return resultList;
    }

    private List<Integer> numberOperationCounter (CharacterCollection characterCollection){
        List<Integer> resultList = new ArrayList<>();
        int result = 1;
        Map<Character,Integer> map = characterCollection.getCharacterMap();
        List<Character> list = characterCollection.getCharacterList();
        for (Character character : list) {
            result *= map.get(character) + 1;
            resultList.add(result);
        }

        return resultList;
    }
    private Map<Character,Integer> singleSolution(CharacterCollection characterCollection, List<Integer> divisorsList, Integer dividend, InputData inputData){

        List<Character> characterList = characterCollection.getCharacterList();
        Map<Character, Integer> characterMap = characterCollection.getCharacterMap();
        Map<Character, Integer> resultMap = new HashMap<>();
        int sumOfResult = dividend%divisorsList.get(0); //this is to check the boundary conditions min-max length
        if(sumOfResult!=0){
            resultMap.put(characterList.get(0),sumOfResult);
        }
        for(int i = 1; i < characterList.size(); i++){
            int base = dividend/divisorsList.get(i-1);
            int temp = characterMap.get(characterList.get(i))+1;
            int resultOfModulo = base%temp;
            if(resultOfModulo!=0){
                resultMap.put(characterList.get(i),resultOfModulo);
                sumOfResult += resultOfModulo;
            }
        }
        if (sumOfResult<inputData.getMinLength() || sumOfResult>inputData.getMaxLength()){
            resultMap= new HashMap<>();
        }
        return resultMap;
    }
}
