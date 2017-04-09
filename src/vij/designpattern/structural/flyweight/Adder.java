package vij.designpattern.structural.flyweight;

/**
 * Created by Vijay on 2017, April 09.
 */
public class Adder implements ArithmeticOperator {

    private String operation;

    public Adder() {
        operation = "adding";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doMath(int a, int b) {
        System.out.println(operation + " " + a + " and " + b + ": " + (a + b));
    }

}