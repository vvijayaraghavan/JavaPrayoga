package vij.dynaprogramming.common;

/**
 * Created by Vijay on 2017, April 08.
 */
public class Util {

    public static void swap(int[] sourceArr, int idx1, int idx2) {

        int temp = sourceArr[idx1];
        sourceArr[idx1] = sourceArr[idx2];
        sourceArr[idx2] = temp;
    }
}
