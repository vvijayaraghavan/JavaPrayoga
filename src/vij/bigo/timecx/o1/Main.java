package vij.bigo.timecx.o1;

import vij.bigo.timecx.MyArray;

/**
 * Created by Vijay on 2017, March 19.
 *
 * This will provide the example of Big O Notation's order of 1 - O(1)
 * Fetching an element of an array from a particular index.
 */
public class Main {

    private MyArray myIntArray;

    //Time Taken Records
    private static long startTime;
    private static long endTime;

    Main() {

        myIntArray = new MyArray();
        myIntArray.createArrayOfRandomNumbers(1000);
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
        int fetchedVal = myIntArray.getArrayValueFromIndex(arrayIndex);
        endTime = System.currentTimeMillis();

        System.out.println("Time taken to fetch '" + fetchedVal + "' from " +
                "index[" + arrayIndex + "] is '" + (endTime - startTime) + "' Milliseconds");
    }

}