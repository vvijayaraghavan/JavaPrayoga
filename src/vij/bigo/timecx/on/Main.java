package vij.bigo.timecx.on;

import vij.bigo.timecx.MyArray;

/**
 * Created by Vijay on 2017, March 19.
 *
 * This will provide the example of Big O Notation's order of n - O(n)
 * Searching for an element in an array.
 * Here 'n' is size of the array.
 * Algorithm: Linear Search
 *
 * BEST TIME - O(1) - When the searched value is found at the first index
 * WORST TIME - O(n) - When the searched value is found at last index or not found at all
 * AVERAGE TIME - This will be on a case to case basis. Subjective.
 */
public class Main {

    private MyArray myIntArray[];

    //Time Taken Records
    private static long startTime;
    private static long endTime;

    Main(int myIntArrayObjects) {

        myIntArray = new MyArray[myIntArrayObjects];
    }

    public static void main(String[] args) {

        //Create array of different sizes
        int[] arrayOfDifftSizes = {100000, 200000, 300000, 400000, 500000};

        Main bigOn = new Main(arrayOfDifftSizes.length);

        int idx = 0;
        for (int arraySize : arrayOfDifftSizes) {

            bigOn.myIntArray[idx] = new MyArray();
            bigOn.myIntArray[idx].createArrayOfRandomNumbers(arraySize);
            idx++;
        }

        //Find for an element in the array
        int[] searchValues = {0, 2, 467, 44, 500};
        for (int a = 0; a <arrayOfDifftSizes.length ; a++) {

            int[] arrayToSearch = bigOn.myIntArray[a].getArray();
            int searchArraySize = arrayToSearch.length;
            LinearSearch lnSrch = new LinearSearch(arrayToSearch);

            startTime = System.currentTimeMillis();
            int arrayIndex = lnSrch.searchValueFromArray(searchValues[a]);
            endTime = System.currentTimeMillis();

            if (arrayIndex == searchArraySize) {

                System.err.println("Given value '" + searchValues[a] + "' NOT FOUND! Array Size[" + searchArraySize + "] Time Taken '" + (endTime - startTime) + "' Milliseconds");
            } else {

                System.out.println("Given value '" + searchValues[a] + "' FOUND at Index[" + arrayIndex + "] Array Size[" + searchArraySize + "] Time Taken '" + (endTime - startTime) + "' Milliseconds");
            }
        }
    }


}