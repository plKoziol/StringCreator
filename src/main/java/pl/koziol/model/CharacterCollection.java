package pl.koziol.model;

import java.util.HashMap;
import java.util.List;

public class CharacterCollection {
    private List<Character>  characterList;
    private HashMap<Character, Integer> characterMap;
    private String inputCharacter;

    public CharacterCollection(List<Character> characterList, HashMap<Character, Integer> characterMap, String inputCharacter) {
        this.characterList = characterList;
        this.characterMap = characterMap;
        this.inputCharacter = inputCharacter;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public HashMap<Character, Integer> getCharacterMap() {
        return characterMap;
    }

    public void setCharacterMap(HashMap<Character, Integer> characterMap) {
        this.characterMap = characterMap;
    }

    public String getInputCharacter() {
        return inputCharacter;
    }

    public void setInputCharacter(String inputCharacter) {
        this.inputCharacter = inputCharacter;
    }
}
