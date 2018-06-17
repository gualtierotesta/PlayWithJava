package it.gualtierotesta.playwithjava;


import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by gualtiero.testa on 20/03/2017.
 */
public class MyInit1Test {

    @Test
    public void testSynch() throws Exception {

        MyInit1 sut = new MyInit1();
        sut.doSomething();
        sut.doSomething();
    }

    @Test
    public void testMultiThread() throws Exception {

        int nThreads = 10;
        final MyInit1 sut = new MyInit1();

        Executor executor = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        sut.doSomething();
                    } catch (Exception pE) {
                        pE.printStackTrace();
                    }
                }
            });
        }
    }
}