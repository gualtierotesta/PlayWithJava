package it.gualtierotesta.playwithjava.lazy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsingAtomicReferenceImprovedTest {


    @Test
    void initializeInstance() {
        UsingAtomicReferenceImproved sut = new UsingAtomicReferenceImproved();
        assertThat(sut.getData()).isNotNull();
        assertThat(sut.getData()).isNotNull();
    }

}