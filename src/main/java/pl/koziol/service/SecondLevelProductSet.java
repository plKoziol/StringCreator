package pl.koziol.service;

import java.util.Map;
import java.util.Set;

public interface SecondLevelProductSet {
    /**
     * The method returns an array of characters from which you can create a unique word consistent with the input parameters
     */
    char[] arrayCreator (Map<Character,Integer> map);

    /**
     * the method returns a set collection with unique words from the given array
     */
    Set uniqueWordFor1CombinationGenerator(char [] array);

}
