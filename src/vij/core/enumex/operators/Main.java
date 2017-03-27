package vij.core.enumex.operators;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vijay on 2017, March 27.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(Operator.STRING_OPERATIONS.getAllowedOperations());
        System.out.println(Operator.NUMERIC_OPERATIONS.getAllowedOperations());
        System.out.println(Operator.GENERIC_OPERATIONS.getAllowedOperations());

        System.out.println(Arrays.toString(Operator.STR_OPS.getOperators()));
        System.out.println(Arrays.toString(Operator.NUM_OPS.setOfOperationsAllowed()));
    }
}