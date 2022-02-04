package pl.koziol.service.impl;

import pl.koziol.model.CharacterCollection;
import pl.koziol.model.InputData;
import pl.koziol.service.CharacterCollectionGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CharacterCollectionGeneratorImpl implements CharacterCollectionGenerator {
    @Override
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
