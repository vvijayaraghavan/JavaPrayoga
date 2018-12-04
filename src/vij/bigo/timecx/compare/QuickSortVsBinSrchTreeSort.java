package vij.bigo.timecx.compare;

import vij.bigo.timecx.BigOTimeCxUtil;
import vij.sort.quicksort.QuickSort;

import java.util.Arrays;

/**
 * Created by Vijay on 2017, March 24.
 */
public class QuickSortVsBinSrchTreeSort {

    private static final int ARRAY_SIZE_FOR_COMPARISON = 999998;

    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {

        int[] myIntArrayForQuickSort = BigOTimeCxUtil.createRandomIntArray(ARRAY_SIZE_FOR_COMPARISON);
        System.out.println("before sort: \n" + Arrays.toString(myIntArrayForQuickSort));

        QuickSort qckSort = new QuickSort(myIntArrayForQuickSort);
        startTime = System.currentTimeMillis();
        qckSort.sort(0, myIntArrayForQuickSort.length - 1);
        endTime = System.currentTimeMillis();
        long timeTakenForQuickSort = endTime - startTime;
        System.out.println("Quick Sorted Array:\n" + Arrays.toString(myIntArrayForQuickSort));

//        int[] myIntArrayForBinarySearchTree = BigOTimeCxUtil.createRandomIntArray(ARRAY_SIZE_FOR_COMPARISON);
//        Node rootNode = new Node(myIntArrayForBinarySearchTree[0]);
//        BinarySearchTree binSrchTree = new BinarySearchTree(rootNode);
//        startTime = System.currentTimeMillis();
//        for (int i = 1; i < myIntArrayForBinarySearchTree.length; i++) {
//            binSrchTree.insertNode(rootNode, myIntArrayForBinarySearchTree[i]);
//        }
//        int[] sortedArray = new int[ARRAY_SIZE_FOR_COMPARISON];
//        Traverse.getAscendingOrderArray(rootNode, sortedArray);
//        endTime = System.currentTimeMillis();
//        long timeTakenForBinarySearchTree = endTime - startTime;
//        System.out.println("Binary Search Tree Sorted Array:\n" + Arrays.toString(sortedArray));

        System.out.println("\nCOMPARISONS");
        System.out.println("QUICK SORT TOOK '" + timeTakenForQuickSort + "' MILLISECONDS TO SORT AN ARRAY OF " + myIntArrayForQuickSort.length + " ELEMENTS");
//        System.out.println("BINARY SEARCH TOOK '" + timeTakenForBinarySearchTree + "' MILLISECONDS TO SORT AN ARRAY OF " + myIntArrayForBinarySearchTree.length + " ELEMENTS");
    }

}