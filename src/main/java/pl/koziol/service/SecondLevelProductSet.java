package pl.koziol.service;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class SecondLevelProductSet {

    /**
     * The method returns an array of characters from which you can create a unique word consistent with the input parameters
     */
    public char[] arrayCreator(Map<Character,Integer> map) {
        List<Integer> list = new ArrayList<>(map.values());
        int sum = 0;
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

    /**
     * the method returns a set collection with unique words from the given array
     */
    public Set uniqueWordFor1CombinationGenerator(char[] array) {
        Set<String> set = new HashSet<>(setSingleResult);
        permutation(array,0);
        setSingleResult.removeAll(set);
        return set;
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
