package vij.dynaprogramming;

import vij.dynaprogramming.common.Util;

import java.util.Arrays;

/**
 * Created by Vijay on 2017, April 08.
 * This class focuses on all array rearranging related problems.
 * Can be sorting, arrange based on customized requirement, etc.
 */
public class ArrayRearrange {

    public static void main(String[] args) {

        rearrangeArrayNonzeroFirstZeroLast(new int[]{99,0,1,0,4,0,87,0,9,7,8,11,23,1,1});
    }

    /**
     * This method will rearrange the given integer array
     * by moving all the non-zero numbers to beginning of the array and
     * all zeroes to end of the array.
     * Note: The non-zero numbers' sorting is not mandatory
     * Source: https://www.careercup.com/question?id=5737674640982016
     *
     * @param sourceArr int[]
     */
    private static void rearrangeArrayNonzeroFirstZeroLast(int[] sourceArr) {

        int sourceArrLen = sourceArr.length;
        System.out.println("ARRAY SIZE["+sourceArrLen+"] Source Array:" + Arrays.toString(sourceArr));

        int beginIdx = 0;
        int endIdx = sourceArrLen - 1;

        while (beginIdx < endIdx) {

            if (sourceArr[beginIdx] == 0 && sourceArr[endIdx] == 0) {
                //begin part is not fine, end part is fine
                //move the end part and retain the begin part to swap
                --endIdx;
            } else if (sourceArr[beginIdx] == 0 && sourceArr[endIdx] != 0) {
                //begin part is not fine and end part is not fine
                //swap both items
                //move the begin and end part further
                Util.swap(sourceArr, beginIdx, endIdx);
                ++beginIdx;
                --endIdx;
            } else if (sourceArr[beginIdx] != 0 && sourceArr[endIdx] == 0) {
                //begin part and end part satisfies the requirement
                //move further on both sides
                ++beginIdx;
                --endIdx;
            } else if (sourceArr[beginIdx] != 0 && sourceArr[endIdx] != 0) {
                //begin part is fine, end part is not
                //move the begin part and retain the end part to swap
                ++beginIdx;
            }

            System.out.println("Array [beingIdx-"+beginIdx+"][endIdx-"+endIdx+"] :" + Arrays.toString(sourceArr));
        }

        System.out.println("Array after re-arranging:" + Arrays.toString(sourceArr));
    }

}