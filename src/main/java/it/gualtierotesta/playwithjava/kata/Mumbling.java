package it.gualtierotesta.playwithjava.kata;


import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * accum("abcd") // -> "A-Bb-Ccc-Dddd"
 * accum("RqaEzty") // -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
 * accum("cwAt") // -> "C-Ww-Aaa-Tttt"
 */
public class Mumbling {

    public static String accum(String s) {

        return IntStream.range(0, s.length())
                .mapToObj(i -> repeatCamel(s.charAt(i), i + 1))
                .collect(Collectors.joining("-"));
    }

    private static String repeatCamel(final char c, final int count) {
        StringBuilder res = new StringBuilder(count);
        res.append(Character.toUpperCase(c));
        for (int j = 1; j < count; j++) {
            res.append(Character.toLowerCase(c));
        }
        return res.toString();
    }
}
