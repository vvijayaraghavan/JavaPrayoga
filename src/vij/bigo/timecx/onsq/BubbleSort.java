package vij.bigo.timecx.onsq;

/**
 * Created by Vijay on 2017, March 20.
 */
public class BubbleSort {

    int[] sortableArray;
    int sortableArraySize;

    public BubbleSort(int[] sortableArray) {

        this.sortableArray = sortableArray;
        this.sortableArraySize = this.sortableArray.length;
    }

    // O(N^2) Time to complete will be proportional to
    // the square of the amount of data (Bubble Sort)
    // Algorithms with more nested iterations will result
    // in O(N^3), O(N^4), etc. performance

    // Each pass through the outer loop (0)N requires us
    // to go through the entire list again so N multiplies
    // against itself or it is squared

    public void sort() {

        for (int i = sortableArraySize - 1; i > 1; i--) {

            for (int j = 0; j < i; j++) {

                if (sortableArray[j] > sortableArray[j + 1]) {

                    swapValues(j, j + 1);

                }
            }
        }
    }

    public void swapValues(int indexOne, int indexTwo) {

        int temp = sortableArray[indexOne];
        sortableArray[indexOne] = sortableArray[indexTwo];
        sortableArray[indexTwo] = temp;
    }

}