package vij.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vijay on 2017, April 09.
 */
public class ArithmeticFactory {

    //Cached instances of Arithmetic Operators
    Map<String, ArithmeticOperator> arithmeticOperatorsCache = new HashMap<>();

    public ArithmeticFactory() {
        //default constructor
    }

    public ArithmeticOperator getArithmeticOperator(String key) {
        if (arithmeticOperatorsCache.containsKey(key)) {
            return arithmeticOperatorsCache.get(key);
        } else {
            ArithmeticOperator arithmeticOperator = null;

            switch (key) {

                case "add":
                    arithmeticOperator = new Adder();
                    break;
                case "multiply":
                    arithmeticOperator = new Multiplier();
                    break;
                default:
                    System.err.println("Given operation '" + key + "' is not supported!");
            }
            if (arithmeticOperator != null) {
                arithmeticOperatorsCache.put(key, arithmeticOperator);
            }
            return arithmeticOperator;
        }
    }
}