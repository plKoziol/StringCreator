package pl.koziol.service;

import pl.koziol.model.InputData;

import java.util.List;
import java.util.Set;

public interface DatabaseRelations {

    public int selectMaxID();
    public int insertInputData(InputData inputData);
    public List<InputData> completedProcesses();
    public boolean clearDataBases();
    public boolean insertResult (int id, Set<String> list);
    public List<String> presentResults (int id);


}
