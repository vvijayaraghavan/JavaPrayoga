package vij.concurrent.prodcons.legacy;

import java.util.List;

/**
 * Created by Vijay on 2017, March 13.
 */
public class Producer implements Runnable {

    public static final int TOTAL_PRODUCES = 5;
    private List<Integer> sharedQueue;
    private int maxSize=2; //maximum number of products which sharedQueue can hold at a time.

    public Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= TOTAL_PRODUCES; i++) {  //produce 10 products.
            try {
                produce(i);
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }

        System.out.println("PRODUCER JOB OVER.");
    }

    private void produce(int i) throws InterruptedException {

        synchronized (sharedQueue) {
            //if sharedQuey is full wait until consumer consumes.
            while (sharedQueue.size() == maxSize) {
                System.out.println("Queue is full, producerThread is waiting for "
                        + "consumerThread to consume, sharedQueue's size= "+maxSize);
                sharedQueue.wait();
            }
        }

       /* 2 Synchronized blocks have been used means before
        * producer produces by entering below synchronized
        * block consumer can consume.
        */

        //as soon as producer produces (by adding in sharedQueue) it notifies consumerThread.
        synchronized (sharedQueue) {
            System.out.println("Produced : " + i);
            sharedQueue.add(i);
            Thread.sleep((long)(Math.random() * 1000));
            sharedQueue.notify();
        }
    }
}