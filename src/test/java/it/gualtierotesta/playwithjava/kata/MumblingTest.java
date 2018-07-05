package it.gualtierotesta.playwithjava.kata;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MumblingTest {

    private Mumbling sut = new Mumbling();

    @Test
    void testAccum() {
        assertThat(sut.accum("abcd")).isEqualTo("A-Bb-Ccc-Dddd");
        assertThat(sut.accum("RqaEzty")).isEqualTo("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy");
        assertThat(sut.accum("cwAt")).isEqualTo("C-Ww-Aaa-Tttt");
    }
}