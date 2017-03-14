package vij.concurrent.threadcomm;

/**
 * Created by Vijay on 3/11/2017.
 */
public class Processor extends Thread {

    private volatile boolean running = true;
//    private boolean running = true;

    @Override
    public void run() {

        while(running) {
            System.out.println(new java.util.Date());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }

}