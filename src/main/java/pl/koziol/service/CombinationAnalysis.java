package pl.koziol.service;

import org.springframework.stereotype.Service;
import pl.koziol.model.InputData;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class CombinationAnalysis {


    /**
     * This function returns boolean that confirms the possibility of performing the input number of operations
     */
    public boolean sufficientNumberOfCombinations(InputData inputData, List<Map<Character, Long>> list) {
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
    protected int numberOfCombinationForm1Map (Map<Character, Long> map){
        int result = 1;
        List<Long> listValue = new ArrayList<>(map.values());
        AtomicInteger sizeOfWord = new AtomicInteger();
        listValue.stream().forEach(e -> sizeOfWord.addAndGet((e.intValue())));
        int remainingFreeSpace = sizeOfWord.get();
        for(Long element:listValue){
            if(element==1){
                result *= remainingFreeSpace;
                remainingFreeSpace -= 1;
            } else {
                long temp = factorial(remainingFreeSpace);
                temp /= factorial(remainingFreeSpace-element);
                temp /= factorial(element);
                result *= temp;
                remainingFreeSpace -= element;
            }
        }
        return result;
    }
    private long factorial (long n) {
        long a = 1;
        for (int i=1; i<=n; i++) {
            a *= i;
        }
        return a;
    }
}
