package it.gualtierotesta.playwithjava.java17;

public class MainTextBlocks {

    private static String s = """
        ciao,
         come <b>stai</b>?
         Io sto abbastanza \n\t"bene"
        """;

    public static void main(final String[] args) {
        System.out.println("s=" + s);

    }

}
