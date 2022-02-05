package pl.koziol.service;

import pl.koziol.model.InputData;
import pl.koziol.service.impl.CombinationAnalysisImpl;
import pl.koziol.service.impl.DatabaseRelationsImpl;
import pl.koziol.service.impl.FirstLevelProductWithoutPermutationImpl;
import pl.koziol.service.impl.SecondLevelProductSetImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UniqueStringService {
    public void createUniqueWords (int minLength, int maxLength, String inputCharacter, int numberOfString);
    public int getActiveProcesses ();
    public List<String> getResultById (int id);



}
