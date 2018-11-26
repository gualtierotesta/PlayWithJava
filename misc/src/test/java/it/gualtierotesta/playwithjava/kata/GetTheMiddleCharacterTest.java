package it.gualtierotesta.playwithjava.kata;

import org.junit.jupiter.api.Test;

import static it.gualtierotesta.playwithjava.kata.GetTheMiddleCharacter.getMiddle;
import static org.assertj.core.api.Assertions.assertThat;

class GetTheMiddleCharacterTest {

    @Test
    void testSetup() {

        assertThat(getMiddle("test")).isEqualTo("es");
        assertThat(getMiddle("testing")).isEqualTo("t");
        assertThat(getMiddle("middle")).isEqualTo("dd");
        assertThat(getMiddle("A")).isEqualTo("A");
    }
}