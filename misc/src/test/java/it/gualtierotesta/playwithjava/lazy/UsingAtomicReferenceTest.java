package it.gualtierotesta.playwithjava.lazy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsingAtomicReferenceTest {

    @Test
    void initializeInstance() {
        UsingAtomicReference sut = new UsingAtomicReference();
        assertThat(sut.getData()).isNotNull();
        assertThat(sut.getData()).isNotNull();
    }
}