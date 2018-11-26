package it.gualtierotesta.playwithjava.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VasyaClerkTest {

    @Test
    void testMain() {
        assertEquals("YES", VasyaClerk.tickets(new int[] {25, 25, 50}));
        assertEquals("NO", VasyaClerk.tickets(new int[] {25, 100}));
        assertEquals("NO", VasyaClerk.tickets(new int[] {25, 25, 50, 50, 100}));
        assertEquals("YES", VasyaClerk.tickets(new int[] {}));
        assertEquals("NO", VasyaClerk.tickets(new int[] {100}));

        assertEquals("NO", VasyaClerk.tickets(new int[] {100, 25, 25, 25}));
        assertEquals("NO", VasyaClerk.tickets(new int[] {50, 25, 25}));
        assertEquals("NO", VasyaClerk.tickets(new int[] {25, 25, 25, 25, 25, 100, 100}));
    }
}