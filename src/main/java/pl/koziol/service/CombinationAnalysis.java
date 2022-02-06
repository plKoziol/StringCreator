package pl.koziol.service;


import pl.koziol.model.InputData;

import java.util.List;
import java.util.Map;


public interface CombinationAnalysis {
    /**
     * This function returns boolean that confirms the possibility of performing the input number of operations
     */
    boolean sufficientNumberOfCombinations(InputData inputData, List<Map<Character, Integer>> listFromFirstLevel);


}
