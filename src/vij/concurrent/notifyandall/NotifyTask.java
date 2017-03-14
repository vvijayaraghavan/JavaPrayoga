package vij.concurrent.notifyandall;

/**
 * Created by Vijay on 2017, March 14.
 *
 * Try the go method with both 'notify' and 'notifyAll'
 */
public class NotifyTask implements Runnable {

    public volatile boolean go = false;

    @Override
    public void run() {

        go();
    }

    private synchronized void go() {

        while (go == false){
            System.out.println(Thread.currentThread()
                    + " is going to notify all or one thread waiting on this object");

            go = true; //making condition true for waiting thread
            notify(); // only one out of three waiting thread WT1, WT2,WT3 will woke up
//            notifyAll(); // all waiting thread  WT1,WT2,WT3 will woke up
        }
    }

}