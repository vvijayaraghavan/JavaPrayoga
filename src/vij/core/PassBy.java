package vij.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay on 2017, March 12.
 */
public class PassBy {

    public static void main(String[] args) {

        PassBy passBy = new PassBy();

//        List myList = null;
//        passBy.alterList(myList);
//        System.out.println(myList); //Output ?

        Integer i = new Integer(1000);
        System.out.println(i);

    }

    private void alterList(List myList) {

        myList.add("one");
    }

    private void alterInt(Integer i) {

        i = 10;
    }

}