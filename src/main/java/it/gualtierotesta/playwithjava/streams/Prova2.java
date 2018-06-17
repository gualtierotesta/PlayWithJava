package it.gualtierotesta.playwithjava.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Prova2 {

    private static final String[] VALUES = {
            "zero",
            "one",
            "two",
            "three"
    };


    Set<String> nfLongestsSet(final int minLength) {
        Set<String> set = new HashSet<>(VALUES.length);
        for(final String str : VALUES) {
            if (str.length() >= minLength) {
                set.add(str);
            }
        }
        return set;
    }


    public Set<String> fLongestsSet(final int minLength) {
        return Arrays.stream(VALUES)
                .filter(s -> s.length() >= minLength)
                .collect(Collectors.toSet());

    }
}
