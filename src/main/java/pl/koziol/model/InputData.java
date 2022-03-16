package pl.koziol.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class InputData {
    @Id
    private int id;
    private int minLength;
    private int maxLength;
    private String inputCharacter;
    private int numberOfString;
    private boolean threadTerminated = false;

}
