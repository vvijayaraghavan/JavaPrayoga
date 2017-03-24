package vij.collections;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Vijay on 2017, March 25.
 */
public class TryShuffle {

    public static void main(String[] args) {

        int arraySize = 100;
        Integer[] intArray = new Integer[arraySize];
        for (int arrayIdx = 0; arrayIdx < arraySize; arrayIdx++) {

            intArray[arrayIdx] = arrayIdx;
        }
        System.out.println("Before Shuffle:\n" + Arrays.toString(intArray));
        Collections.shuffle(Arrays.asList(intArray));
        System.out.println("After Shuffle:\n" + Arrays.toString(intArray));
    }
}