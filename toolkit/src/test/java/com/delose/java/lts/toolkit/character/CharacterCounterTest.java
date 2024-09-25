package com.delose.java.lts.toolkit.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterCounterTest {

    CharacterCounter counter;

    @BeforeEach
    public void setUp() {
        counter = new CharacterCounter();
    }

    @Test
    public void givenLetterA_whenGetLetterIndex_thenLetterIndexIs0() {
        //given
        char letter = 'A';
        //when
        int letterCount = counter.getLetterIndex(letter);
        //then
        Assertions.assertEquals(0, letterCount);
    }

}
