package it.gualtierotesta.playwithjava.lazy;

import java.util.concurrent.atomic.AtomicReference;

/**
 * IMPROVED Lazy initialization using atomic reference
 * <p>
 * In this version heavyComputation is called just once while in the original version two
 * can be inside getData and execute heavyComputation in parallel (but only one result will be stored)
 * <p>
 * Inspired by Project Lombok Lazy (https://www.projectlombok.org/features/GetterLazy)
 */
public class UsingAtomicReferenceImproved {

    private final AtomicReference<String> refData = new AtomicReference<>(null);

    public String getData() {
        System.out.println("getData");
        String data = refData.get();
        if (data == null) {
            synchronized (refData) {
                data = refData.get();
                if (data == null) {  // double check
                    data = heavyComputation();
                    return refData.compareAndSet(null, data) ? data : refData.get();
                }
            }
        }
        return data;
    }


    private String heavyComputation() {
        System.out.println("Heavy computation");
        return "value";
    }
}
