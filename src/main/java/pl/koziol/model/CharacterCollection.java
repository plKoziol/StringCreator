package pl.koziol.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class CharacterCollection {
    private List<Character>  characterList;
    private HashMap<Character, Integer> characterMap;
    private String inputCharacter;

}
