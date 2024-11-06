package it.gualtierotesta.playwithjava;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {

    @Test
    void testKata() {
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("hisTay   siay ymay tringsay", pigIt("This   is my string"));

    }


    static String pigIt(String phrase) {

        Map<String, String> words = Arrays.stream(phrase.split("\\s+"))
                .collect(Collectors.toMap(Function.identity(), convertWord()));

        System.out.println("words = " + words);
        String replacedPhrase = phrase;
        for (Map.Entry<String, String> entry : words.entrySet()) {
            replacedPhrase = replacedPhrase.replaceFirst(entry.getKey(), entry.getValue());
        }
        System.out.println("phrase = " + phrase);
        System.out.println("replacedPhrase = " + replacedPhrase);
        return replacedPhrase;

    }

    private static Function<String, String> convertWord() {
        return w -> {
            StringBuilder sb = new StringBuilder(w.substring(1));
            sb.append(w.charAt(0)).append("ay");
            return sb.toString();
        };
    }


}
