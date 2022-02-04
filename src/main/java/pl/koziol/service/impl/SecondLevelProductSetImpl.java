package pl.koziol.service.impl;

import pl.koziol.model.InputData;
import pl.koziol.service.SecondLevelProductSet;

import java.util.*;

public class SecondLevelProductSetImpl implements SecondLevelProductSet {


    @Override
    public char[] arrayCreator(Map<Character,Integer> map) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        list.addAll(map.values());
        for (Integer result : list){
            sum += result;
        }
        char[] resultArray = new char[sum];
        int counter = 0;
        Iterator<Character> iterator= map.keySet().iterator();
        while(iterator.hasNext()) {
            char temp = iterator.next();
            for (int i = 0; i < map.get(temp); i++){
                resultArray[counter] = temp;
                counter++;
            }
        }
        return resultArray;
    }

    @Override
    public Set uniqueWordFor1CombinationGenerator(char[] array) {
        Set<String> set = new HashSet<>();
        permutation(array,0);
        set.addAll(setSingleResult);
        setSingleResult.removeAll(set);
        return set;
    }


    @Override
    public Set allUniqueWordGenerator(List<Map<Character,Integer>> list, InputData inputData) {
        Set<String> resultSet = new HashSet();
        for(Map map : list){
            resultSet.addAll(uniqueWordFor1CombinationGenerator(arrayCreator(map)));
            if(inputData.getNumberOfString()<resultSet.size()){
                return resultSet;
            }
        }
        return resultSet;
    }
    protected Set<String> setSingleResult = new HashSet<>();
    char[] positionChanger (char[] inputArray, int first, int second) {
        char a = inputArray[first];
        char b = inputArray[second];
        inputArray[second]=a;
        inputArray[first]=b;
        return inputArray;

    }
    void permutation (char[] array, int position) {
        if (position == array.length) {
            setSingleResult.add(String.valueOf(array));
        } else {
            for (int i = position; i < array.length; i++) {
                array = positionChanger(array, i, position);
                permutation(array, position + 1);
                array =positionChanger(array, i, position);
            }
        }
    }
}
