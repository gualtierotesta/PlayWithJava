package it.gualtierotesta.playwithjava.java17;

public class MainSwitch {

    public static void main(final String[] args) {

        int mese = 3;
        int giorni = switch (mese) {
        case 3 -> 31;
        case 2 -> {
            System.out.println("Il mese più corto");
            yield 28;
        }
        default -> throw new IllegalArgumentException("Unexpected value: " + mese);
        };

        System.out.println("giorni=" + giorni);
    }
}
