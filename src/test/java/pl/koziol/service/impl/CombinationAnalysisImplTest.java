package pl.koziol.service.impl;

import org.junit.jupiter.api.Test;
import pl.koziol.model.InputData;
import pl.koziol.service.CombinationAnalysis;
import pl.koziol.service.FirstLevelProductWithoutPermutation;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CombinationAnalysisImplTest {
    CombinationAnalysisImpl cA = new CombinationAnalysisImpl();

    @Test
    void sufficientNumberOfCombinations() {
        FirstLevelProductWithoutPermutation fL = new FirstLevelProductWithoutPermutationImpl();
        InputData inputData = new InputData(1,4,"abbcdf",100);
        assertTrue(cA.sufficientNumberOfCombinations(inputData,fL.listOfMapForOneCombination(inputData)));
        InputData inputData2 = new InputData(1,6,"abbcdf",1000);
        assertTrue(cA.sufficientNumberOfCombinations(inputData2,fL.listOfMapForOneCombination(inputData2)));
        InputData inputData3 = new InputData(3,3,"abb",3);
        assertTrue(cA.sufficientNumberOfCombinations(inputData3,fL.listOfMapForOneCombination(inputData3)));
        InputData inputData4 = new InputData(6,6,"abcbcc",60);
        assertTrue(cA.sufficientNumberOfCombinations(inputData4,fL.listOfMapForOneCombination(inputData4)));
        InputData inputData5 = new InputData(6,6,"abcbcc",61);
        assertFalse(cA.sufficientNumberOfCombinations(inputData5,fL.listOfMapForOneCombination(inputData5)));
        InputData inputData6 = new InputData(3,3,"abb",4);
        assertFalse(cA.sufficientNumberOfCombinations(inputData6,fL.listOfMapForOneCombination(inputData6)));
    }

    @Test
    void numberOfCombinationForm1Map() {
        Map testMap1 = new HashMap<>();
        testMap1.put('a',1);
        testMap1.put('b',2);
        assertEquals(3,cA.numberOfCombinationForm1Map(testMap1));
        Map testMap2 = new HashMap<>();
        testMap2.put('a',1);
        testMap2.put('b',2);
        testMap2.put('c',3);
        assertEquals(60,cA.numberOfCombinationForm1Map(testMap2));
    }
}