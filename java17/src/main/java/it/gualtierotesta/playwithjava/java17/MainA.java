package it.gualtierotesta.playwithjava.java17;

import java.util.Map;

public class MainA {

    public static void main(final String[] args) {
        // RecordA rec = new RecordA(42, null);
        RecordA rec = RecordA.create(42, "ciao");
        System.out.println("rec=" + rec);

        record MiaTupla(String s1, String s2) {
        }

        Map.of("k1", "v1", "k2", "v2")
            .entrySet().stream()
            .map(ent -> new MiaTupla(ent.getKey(), ent.getValue()))
            .toList()
            .forEach(System.out::println);

    }
}
