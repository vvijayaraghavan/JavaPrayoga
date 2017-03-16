package vij.core.multiinherit;

/**
 * Created by Vijay on 2017, March 13.
 */
public class Main implements InterfaceA, InterfaceB {

    public static void main(String[] args) {

        Main multiInherit = new Main();
        multiInherit.sayHi();
    }

    @Override
    public void sayHi() {

        System.out.println("Override Hi");
        InterfaceA.super.sayHi();
    }

    @Override
    public void saySomething() {

        System.out.println("What to say!");
    }

}