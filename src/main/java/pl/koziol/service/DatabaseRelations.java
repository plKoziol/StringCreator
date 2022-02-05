package pl.koziol.service;

import pl.koziol.model.InputData;

import java.util.List;

public interface DatabaseRelations {

    public int selectMaxID();
    public int insertInputData(InputData inputData);
    public List<InputData> completedProcesses();
    public boolean clearDataBases();

}
