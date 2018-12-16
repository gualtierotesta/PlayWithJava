package it.gualtierotesta.playwithjava.java11;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AClassTest {

    @Test
    public void testAMethod() {
        System.out.println("XXX Unit test");
        Assertions.assertNotNull(AClass.aMethod());
    }
}
