package it.gualtierotesta.playwithjava.kata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllInclusiveTest {

    private static void testing(Boolean actual, Boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests containAllRots");
        testing(AllInclusive.containAllRots("", Arrays.asList()), true);
        List<String> a = Arrays.asList("bsjq", "qbsj");
        testing(AllInclusive.containAllRots("", a), true);
        a = Arrays.asList("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs");
        testing(AllInclusive.containAllRots("bsjq", a), true);
        a = Arrays.asList("TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY");
        testing(AllInclusive.containAllRots("XjYABhR", a), false);
    }
}