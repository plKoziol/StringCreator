package pl.koziol.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueStringServiceImpTest {

    @Test
    void createUniqueWords() {
        UniqueStringServiceImp uniqueStringServiceImp = new UniqueStringServiceImp();
        uniqueStringServiceImp.createUniqueWords(1,1000,"asdfgh",10);

    }
}