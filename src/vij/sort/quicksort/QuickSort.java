package vij.sort.quicksort;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.Arrays;

/**
 * Created by Vijay on 2017, March 21.
 */
public class QuickSort {

    private int[] arrayForPartition;
    private MutableInt itertationCount = new MutableInt(0);
    private MutableInt recursiveCallCount = new MutableInt(0);

    public QuickSort(int[] arrayForPartition) {

        this.arrayForPartition = arrayForPartition;
    }

    public static void main(String[] args) {

        int[] i = {5, 4, 9, 6, 3, 5, 1, 0};

        QuickSort quickSort = new QuickSort(i);
        quickSort.sort(0, quickSort.arrayForPartition.length - 1);

        System.out.println("SORTED ARRAY: \n" + Arrays.toString(quickSort.arrayForPartition));
        System.out.println("STATS:");
        System.out.println("ARRAY SIZE: " + quickSort.arrayForPartition.length);
        System.out.println("TOTAL ITERATIONS: " + quickSort.itertationCount.getValue());
        System.out.println("TOTAL RECURSIVE CALLS: " + quickSort.recursiveCallCount.getValue());
    }

    private void testPartition() {

        int newPivotLocation = partition(0, arrayForPartition.length-1);

        System.out.println("Partitioned Array:\n" + Arrays.toString(arrayForPartition));
        System.out.println("New Pivot Location: " + newPivotLocation);
    }

    public void sort(int startIdx, int endIdx) {

        // There must be more than one element to sort
        if (startIdx < endIdx) {

            //Partition the Array
            int pivotLocation = partition(startIdx, endIdx);

            //Sort the left-partition
            recursiveCallCount.getAndIncrement();
            sort(startIdx, pivotLocation-1);

            //Sort the right-partition
            recursiveCallCount.getAndIncrement();
            sort(pivotLocation+1, endIdx);
        }
    }

    // Assuming the given startIdx and endIdx will be within the index bounds of the array used
    // Pivot location is chosen as the endIdx location
    private int partition(int startIdx, int endIdx) {

        System.out.println("Partitioning with startIdx[" + startIdx + "] endIdx[" + endIdx + "]" + ((int)((endIdx + startIdx) - 1)/2));
        int i = startIdx - 1;
//        int pivotIdx = endIdx; //24i/10r
        int pivotIdx = ((endIdx + startIdx) - 1)/2; //19i/10r
//        int pivotIdx = startIdx; //24i/12r

        for (int j=startIdx ; j<=endIdx ; j++) {

            if (arrayForPartition[j] <= arrayForPartition[pivotIdx]) {

                i++;
                swap(i, j);
            }
            itertationCount.getAndIncrement();
        }

        return i; //new pivot location
    }

    private void swap(int leftIdx, int rightIdx) {

        if (leftIdx == rightIdx) {
            return;
        }
        int temp = arrayForPartition[leftIdx];
        arrayForPartition[leftIdx] = arrayForPartition[rightIdx];
        arrayForPartition[rightIdx] = temp;
    }

}