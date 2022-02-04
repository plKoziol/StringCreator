package pl.koziol.service;

import pl.koziol.model.InputData;

import java.util.List;
import java.util.Map;

public interface FirstLevelProductWithoutPermutation {
    /**
     * This function returns a list of maps containing all possible character combinations and their number.
     * CharacterCollectionGenerator is used to analyze the input data.
     */
    List<Map<Character, Integer>> listOfMapForOneCombination(InputData inputData);
}
