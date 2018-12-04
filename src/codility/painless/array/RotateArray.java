package codility.painless.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String a[]) {

        int[] nums = {3,4,1};
        int rotateCount = 6;

        rotateArray(nums, rotateCount);
    }

    private static void rotateArray(int[] nums, int rotateCount) {

        System.out.println("Original Array: " + Arrays.toString(nums));

        int arrayLen = nums.length;
        if (arrayLen == rotateCount || rotateCount == 0) {

            System.out.println("Rotation as no effect: " + Arrays.toString(nums));
        } else {

            int finalRotateCount = 0;
            if (rotateCount > arrayLen) {

                finalRotateCount = rotateCount % arrayLen;

                if (finalRotateCount == 0) {
                    System.out.println("Rotation as no effect: " + Arrays.toString(nums));
                }
            } else {

                finalRotateCount = rotateCount;
            }
            int[] rotatedArr = new int[arrayLen];
            int numArrIdx = 0;

            while (numArrIdx < arrayLen) {

                System.out.print("finalRotateCount: " + finalRotateCount + "\tnumArrIdx" + numArrIdx);
                rotatedArr[finalRotateCount] = nums[numArrIdx];
                finalRotateCount++;
                if (finalRotateCount == arrayLen) {
                    finalRotateCount = 0;
                }
                numArrIdx++;
            }

            System.out.println("Rotated Array: " + Arrays.toString(rotatedArr));
        }
    }
}