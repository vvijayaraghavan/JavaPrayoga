package vij.concurrent.notifyandall;

/**
 * Created by Vijay on 2017, March 14.
 */
public class WaitTask implements Runnable {

    private NotifyTask notifyTask = null;

    public WaitTask(NotifyTask notifyTask) {

        this.notifyTask = notifyTask;
    }

    @Override
    public void run() {

        try {
            shouldGo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " finished Execution");
    }

    private synchronized void shouldGo() throws InterruptedException {

        while (notifyTask.go != true) {
            System.out.println(Thread.currentThread()
                    + " is going to wait on this object");
            wait(); //release lock and reacquires on wakeup
            System.out.println(Thread.currentThread() + " is woken up");
        }
        notifyTask.go = false; //resetting condition
    }

}