package vij.bigo.timecx.on;

/**
 * Created by Vijay on 2017, March 19.
 */
public class LinearSearch {

    private int[] intArrayToSearch;
    private int searchArraySize;

    LinearSearch(int[] intArrayToSearch) {

        this.intArrayToSearch = intArrayToSearch;
        this.searchArraySize = intArrayToSearch.length;
    }

    public int searchValueFromArray(int searchValue) {

        int idx = 0;
        while (idx < searchArraySize && searchValue != intArrayToSearch[idx]) {

            idx++;
        }

        return idx;
    }

}