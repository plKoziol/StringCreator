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


    @Test
    void allUniqueWordGenerator() {
        FirstLevelProductWithoutPermutation fL = new FirstLevelProductWithoutPermutationImpl();
        /* Tests not verified information about size of list of result. The variable numberOfString is not important it will be implemented in different class.
        Validation possible length of String is realize by different class, due to the fact that
        there is no predetermined word formation order, so the number of words should be mor taken for testing.

         */
        InputData inputData = new InputData(1,4,"abbcdef",10000);
        Set<String> testedSet = secondLevelProductSet.allUniqueWordGenerator(fL.listOfMapForOneCombination(inputData), inputData);
        assertTrue(testedSet.contains("a"));
        assertTrue(testedSet.contains("b"));
        assertTrue(testedSet.contains("c"));
        assertTrue(testedSet.contains("d"));
        assertTrue(testedSet.contains("e"));
        assertTrue(testedSet.contains("f"));
        assertTrue(testedSet.contains("bb"));
        assertTrue(testedSet.contains("bfb"));
        assertTrue(testedSet.contains("bba"));
        assertTrue(testedSet.contains("fbda"));
        assertTrue(testedSet.contains("bcbd"));
        assertTrue(testedSet.contains("abbe"));
        assertTrue(testedSet.contains("cdef"));
        assertFalse(testedSet.contains(""));
        assertFalse(testedSet.contains("aass"));
        assertFalse(testedSet.contains("sgsg"));
        assertFalse(testedSet.contains("bbbbbb"));
        assertFalse(testedSet.contains("abbcde"));
        assertFalse(testedSet.contains("abbcdef"));
        assertFalse(testedSet.contains("abbcef"));

    }
}