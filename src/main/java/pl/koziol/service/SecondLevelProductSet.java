package pl.koziol.service;

import pl.koziol.model.InputData;
import pl.koziol.service.impl.FirstLevelProductWithoutPermutationImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SecondLevelProductSet {
    public char[] arrayCreator (Map<Character,Integer> map);
    public Set uniqueWordFor1CombinationGenerator(char [] array);

}
