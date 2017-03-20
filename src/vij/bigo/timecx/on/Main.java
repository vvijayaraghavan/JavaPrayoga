package vij.bigo.timecx.on;

import vij.bigo.timecx.BigOTimeCxUtil;

import java.util.ArrayList;
import java.util.List;

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

    //Time Taken Records
    private static long startTime;
    private static long endTime;

    Main() {

    }

    private void createIntArrays(List<int[]> myIntArrayLst) {

        int[] arraySizes = {100000, 200000, 300000, 40000000, 5000000};
        for (int arraySize : arraySizes) {

            myIntArrayLst.add(BigOTimeCxUtil.createRandomIntArray(arraySize));
        }
    }

    public static void main(String[] args) {

        Main bigOn = new Main();
        //Create array of different sizes
        List<int[]> myIntArrayLst = new ArrayList<>();
        bigOn.createIntArrays(myIntArrayLst);

        //Find some random values in each of the array created and record the timings
        int[] searchValues = {0, 2, 467, 44, 500};
        for (int searchValue : searchValues) {

            for (int[] searchArray : myIntArrayLst) {

                LinearSearch lnSrch = new LinearSearch(searchArray);
                int searchArraySize = searchArray.length;

                startTime = System.currentTimeMillis();
                int arrayIndex = lnSrch.searchValueFromArray(searchValue);
                endTime = System.currentTimeMillis();

                if (arrayIndex == searchArraySize) {

                    System.err.println("ArraySize[" + searchArraySize + "] TimeTaken[" + (endTime - startTime) + " ms] SearchValue[" + searchValue + "] NOT FOUND!");
                } else {

                    System.out.println("ArraySize[" + searchArraySize + "] TimeTaken[" + (endTime - startTime) + " ms] SearchValue[" + searchValue + "] FOUND AT INDEX[" + arrayIndex + "]");
                }
            }
        } //Search Random Values - Loop
    }


}