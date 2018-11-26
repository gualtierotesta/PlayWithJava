package it.gualtierotesta.playwithjava.streams;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Prova3 {

    private static final List<MyBean> dati = Arrays.asList(
            new MyBean("Gualtiero Testa", LocalDate.of(1965, 3, 4)),
            new MyBean("Mario Rossi", LocalDate.of(1988, 4, 12)),
            new MyBean("Giovanni Bianchi", LocalDate.of(2003, 12, 31))
    );

    public static void main(String[] args) {
        Optional<MyBean> persona = dati.stream()
                .peek(b -> System.out.println("xx:" + b))
                .filter(b -> b.getNome().contains("Rossi"))
                .findAny();
        System.out.println(persona.get());
    }


}
