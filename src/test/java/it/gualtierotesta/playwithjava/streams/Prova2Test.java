package it.gualtierotesta.playwithjava.streams;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class Prova2Test {

    private Prova2 sut = new Prova2();

    @Test
    void testNonFunctionalLongestsSet() {
        Set<String> res = sut.nfLongestsSet(4);
        assertThat(res).hasSize(2).contains("three", "zero");
    }

    @Test
    void testFunctionalLongestsSet() {
        Set<String> res = sut.fLongestsSet(4);
        assertThat(res).hasSize(2).contains("three", "zero");
    }
}