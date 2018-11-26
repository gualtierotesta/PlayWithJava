package it.gualtierotesta.playwithjava;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by gualtiero.testa on 20/03/2017.
 */
public class MyThreads {

    private static final int N_THREADS = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < N_THREADS*2; i++) {
            Runnable task = new Runnable() {
                public void run() {
                    System.out.println("Running " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(TimeUnit.MILLISECONDS.toMillis(500));
                    } catch (InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    System.out.println("Runned " + Thread.currentThread().getName());
                }
            };
            System.out.println("Executing "+ i);
            executor.execute(task);
            Thread.sleep(TimeUnit.MILLISECONDS.toMillis(200));
        }
        final List<Runnable> runnables = executor.shutdownNow();
        System.out.println(runnables);
    }
}
