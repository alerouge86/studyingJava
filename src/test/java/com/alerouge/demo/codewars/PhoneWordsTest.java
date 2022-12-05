package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneWordsTest {

    @Test
    void edgeCasesTest(){
        assertEquals("", PhoneWords.phoneWords(""));
        assertEquals("", PhoneWords.phoneWords(null));
        assertEquals("", PhoneWords.phoneWords("111"));
    }

    @Test
    void basicTest() {
        assertEquals("ho kata", PhoneWords.phoneWords("44666055282"));
        assertEquals("kata", PhoneWords.phoneWords("55282"));
        assertEquals("hello how are you", PhoneWords.phoneWords("443355555566604466690277733099966688"));
        assertEquals("im a tester", PhoneWords.phoneWords("44460208337777833777"));
        assertEquals("codewars", PhoneWords.phoneWords("22266631339277717777"));
        assertEquals("null", PhoneWords.phoneWords("66885551555"));
        assertEquals("text", PhoneWords.phoneWords("833998"));

        assertEquals("   ", PhoneWords.phoneWords("000"));

        assertEquals("java", PhoneWords.phoneWords("528882"));
        assertEquals("kumite", PhoneWords.phoneWords("55886444833"));
        assertEquals("apple", PhoneWords.phoneWords("271755533"));
    }
}