package vij.bigo.timecx.onsq;

import vij.bigo.timecx.BigOTimeCxUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay on 2017, March 20.
 *
 * This will provide example for Big O Notation's Order of 'n' square O(n^2)
 * Algorithm: Bubble Sort
 */
public class Main {

    //Time Taken Records
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {

        Main bigOnSq = new Main();

        //Create array of different sizes
        List<int[]> mySortableArraysLst = new ArrayList<>();
        bigOnSq.createIntArrays(mySortableArraysLst);

        //Sort the arrays
        for (int[] sortableArray : mySortableArraysLst) {

            BubbleSort bubbSrt = new BubbleSort(sortableArray);
            int sortableArraySize = sortableArray.length;

            startTime = System.currentTimeMillis();
            bubbSrt.sort();
            endTime = System.currentTimeMillis();

            System.out.println("ArraySize[" + sortableArraySize + "] TimeTaken to SORT[" + (endTime - startTime) + " ms]");
        }
    }

    private void createIntArrays(List<int[]> myIntArrayLst) {

        int[] arraySizes = {10000, 20000, 30000, 40000, 50000};
        for (int arraySize : arraySizes) {

            myIntArrayLst.add(BigOTimeCxUtil.createRandomIntArray(arraySize));
        }
    }
}
