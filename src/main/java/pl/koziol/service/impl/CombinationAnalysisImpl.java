package pl.koziol.service.impl;

import pl.koziol.model.InputData;
import pl.koziol.service.CombinationAnalysis;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CombinationAnalysisImpl implements CombinationAnalysis {

    @Override
    public boolean sufficientNumberOfCombinations(InputData inputData, List<Map<Character, Integer>> list) {
        int declaredNumberOfOperation = inputData.getNumberOfString();
        int result = 0;
        for(Map map: list){
            result += numberOfCombinationForm1Map(map);
            if(declaredNumberOfOperation <= result){
                return true;
            }
        }
        return false;
    }
    protected int numberOfCombinationForm1Map (Map<Character, Integer> map){
        int result = 1;
        List<Integer> listValue = new ArrayList<>();
        listValue.addAll(map.values());
        AtomicInteger sizeOfWord = new AtomicInteger();
        listValue.stream().forEach(e -> sizeOfWord.addAndGet(e));
        int remainingFreeSpace = sizeOfWord.get();
        for(Integer element:listValue){
            if(element==1){
                result *= remainingFreeSpace;
                remainingFreeSpace -= 1;
            } else {
                int temp = factorial(remainingFreeSpace);
                temp /= factorial(remainingFreeSpace-element);
                temp /= factorial(element);
                result *= temp;
                remainingFreeSpace -= element;
            }
        }
        return result;
    }
    private int factorial (int n) {
        int a = 1;
        for (int i=1; i<=n; i++) {
            a *= i;
        }
        return a;
    }
}
