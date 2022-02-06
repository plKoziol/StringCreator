package pl.koziol.service;

import pl.koziol.model.CharacterCollection;
import pl.koziol.model.InputData;

public interface CharacterCollectionGenerator {
    /**
     * This function returns a list of unique characters, a repetition map of the non-duplicate characters, and the input word.
     * This data is represented by class CharacterCollection
     * This is the raw data resulting from the input String analysis
     * */
    CharacterCollection collectionCreator (InputData inputData);

}
