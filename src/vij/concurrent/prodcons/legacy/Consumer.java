package vij.concurrent.prodcons.legacy;

import java.util.List;

/**
 * Created by Vijay on 2017, March 13.
 */
public class Consumer implements Runnable {

    public static final double CONSUMER_WAIT_TIME = (Math.random() * 2000);
    private List<Integer> sharedQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int consumedVal = consume();
                if (consumedVal == Producer.TOTAL_PRODUCES) {
                    break;
                }
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }
        System.out.println("SHUTTING DOWN CONSUMER!");
    }

    private int consume() throws InterruptedException {

        int consumedValue = -1;
        synchronized (sharedQueue) {
            //if sharedQueue is empty wait until producer produces.
            while (sharedQueue.size() == 0) {
                System.out.println("Queue is empty, consumerThread is waiting for "
                        + "producerThread to produce, sharedQueue's size= 0 ");

                sharedQueue.wait();
            }
        }


       /* 2 Synchronized blocks have been used means before
        * consumer start consuming by entering below synchronized
        * block producer can produce.
        */

        /*If sharedQueue not empty consumer will consume
      * (by removing from sharedQueue) and notify the producerThread.
      */
        synchronized (sharedQueue) {
            Thread.sleep((long) CONSUMER_WAIT_TIME);
            consumedValue = sharedQueue.remove(0);
            System.out.println("CONSUMED : " + consumedValue);
            sharedQueue.notify();
        }
        return consumedValue;
    }

}