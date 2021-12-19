package it.gualtierotesta.playwithjava.collections;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapsTest {

    private static final Integer KEY1 = Integer.valueOf(1);
    private static final Integer KEY2 = Integer.valueOf(2);
    private static final Integer KEY_WITHOUT_VALUE = Integer.valueOf(0);
    private static final Integer KEY_NOT_EXISTING = Integer.valueOf(99);

    private Map<Integer, String> map;

    @BeforeEach
    void beforeEach() {

        map = new HashMap<>();

        map = new HashMap<>();
        map.put(KEY1, "uno");
        map.put(KEY2, "due");
        map.put(KEY_WITHOUT_VALUE, null);
    }

    @Test
    void check_setup () {
        Assertions.assertThat(map.size()).isEqualTo(3);
    }
}
