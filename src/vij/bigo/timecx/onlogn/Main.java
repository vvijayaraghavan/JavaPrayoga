package vij.bigo.timecx.onlogn;

import vij.bigo.timecx.BigOTimeCxUtil;
import vij.bigo.timecx.onsq.BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<int[]> arraysToBubbleSortLst = new ArrayList<>();
        bigOnLogn.createIntArrays(arraysToBubbleSortLst);

        List<int[]> arraysToQuickSortLst = new ArrayList<>();
        bigOnLogn.createIntArrays(arraysToQuickSortLst);

        //Sort the arrays - With Comparison on Bubble and Quick Sort
        int sortableArrayIndex = 0;
        int totalArraysToSort = arraysToQuickSortLst.size();
        while (sortableArrayIndex < totalArraysToSort) {

            System.out.println();
            int sortableArraySize = arraysToBubbleSortLst.get(sortableArrayIndex).length;

            BubbleSort bubbSrt = new BubbleSort(arraysToBubbleSortLst.get(sortableArrayIndex));
            startTime = System.currentTimeMillis();
            bubbSrt.sort();
            endTime = System.currentTimeMillis();
            System.out.println("ArraySize[" + sortableArraySize + "] TimeTaken to BUBBLE SORT[" + (endTime - startTime) + " ms]");

            QuickSort qSrt = new QuickSort(arraysToQuickSortLst.get(sortableArrayIndex));
            startTime = System.currentTimeMillis();
            qSrt.sort(0, sortableArraySize-1);
            endTime = System.currentTimeMillis();

            System.out.println("ArraySize[" + sortableArraySize + "] TimeTaken to QUICK SORT[" + (endTime - startTime) + " ms]");

//            System.out.println("Bubble Sorted Array: " + Arrays.toString(arraysToBubbleSortLst.get(sortableArrayIndex)));
//            System.out.println("Quick Sorted Array: " + Arrays.toString(arraysToQuickSortLst.get(sortableArrayIndex)));

            sortableArrayIndex++;
        }
    }

    private void createIntArrays(List<int[]> myIntArrayLst) {

        int[] arraySizes = {1000, 2000, 3000, 4000, 5000};
        for (int arraySize : arraySizes) {

            myIntArrayLst.add(BigOTimeCxUtil.createRandomIntArray(arraySize));
        }
    }
}