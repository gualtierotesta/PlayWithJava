package it.gualtierotesta.playwithjava.java11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AClassTest {

    @Test
    void testAMethod() {

        Assertions.assertNotNull(AClass.aMethod());
    }
}