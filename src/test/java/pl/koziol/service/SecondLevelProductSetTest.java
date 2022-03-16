package pl.koziol.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SecondLevelProductSetTest {
    SecondLevelProductSet secondLevelProductSet = new SecondLevelProductSet();

    @Test
    void arrayCreator() {
        Map testMap1 = new HashMap<>();
        testMap1.put('a',2);
        testMap1.put('b',1);
        char[] arr = {'a','a','b'};
        assertTrue(String.valueOf(arr).equals(String.valueOf(secondLevelProductSet.arrayCreator(testMap1))));
    }

    @Test
    void uniqueWordFor1CombinationGenerator() {
        char[] arr = {'a','a','b'};
        secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr);
        Set<String> stringSet = secondLevelProductSet.uniqueWordFor1CombinationGenerator(arr);
        assertTrue(secondLevelProductSet.setSingleResult.isEmpty());
        assertTrue(stringSet.contains("aba"));
        assertTrue(stringSet.contains("aab"));
        assertTrue(stringSet.contains("baa"));
        assertFalse(stringSet.contains("bba"));
        assertFalse(stringSet.contains("bbb"));
        assertFalse(stringSet.contains("aaa"));
        assertFalse(stringSet.contains("bbaa"));
        assertEquals(3,stringSet.size());

    }

}