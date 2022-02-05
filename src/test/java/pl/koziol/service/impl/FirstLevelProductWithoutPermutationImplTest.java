package pl.koziol.service.impl;


import org.junit.Test;
import pl.koziol.model.InputData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FirstLevelProductWithoutPermutationImplTest {

    public FirstLevelProductWithoutPermutationImpl firstLevelProductWithoutPermutation = new FirstLevelProductWithoutPermutationImpl();


    @Test
    public void listOfMapForOneCombinationTest1(){
        // Tests not verified information about size of list of result. The variable numberOfString is not important it will be implemented in different class.
        InputData inputData = new InputData(1,2,2,"abc",4);
        int mapSize = firstLevelProductWithoutPermutation.listOfMapForOneCombination(inputData).size();
        assertEquals(3,mapSize);
    }
    @Test
    public void listOfMapForOneCombinationTest2(){
        // Tests not verified information about size of list of result. The variable numberOfString is not important it will be implemented in different class.
        InputData inputData = new InputData(1,2,2,"abc",4);
        Map testMap1 = new HashMap<>();
        testMap1.put('a',1);
        testMap1.put('b',1);
        Map testMap2 = new HashMap<>();
        testMap2.put('a',1);
        testMap2.put('c',1);
        Map testMap3 = new HashMap<>();
        testMap3.put('b',1);
        testMap3.put('c',1);
        List<Map> list = new ArrayList<>();
        list.add(testMap1);
        list.add(testMap2);
        list.add(testMap3);
        List testedList = firstLevelProductWithoutPermutation.listOfMapForOneCombination(inputData);
        assertEquals(list,testedList);
    }
    @Test
    public void listOfMapForOneCombinationTest3(){
        // Tests not verified information about size of list of result. The variable numberOfString is not important it will be implemented in different class.
        InputData inputData = new InputData(1,2,2,"aba",4);
        Map testMap1 = new HashMap<>();
        testMap1.put('a',2);
        Map testMap2 = new HashMap<>();
        testMap2.put('a',1);
        testMap2.put('b',1);
        List<Map> list = new ArrayList<>();
        list.add(testMap1);
        list.add(testMap2);
        List testedList = firstLevelProductWithoutPermutation.listOfMapForOneCombination(inputData);
        assertEquals(list,testedList);
    }
    @Test
    public void listOfMapForOneCombinationTest4(){
        // Tests not verified information about size of list of result. The variable numberOfString is not important it will be implemented in different class.
        InputData inputData = new InputData(1,1,3,"abc",4);
        Map testMap1 = new HashMap<>();
        testMap1.put('a',1);
        Map testMap2 = new HashMap<>();
        testMap2.put('b',1);
        Map testMap3 = new HashMap<>();
        testMap3.put('c',1);
        Map testMap4 = new HashMap<>();
        testMap4.put('a',1);
        testMap4.put('b',1);
        Map testMap5 = new HashMap<>();
        testMap5.put('a',1);
        testMap5.put('c',1);
        Map testMap6 = new HashMap<>();
        testMap6.put('b',1);
        testMap6.put('c',1);
        Map testMap7 = new HashMap<>();
        testMap7.put('a',1);
        testMap7.put('b',1);
        testMap7.put('c',1);
        List<Map> list = new ArrayList<>();
        list.add(testMap1);
        list.add(testMap2);
        list.add(testMap4);
        list.add(testMap3);
        list.add(testMap5);
        list.add(testMap6);
        list.add(testMap7);
        List testedList = firstLevelProductWithoutPermutation.listOfMapForOneCombination(inputData);
        assertEquals(list,testedList);
    }

}