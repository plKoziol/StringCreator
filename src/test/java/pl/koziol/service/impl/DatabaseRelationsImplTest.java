package pl.koziol.service.impl;

import org.junit.jupiter.api.Test;
import pl.koziol.model.InputData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseRelationsImplTest {
    DatabaseRelationsImpl s = new DatabaseRelationsImpl();


    @Test
    void selectMaxID() {
        s.clearDataBases();
        InputData inputData = new InputData(1,2,2,"abc",4);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        assertEquals(3,s.selectMaxID());

    }

    @Test
    void insertInputData() {
        s.clearDataBases();

        InputData inputData = new InputData(1,2,2,"abc",4);
        assertEquals(1,s.insertInputData(inputData));
        assertEquals(2,s.insertInputData(inputData));
        assertEquals(3,s.insertInputData(inputData));
        assertEquals(4,s.insertInputData(inputData));
        assertEquals(5,s.insertInputData(inputData));
        assertEquals(6,s.insertInputData(inputData));


    }

    @Test
    void completedProcesses() {
        s.clearDataBases();
        InputData inputData = new InputData(1,2,2,"abc",4);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        s.confirmTerminated(2);
        s.confirmTerminated(5);
        assertEquals(2,s.completedProcesses().size());


    }

    @Test
    void insertResult() {
        s.clearDataBases();
        InputData inputData = new InputData(1,2,2,"abc",4);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        Set<String> list = new HashSet<>();
        list.add("asdasfafsaf");
        list.add("asdasfasfsaf");
        list.add("assadafsaf");
        list.add("asdsfasfafsaf");
        list.add("asdafaasdsfafsaf");
        list.add("asdafasfsdasdafsaf");
        list.add("asdaasdfasfafsaf");
        list.add("asdafasfsdadafsaf");
        assertTrue(s.insertResult(2,list,0,4));
    }


    @Test
    void presentResults() {
        s.clearDataBases();
        InputData inputData = new InputData(1,2,2,"abc",4);
        s.insertInputData(inputData);
        s.insertInputData(inputData);
        Set<String> list = new HashSet<>();
        list.add("asdasfafsaf");
        list.add("asdasfasfsaf");
        list.add("assadafsaf");
        list.add("asdsfasfafsaf");
        list.add("asdafaasdsfafsaf");
        list.add("asdafasfsdasdafsaf");
        list.add("asdaasdfasfafsaf");
        list.add("asdafasfsdadafsaf");
        s.insertResult(2,list,0,4);
        s.presentResults(2);
        s.presentResults(1);
        assertTrue(s.checkTerminated(2));
        assertFalse(s.checkTerminated(1));
    }
}