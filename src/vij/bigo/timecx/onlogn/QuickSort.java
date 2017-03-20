package vij.bigo.timecx.onlogn;

/**
 * Created by Vijay on 2017, March 20.
 */
public class QuickSort {

    int[] sortableArray;
    int sortableArraySize;

    public QuickSort(int[] sortableArray) {

        this.sortableArray = sortableArray;
        this.sortableArraySize = this.sortableArray.length;
    }

    public void sort(int left, int right) {

        if (right - left <= 0) {
            return;
        } else {

            int pivot = sortableArray[right];

            int pivotLocation = partitionArray(left, right, pivot);

            sort(left, pivotLocation - 1);
            sort(pivotLocation + 1, right);
        }
    }

    public int partitionArray(int left, int right, int pivot) {

        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {

            while (sortableArray[++leftPointer] < pivot);

            while (rightPointer > 0 && sortableArray[--rightPointer] > pivot);

            if (leftPointer >= rightPointer) {

                break;
            } else {

                swapValues(leftPointer, rightPointer);
            }
        }
        swapValues(leftPointer, right);

        return leftPointer;
    }

    public void swapValues(int indexOne, int indexTwo) {

        int temp = sortableArray[indexOne];
        sortableArray[indexOne] = sortableArray[indexTwo];
        sortableArray[indexTwo] = temp;

    }
}