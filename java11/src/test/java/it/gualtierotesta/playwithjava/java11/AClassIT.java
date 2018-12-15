package it.gualtierotesta.playwithjava.java11;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AClassIT {

    @Test
    public void testAMethod() {
        System.out.println("XXX Integration test");
        Assertions.assertNotNull(AClass.anotherMethod());
    }
}
