package vij.core.enumex.operators;

/**
 * Created by Vijay on 2017, March 27.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(Operator.STRING_OPERATIONS.getAllowedOperations());
        System.out.println(Operator.NUMERIC_OPERATIONS.getAllowedOperations());
        System.out.println(Operator.GENERIC_OPERATIONS.getAllowedOperations());

        System.out.println((Operator.NUM_OPS.getAllowedOperations()));
        System.out.println((Operator.NUM_OPS.getAllowedOperations()).contains("eq")); //Will return false, as this returns an list of Enum
        System.out.println((Operator.NUM_OPS.getAllowedOperationNames()));
        System.out.println((Operator.NUM_OPS.getAllowedOperationNames()).contains("eq")); //Will return true
    }
}