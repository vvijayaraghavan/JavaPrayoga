package vij.concurrent.volatilecheck;

/**
 * Created by Vijay on 2017, March 16.
 *
 * The volatile, even though being static, is not reflecting it immediately across threads.
 * When we create threads through a loop and if we modify a volatile static variable on those threads' start
 * the modified value is not reflected in subsequent threads created.
 *
 * Reference:
 *      https://github.com/inbravo/java-src/blob/13bf0bb4429a49bcd94a2712ff814c9fc98899bc/src/com/inbravo/concurrency/FailedConcurrency.java
 */
public class Main {

    private volatile static int counter = 0;

    private void concurrentMethodWrong() {

//        System.out.println("in concurrentMethodWrong");
        counter = counter + 5;
        counter = counter - 5;
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