package it.gualtierotesta.playwithjava.streams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Prova1Test {

    private Prova1 sut = new Prova1();

    @Test
    void testNonFunctionalLongestString() {
        String res = sut.nfLongestString();
        assertEquals("three", res);
    }

    @Test
    void testFunctional1LongestString() {
        String res = sut.f1LongestString();
        assertEquals("three", res);
    }

    @Test
    void testFunctional2LongestString() {
        String res = sut.f2LongestString();
        assertEquals("three", res);
    }


}