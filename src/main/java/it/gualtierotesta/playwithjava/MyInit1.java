package it.gualtierotesta.playwithjava;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Initialization solution 1 class : atomic
 */
public class MyInit1 {

    private final AtomicBoolean initDone = new AtomicBoolean(false);

    public void doSomething () throws Exception {
        System.out.println("doSomething");
        doInit();
        Thread.sleep(500);
    }

    private void doInit() {
        System.out.println("doInit");
        if (initDone.compareAndSet(false, true)) {
            System.out.println("init");
        }
    }
}
