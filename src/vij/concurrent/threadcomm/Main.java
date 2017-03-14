package vij.concurrent.threadcomm;

import java.util.Scanner;

/**
 * Created by Vijay on 3/11/2017.
 * Usage of 'volatile'
 * References:
 *      http://javarevisited.blogspot.sg/2011/06/volatile-keyword-java-example-tutorial.html
 */
public class Main {

    public static void main(String[] args) {

        Processor prc = new Processor();
        prc.start();

        System.out.println("Press <ENTER> to stop the process...");
        new Scanner(System.in).nextLine();

        prc.shutdown();
    }

}