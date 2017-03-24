package vij.bigo.timecx;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Vijay on 2017, March 19.
 *
 * O(logn) < O(n) < O(nlogn)
 */
public class BigOTimeCxUtil {

    public static int[] createRandomIntArray(int arraySize) {

        int[] intArray = new int[arraySize];
        for (int arrayIdx = 0; arrayIdx < arraySize; arrayIdx++) {

            intArray[arrayIdx] = (int) (Math.random() * 1000) + 10;
        }
        return intArray;
    }

    public static int[] createSequentialIntArray(int arraySize) {

        int[] intArray = new int[arraySize];
        for (int arrayIdx = 0; arrayIdx < arraySize; arrayIdx++) {

            intArray[arrayIdx] = arrayIdx;
        }
        return intArray;
    }

}