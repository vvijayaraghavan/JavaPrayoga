package vij.bigo.timecx.ologn;

import org.apache.commons.lang3.mutable.MutableInt;
import vij.bigo.timecx.BigOTimeCxUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay on 2017, March 20.
 *
 * This will provide example for Big O Notation's Order of log n O(log n)
 *
 * Algorithm: Binary Search
 *      Note: The O(log n) time is achieved iff the array is sorted.
 */
public class Main {

    //Time Taken Records
    private static long startTime;
    private static long endTime;

    Main() {

    }

    public static void main(String[] args) {

        Main bigOLogn = new Main();
        //Create array of different sizes
        List<int[]> mySeqIntArrayLst = new ArrayList<>();
        bigOLogn.createSeqIntArrays(mySeqIntArrayLst);

        //Find some random values in each of the array created and record the timings
        int[] searchValues = {5000, 200, 50987, 4909824, 502310};
        for (int searchValue : searchValues) {

            System.out.println("\n Going to Search: " + searchValue);
            for (int[] searchArray : mySeqIntArrayLst) {

                BinarySearch biSrch = new BinarySearch(searchArray);
                int searchArraySize = searchArray.length;

                MutableInt iterationsCount = new MutableInt(0);
                startTime = System.currentTimeMillis();
                int arrayIndex = biSrch.searchValueFromArray(searchValue, iterationsCount);
                endTime = System.currentTimeMillis();

                if (arrayIndex == -1) {

                    System.err.println("ArraySize[" + searchArraySize + "] TimeTaken[" + (endTime - startTime) + " ms] IterationCount[" + iterationsCount + "] SearchValue[" + searchValue + "] NOT FOUND!");
                } else {

                    System.out.println("ArraySize[" + searchArraySize + "] TimeTaken[" + (endTime - startTime) + " ms] IterationCount[" + iterationsCount + "] SearchValue[" + searchValue + "] FOUND AT INDEX[" + arrayIndex + "]");
                }
            }
        } //Search Random Values - Loop
    }

    private void createSeqIntArrays(List<int[]> myIntArrayLst) {

        int[] arraySizes = {100000, 200000, 300000, 40000000, 5000000};
        for (int arraySize : arraySizes) {

            myIntArrayLst.add(BigOTimeCxUtil.createSequentialIntArray(arraySize));
        }
    }

}