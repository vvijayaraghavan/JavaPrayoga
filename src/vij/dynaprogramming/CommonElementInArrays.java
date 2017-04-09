package vij.dynaprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Vijay on 2017, April 08.
 *
 * Aim is to find the common element (MIN/MAX) among the given array.
 */
public class CommonElementInArrays {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1,6,89,87,23,5,-0,-22,34};
        Integer[] arr2 = new Integer[]{45,122,998,7,232,5,6};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.addAll(Arrays.asList(arr1));
        set2.addAll(Arrays.asList(arr2));
        TreeSet<Integer> commonValues = new TreeSet<>();

        for (Integer int1 : set1) {

            if (set2.contains(int1)) {
                commonValues.add(int1);
            }
        }

        System.out.println("Common Values: " + commonValues);
        System.out.println("MINIMUM Common Value: " + commonValues.first());
        System.out.println("MAXIMUM Common Value: " + commonValues.last());
    }
}
