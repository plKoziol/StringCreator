package pl.koziol.service.impl;

import org.junit.jupiter.api.Test;
import pl.koziol.model.InputData;
import pl.koziol.service.FirstLevelProductWithoutPermutation;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SecondLevelProductSetImplTest {
    SecondLevelProductSetImpl secondLevelProductSet = new SecondLevelProductSetImpl();

    @Test
    void arrayCreator() {
        Map testMap1 = new HashMap<>();
        testMap1.put('a',2);
        testMap1.put('b',1);
        char[] arr = {'a','a','b'};
        String expected = String.valueOf(arr);
        String actual = String.valueOf(secondLevelProductSet.arrayCreator(testMap1));
        assertTrue(expected.equals(actual));
    }

    @Test
    void uniqueWordFor1CombinationGenerator() {
        char[] arr = {'a','a','b'};
        secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr);
        secondLevelProductSet.setSingleResult.isEmpty();
        assertTrue(secondLevelProductSet.setSingleResult.isEmpty());
        assertTrue(secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).contains("aba"));
        assertTrue(secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).contains("aab"));
        assertTrue(secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).contains("baa"));
        assertFalse(secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).contains("bba"));
        assertFalse(secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).contains("bbb"));
        assertFalse(secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).contains("aaa"));
        assertFalse(secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).contains("bbaa"));
        assertEquals(3,secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr).size());

    }

}