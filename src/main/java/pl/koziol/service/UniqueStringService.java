package pl.koziol.service;


import java.util.List;
/**
 * Interface representing the basic functions of the program and the business logic.
 */
public interface UniqueStringService {

    /**
     * The method that takes parameters, saves the process in the database, starts calculations and stores their results in the database.
     */
    void createUniqueWords (int minLength, int maxLength, String inputCharacter, int numberOfString);

    /**
     * The method that returns the number of active processes
     */
    int getActiveProcesses ();

    /**
     * The method returns a list of strings with results for the process with the specified id.
     */
    List<String> getResultById (int id);
}
