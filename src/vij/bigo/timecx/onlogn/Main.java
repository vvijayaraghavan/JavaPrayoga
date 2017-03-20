package vij.bigo.timecx.onlogn;

import vij.bigo.timecx.BigOTimeCxUtil;
import vij.bigo.timecx.onsq.BubbleSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay on 2017, March 20.
 *
 * This will provide example for Big O Notation's Order of n log n O(n log n)
 *
 * Algorithm: Quick Sort
 */
public class Main {

    //Time Taken Records
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {

        Main bigOnLogn = new Main();

        //Create array of different sizes
        List<int[]> mySortableArraysLst = new ArrayList<>();
        bigOnLogn.createIntArrays(mySortableArraysLst);

        //Sort the arrays
        for (int[] sortableArray : mySortableArraysLst) {

            System.out.println();
            int sortableArraySize = sortableArray.length;

            BubbleSort bubbSrt = new BubbleSort(sortableArray);
            startTime = System.currentTimeMillis();
            bubbSrt.sort();
            endTime = System.currentTimeMillis();
            System.out.println("ArraySize[" + sortableArraySize + "] TimeTaken to BUBBLE SORT[" + (endTime - startTime) + " ms]");

            QuickSort qSrt = new QuickSort(sortableArray);
            startTime = System.currentTimeMillis();
            qSrt.sort(0, sortableArraySize-1);
            endTime = System.currentTimeMillis();
            System.out.println("ArraySize[" + sortableArraySize + "] TimeTaken to QUICK SORT[" + (endTime - startTime) + " ms]");
        }
    }

    private void createIntArrays(List<int[]> myIntArrayLst) {

        int[] arraySizes = {10000, 20000, 30000, 40000, 50000};
        for (int arraySize : arraySizes) {

            myIntArrayLst.add(BigOTimeCxUtil.createRandomIntArray(arraySize));
        }
    }
}