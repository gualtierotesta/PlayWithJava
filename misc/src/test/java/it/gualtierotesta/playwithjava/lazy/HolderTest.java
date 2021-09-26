package it.gualtierotesta.playwithjava.lazy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class HolderTest {


    @Test
    void instanceCreation() {

        Holder holder = Holder.getInstance();
        assertNotNull(holder);
    }
}