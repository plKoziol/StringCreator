package pl.koziol.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class UniqueString {
    @Id
    private int id;
    private String uniqueString;
    private int idProcess;

    public UniqueString(String element, int id) {
        this.uniqueString =element;
        this.idProcess = id;
    }
}
