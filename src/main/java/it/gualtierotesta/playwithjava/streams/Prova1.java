package it.gualtierotesta.playwithjava.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Prova1 {

    private static final String[] VALUES = {
            "zero",
            "one",
            "two",
            "three"
    };


    public String nfLongestString() {
        String longest = "";
        for (String str : VALUES) {
            if (longest.length() < str.length()) {
                longest = str;
            }
        }
        return longest;
    }

    public String f1LongestString() {
        Optional<String> optionalMax =
                Arrays.stream(VALUES)
                        .max(Comparator.comparingInt(String::length));
        return optionalMax.get();
    }


    public String f2LongestString() {
        Optional<String> optionalMax =
                Arrays.stream(VALUES)
                        .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        return optionalMax.get();
    }
}
