package pl.koziol.rest;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.koziol.model.InputData;
import pl.koziol.service.DatabaseRelations;
import pl.koziol.service.UniqueStringService;


@RestController()
@RequiredArgsConstructor
public class InputDataEndpoint {

    private final UniqueStringService process;
    private final DatabaseRelations db;

    @PostMapping("/add/new")
    public void startProcess(@RequestBody InputData inputData){
        process.createUniqueWords(
                inputData.getMinLength(),
                inputData.getMaxLength(),
                inputData.getInputCharacter(),
                inputData.getNumberOfString());
    }

    @GetMapping("/completed/processes")
    public List<InputData> completedProcesses(){
        //todo Przerobić na współprace z nową bazą danych
        return db.completedProcesses();
    }

}


