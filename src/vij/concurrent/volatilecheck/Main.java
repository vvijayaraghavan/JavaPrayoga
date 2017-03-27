package vij.concurrent.volatilecheck;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Vijay on 2017, March 16.
 *
 * The volatile, even though being static, is not reflecting it immediately across threads.
 * When we create threads through a loop and if we modify a volatile static variable on those threads' start
 * the modified value is not reflected in subsequent threads created.
 *
 * Reference:
 *      https://github.com/inbravo/java-src/blob/master/src/com/inbravo/concurrency/FailedConcurrency.java
 *
 * When the same volatile static variable is replaced with the corresponding Atomic variable (here AtomicInteger)
 * the data integrity is maintained and always '0' is returned.
 * Atomic variables in java uses compare-and-set philosophy to maintain the data integrity.
 */
public class Main {

//    private volatile static int counter = 0;
    private static volatile AtomicInteger counter = new AtomicInteger(0);

    private void concurrentMethodWrong() {

//        counter = counter + 5;
//        counter = counter - 5;

        counter.getAndAdd(5);
        counter.getAndAdd(-5);
    }

    public static final void main(final String... args) {

        /* Create an instance */
        final Main fc = new Main();

        for (int j = 0; j < 1000; j++) {

            for (int i = 0; i < 1000; i++) {

                /* Create anonymous thread */
                new Thread() {

                    @Override
                    public void run() {
                        fc.concurrentMethodWrong();
                    }
                }.start();
            } // loop i - inner
            System.out.println("counter:["+j+"] " + counter);
        } // loop j - outer
    }

}