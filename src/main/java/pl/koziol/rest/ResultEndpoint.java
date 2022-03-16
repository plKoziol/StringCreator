package pl.koziol.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.koziol.service.UniqueStringService;


import java.util.List;

@RequiredArgsConstructor
@RestController()
public class ResultEndpoint {

    private final UniqueStringService unique;

    @GetMapping("/sorted/process/{id}")
    public List<String> resultFor1Process(@PathVariable int id){
        return unique.getResultById(id);
    }

    @GetMapping("/active/process")
    public Integer resultFor1Process(){
        return unique.getActiveProcesses();
    }
}
