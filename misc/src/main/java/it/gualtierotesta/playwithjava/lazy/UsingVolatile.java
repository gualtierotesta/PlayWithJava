package it.gualtierotesta.playwithjava.lazy;

public class UsingVolatile {

    private volatile String data;
    private final Object lock = new Object();

    public String getData() {
        if (data == null) {
            synchronized (lock) {
                if (data == null) {   // double-checked locking
                    data = heavyComputation();
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
