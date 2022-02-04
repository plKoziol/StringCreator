package pl.koziol.service;

import pl.koziol.model.CharacterCollection;
import pl.koziol.model.InputData;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CombinationAnalysis {
    /**
     * This function returns boolean that confirms the possibility of performing the input number of operations
     */
    public boolean sufficientNumberOfCombinations(InputData inputData, List<Map<Character, Integer>> listFromFirstLevel);


}
