package vij.bigo.timecx.o1;

import vij.bigo.timecx.BigOTimeCxUtil;

/**
 * Created by Vijay on 2017, March 19.
 *
 * This will provide the example of Big O Notation's order of 1 - O(1)
 * Fetching an element of an array from a particular index.
 */
public class Main {

    private int[] myIntArray;
    private int myIntArraySize;

    //Time Taken Records
    private static long startTime;
    private static long endTime;

    Main() {

        myIntArray = BigOTimeCxUtil.createRandomIntArray(1000);
        myIntArraySize = myIntArray.length;
    }

    public static void main(String[] args) {

        Main bigO1 = new Main();

        int[] randomIndicesToFetch = {30, 55, 700, 0, 999};
        for (int idx : randomIndicesToFetch) {

            bigO1.fetchIndices(idx);
        }

    }

    private void fetchIndices(int arrayIndex) {

        startTime = System.currentTimeMillis();
        int fetchedVal = getArrayValueFromIndex(arrayIndex);
        endTime = System.currentTimeMillis();

        System.out.println("Time taken to fetch '" + fetchedVal + "' from " +
                "index[" + arrayIndex + "] is '" + (endTime - startTime) + "' Milliseconds");
    }

    public int getArrayValueFromIndex(int indexValue) {

        if (indexValue < 0 || indexValue > myIntArraySize) {

            throw new ArrayIndexOutOfBoundsException("Given index is not within the bounds of the array");
        }

        return myIntArray[indexValue];
    }

}