package pl.koziol.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import pl.koziol.model.InputData;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class CombinationAnalysisTest {

    private final CombinationAnalysis cA;
    private final FirstLevelProductWithoutPermutation fL;

    @Test
    void sufficientNumberOfCombinations() {
        InputData inputData = new InputData();
        inputData.setMinLength(1);
        inputData.setMaxLength(4);
        inputData.setInputCharacter("abbcdf");
        inputData.setNumberOfString(100);
        assertTrue(cA.sufficientNumberOfCombinations(inputData,fL.listOfMapForOneCombination(inputData)));
        InputData inputData2 = new InputData();
        inputData2.setMinLength(1);
        inputData2.setMaxLength(6);
        inputData2.setInputCharacter("abbcdf");
        inputData2.setNumberOfString(1000);
        assertTrue(cA.sufficientNumberOfCombinations(inputData2,fL.listOfMapForOneCombination(inputData2)));
        InputData inputData3 = new InputData();
        inputData3.setMinLength(1);
        inputData3.setMaxLength(3);
        inputData3.setInputCharacter("abb");
        inputData3.setNumberOfString(3);
        assertTrue(cA.sufficientNumberOfCombinations(inputData3,fL.listOfMapForOneCombination(inputData3)));
        InputData inputData4 = new InputData();
        inputData4.setMinLength(1);
        inputData4.setMaxLength(2);
        inputData4.setInputCharacter("12fvdf");
        inputData4.setNumberOfString(2);
        assertTrue(cA.sufficientNumberOfCombinations(inputData4,fL.listOfMapForOneCombination(inputData4)));
        InputData inputData5 = new InputData();
        inputData5.setMinLength(6);
        inputData5.setMaxLength(6);
        inputData5.setInputCharacter("abcbcc");
        inputData5.setNumberOfString(61);
        assertFalse(cA.sufficientNumberOfCombinations(inputData5,fL.listOfMapForOneCombination(inputData5)));
        InputData inputData6 = new InputData();
        inputData6.setMinLength(3);
        inputData6.setMaxLength(3);
        inputData6.setInputCharacter("abb");
        inputData6.setNumberOfString(4);
        assertFalse(cA.sufficientNumberOfCombinations(inputData6,fL.listOfMapForOneCombination(inputData6)));
    }


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