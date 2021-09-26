package it.gualtierotesta.playwithjava.lazy;

/**
 * Complete class lazy initialization using on demand holder pattern
 *
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 */
public class Holder {

    public static Holder getInstance() {
        System.out.println("Get instance");
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        public static final Holder INSTANCE = new Holder();
    }

    private Holder() {
        heavyComputation();
    }

    private void heavyComputation() {
        System.out.println("Heavy computation");
    }
}
