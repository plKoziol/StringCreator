package pl.koziol.service;

import pl.koziol.model.InputData;

import java.util.List;
import java.util.Set;

public interface DatabaseRelations {
    /**
     * this method return number last record.
     * It is responsible for finding the last record of the database.
    * */
    int selectMaxID();
    /**
     * This method returns the number of the entered process, in case of error it returns 0.
     * It is responsible for enters data into the process table.
     * */
    int insertInputData(InputData inputData);

    /**
     * This method returns a list of successfully completed processes.
     */
    List<InputData> completedProcesses();

    /**
     * The method returns true if the array is cleared. Only used for tests
     * The program does not clean the database
     */
    boolean clearDataBases();

    /**
     * The method returns true if the results of a given process have been correctly placed in the database.
     * Additionally, the method makes sure that the exact number of declared results is placed.
     * For this purpose, it takes the maximum number of words and entered so far.
     */
    boolean insertResult (int id, Set<String> list, int enteredData, int maxEnteredData);

    /**
     * the method returns a list of strings with results for the process with the specified id.
     */
    List<String> presentResults (int id);


}
