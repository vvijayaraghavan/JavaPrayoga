package vij.core.multiinherit;

/**
 * Created by Vijay on 2017, March 16.
 */
public interface InterfaceA {

    void saySomething();

    default void sayHi() {

        System.out.println("Hi, from InterfaceA");
    }
}