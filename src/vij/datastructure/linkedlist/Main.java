package vij.datastructure.linkedlist;

/**
 * Created by Vijay on 2017, March 12.
 */
public class Main {

    public static void main(String[] args) {

        // Default constructor - let's put "0" into head element.
        MyLinkedList myLnkList = new MyLinkedList();

        // add more elements to LinkedList
        myLnkList.add("1");
        myLnkList.add("2");
        myLnkList.add("3");
        myLnkList.add("4");
        myLnkList.add("5");

		/*
		 * Please note that primitive values can not be added into LinkedList directly. They must be converted to their
		 * corresponding wrapper class.
		 */

        System.out.println("Print: crunchifyList: \t\t" + myLnkList);
        System.out.println(".size(): \t\t\t\t" + myLnkList.size());
        System.out.println(".get(3): \t\t\t\t" + myLnkList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".remove(2): \t\t\t\t" + myLnkList.remove(2) + " (element removed)");
        System.out.println(".get(3): \t\t\t\t" + myLnkList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".size(): \t\t\t\t" + myLnkList.size());
        System.out.println("Print again: crunchifyList: \t" + myLnkList);
    }

}