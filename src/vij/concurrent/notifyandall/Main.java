package vij.concurrent.notifyandall;

/**
 * Created by Vijay on 2017, March 14.
 */
public class Main {

    public static void main(String[] args) {

        //Create ONE NotifyTask instance and register it to all other Wait Task instances
        NotifyTask notifyTask = new NotifyTask();
        Thread notifyThread = new Thread(notifyTask, "NOTIFY THREAD");

        //Create THREE WaitTask instances
        WaitTask wt1 = new WaitTask(notifyTask);
        WaitTask wt2 = new WaitTask(notifyTask);
        WaitTask wt3 = new WaitTask(notifyTask);
        Thread waitThread1 = new Thread(wt1, "WAIT THREAD 1");
        Thread waitThread2 = new Thread(wt2, "WAIT THREAD 2");
        Thread waitThread3 = new Thread(wt3, "WAIT THREAD 3");

        //Start all the wait threads
        waitThread1.start();
        waitThread2.start();
        waitThread3.start();

        //After a small delay, start the notify thread
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
    }
}