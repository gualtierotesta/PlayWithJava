package it.gualtierotesta.playwithjava.java17;

public record RecordA(int c, String s) {

    // Costruttore canonico che verifica solo i parametri.
    // L'assegnamento è automatico
    public RecordA {
        if (c < 0) {
            throw new IllegalArgumentException("c deve essere maggiore di zero");
        }
        if (s == null) {
            throw new IllegalArgumentException("s non deve essere nulla");
        }
    }

    // Factory method
    public static RecordA create(final int c, final String s) {
        return new RecordA(c, s);
    }

}
