package vij.designpattern.structural.flyweight;

/**
 * Created by Vijay on 2017, April 09.
 *
 * When a series of objects need to be created, but on a limited memory based environments,
 * say on any mobile or embedded devices, we can use this pattern to achieve the same.
 * Create objects conservatively.
 *
 * Example from JAVA:
 *      String pool implementation.
 *
 * To apply this pattern, split any object to its intrinsic and extrinsic properties.
 * Intrinsic are the class level properties (static fields).
 * Extrinsic are the properties that are influencing the object from outside. Say for a
 * circle object, the radius, color are set from outside (instance fields).
 */
public class Main {

    public static void main(String[] args) {

        ArithmeticFactory arithFactory = new ArithmeticFactory();

        for (int i = 0; i < 5; i++) {
            ArithmeticOperator flyweightAdder = arithFactory.getArithmeticOperator("add");
            flyweightAdder.doMath(i, i);

            ArithmeticOperator flyweightMultiplier = arithFactory.getArithmeticOperator("multiply");
            flyweightMultiplier.doMath(i, i);
        }
    }
}