package vij.designpattern.structural.adapter;

/**
 * Created by Vijay on 2017, April 09.
 */
public class MySocket {

    public Volt getVolt() {
        return new Volt(120);
    }

}