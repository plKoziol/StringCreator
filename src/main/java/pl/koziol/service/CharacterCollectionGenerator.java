package pl.koziol.service;

import org.springframework.stereotype.Service;
import pl.koziol.model.CharacterCollection;
import pl.koziol.model.InputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class CharacterCollectionGenerator {
    /**
     * This function returns a list of unique characters, a repetition map of the non-duplicate characters, and the input word.
     * This data is represented by class CharacterCollection
     * This is the raw data resulting from the input String analysis
     * */

    public CharacterCollection collectionCreator(InputData inputData ) {
        String inputCharacter = inputData.getInputCharacter();
        int maxLength = inputData.getMaxLength();
        HashMap<Character, Integer> mapOfResult = new HashMap<>();
        List<Character> characterList = new ArrayList<>();

        for(int i = 0; i < inputCharacter.length(); i++){
            if(mapOfResult.containsKey(inputCharacter.charAt(i))){
                int temp = mapOfResult.get(inputCharacter.charAt(i));
                if(temp<maxLength){
                    mapOfResult.put(inputCharacter.charAt(i),temp+1);
                }
            } else {
                mapOfResult.put(inputCharacter.charAt(i),1);
                characterList.add(inputCharacter.charAt(i));
            }
        }
        CharacterCollection characterCollection = new CharacterCollection(characterList,mapOfResult, inputCharacter);
        return characterCollection;
    }

}
