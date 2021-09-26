package it.gualtierotesta.playwithjava.lazy;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Lazy initialization using atomic reference
 * <p>
 * https://stackoverflow.com/questions/30265427/lock-free-and-wait-free-thread-safe-lazy-initialization
 */
public class UsingAtomicReference {

    private final AtomicReference<String> refData = new AtomicReference<>(null);

    public String getData() {
        System.out.println("getData");
        String data = refData.get();
        if (data == null) {
            data = heavyComputation();
            return refData.compareAndSet(null, data) ? data : refData.get();
        }
        return data;
    }


    private String heavyComputation() {
        System.out.println("Heavy computation");
        return "value";
    }
}
