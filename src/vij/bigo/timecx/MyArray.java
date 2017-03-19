package vij.bigo.timecx;

/**
 * Created by Vijay on 2017, March 19.
 */
public class MyArray {

    private int[] intArray;
    private int arraySize;

    public void createArrayOfRandomNumbers(int arraySize) {

        this.arraySize = arraySize;
        intArray = new int[arraySize];
        for (int arrayIdx = 0; arrayIdx < arraySize; arrayIdx++) {

            intArray[arrayIdx] = (int) (Math.random() * 1000) + 10;
        }
    }

    public int[] getArray() {

        return this.intArray;
    }

    public int getArrayValueFromIndex(int indexValue) {

        if (indexValue < 0 || indexValue > arraySize) {

            throw new ArrayIndexOutOfBoundsException("Given index is not within the bounds of the array");
        }

        return intArray[indexValue];
    }

}