package it.gualtierotesta.playwithjava.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class SimplePigLatinTest {

    @Test
    void test01() {
        assertEquals("Oay elloHay orldway !", pigIt("O Hello world !"));
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay !", pigIt("This is my string !"));
    }

    static String pigIt(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (word.length() > 0) {
                    words.add(processWord(word));
                    word.setLength(0);
                }
                words.add(String.valueOf(c));
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            words.add(processWord(word));
        }

        StringBuilder revisedText = new StringBuilder();
        for (String part : words) {
            revisedText.append(part);
        }
        return revisedText.toString();

    }

    private static String processWord(StringBuilder in) {
        var str = in.substring(1) + in.charAt(0);
        return in.length() > 1 || Character.isAlphabetic(in.charAt(0))? str + "ay" : str;
    }

}

// Soluzioni migliori:

// public static String pigIt(String str) {
//     return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
// }
