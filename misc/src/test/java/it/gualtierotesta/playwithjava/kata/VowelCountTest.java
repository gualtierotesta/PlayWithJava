package it.gualtierotesta.playwithjava.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VowelCountTest {

    @Test
    public void testCase1() {
        assertEquals(5, VowelCount.getCount("abracadabra"));
        assertEquals(0, VowelCount.getCount("qwrty"));
    }

}