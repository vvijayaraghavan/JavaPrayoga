package vij.designpatt.creational.singleton;

/**
 * Created by Vijay on 2017-Mar-11
 *
 * Making the 'singleLazyInstance' volatile will make all the threads able to access the object
 * even when one of the threads creates it and dies.
 * If we don't make it volatile, and when a thread creates the 'singleLazyInstance' object, and dies,
 * other threads will assume the object 'singleLazyInstance' is still null as the created thread had the
 * 'singleLazyInstance' in its local copy.
 */
public class LazyInstance {

    private volatile static LazyInstance singleLazyInstance = null;

    private LazyInstance() {

    }

    public static LazyInstance getInstance() {

        if (singleLazyInstance == null) {

            synchronized (LazyInstance.class) {

                if (singleLazyInstance == null) {

                    singleLazyInstance = new LazyInstance();
                }
            }
        }
        return singleLazyInstance;
    }
}