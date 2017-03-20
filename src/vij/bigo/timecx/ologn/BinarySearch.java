package vij.bigo.timecx.ologn;

import org.apache.commons.lang3.mutable.MutableInt;

/**
 * Created by Vijay on 2017, March 20.
 */
public class BinarySearch {

    private int[] intArrayToSearch;
    private int searchArraySize;

    BinarySearch(int[] intArrayToSearch) {

        this.intArrayToSearch = intArrayToSearch;
        this.searchArraySize = intArrayToSearch.length;
    }

    // O (log N) Occurs when the data being used is decreased
    // by roughly 50% each time through the algorithm. The
    // Binary search is a perfect example of this.

    // Pretty fast because the log N increases at a dramatically
    // slower rate as N increases

    // O (log N) algorithms are very efficient because increasing
    // the amount of data has little effect at some point early
    // on because the amount of data is halved on each run through
    // Please not that the Binary Search benefit of O(log n) is achieved only
    // on sorted arrays.
    public int searchValueFromArray(int searchValue, MutableInt iterationsCount) {

        int idx = -1;

        int lowIndex = 0;
        int highIndex = searchArraySize - 1;

        int timesThrough = 0;

        while (lowIndex <= highIndex) {

            int middleIndex = (highIndex + lowIndex) / 2;

            if (intArrayToSearch[middleIndex] < searchValue) {
                lowIndex = middleIndex + 1;
            }
            else if (intArrayToSearch[middleIndex] > searchValue) {
                highIndex = middleIndex - 1;
            }
            else {

                idx = middleIndex;
                lowIndex = highIndex + 1;
            }

            timesThrough++;
        }

        // This doesn't really show anything because
        // the algorithm is so fast
        iterationsCount.setValue(timesThrough);

        return idx;
    }
}