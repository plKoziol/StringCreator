package pl.koziol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.koziol.model.CharacterCollection;
import pl.koziol.model.InputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class FirstLevelProductWithoutPermutation {

    private final CombinationAnalysis combinationAnalysis;
    private final CharacterCollectionGenerator characterCollectionGenerator;
    private CharacterCollection characterCollection;

    /**
     * This function returns a list of maps containing all possible character combinations and their number.
     * CharacterCollectionGenerator is used to analyze the input data.
     */
    public List<Map<Character, Long>> listOfMapForOneCombination(InputData inputData) {
        characterCollection = characterCollectionGenerator.collectionCreator(inputData);
        List<Long> numberOperations = numberOperationCounter(characterCollection);
        List<Map<Character,Long>> resultList = new ArrayList<>();
        long maxValueOperation = numberOperations.get(numberOperations.size()-1);
        long sumCombinationAnalysis = 0;
        for(long i = 0; i < maxValueOperation; i++){
            Map<Character,Long> singleMap = singleSolution(characterCollection,numberOperations,i,inputData);
            if(!singleMap.isEmpty()){
                resultList.add(singleMap);
            }
            int lengthOfWord =0;
            for(Long aLong:singleMap.values()){
                lengthOfWord += aLong;
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

    private List<Long> numberOperationCounter (CharacterCollection characterCollection){
        List<Long> resultList = new ArrayList<>();
        long result = 1;
        Map<Character,Integer> map = characterCollection.getCharacterMap();
        List<Character> list = characterCollection.getCharacterList();
        for (Character character : list) {
            result *= map.get(character) + 1;
            resultList.add(result);
        }

        return resultList;
    }
    private Map<Character,Long> singleSolution(CharacterCollection characterCollection, List<Long> divisorsList, Long dividend, InputData inputData){

        List<Character> characterList = characterCollection.getCharacterList();
        HashMap<Character, Integer> characterMap = characterCollection.getCharacterMap();
        Map<Character, Long> resultMap = new HashMap<>();
        long sumOfResult = dividend%divisorsList.get(0); //this is to check the boundary conditions min-max length
        if(sumOfResult!=0){
            resultMap.put(characterList.get(0),sumOfResult);
        }
        for(int i = 1; i < characterList.size(); i++){
            long base = dividend/divisorsList.get(i-1);
            int temp = characterMap.get(characterList.get(i))+1;
            long resultOfModulo = base%temp;
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
