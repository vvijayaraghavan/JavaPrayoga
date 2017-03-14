package vij.concurrent.prodcons;

import vij.concurrent.prodcons.legacy.Consumer;
import vij.concurrent.prodcons.legacy.Producer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vijay on 2017, March 11.
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> sharedQueue = new LinkedList<Integer>(); //Creating shared object

        Consumer consumer = new Consumer(sharedQueue);
        Producer producer = new Producer(sharedQueue);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        consumerThread.start();
        producerThread.start();
    }

}