package vij.designpattern.structural.adapter;

/**
 * Created by Vijay on 2017, April 09.
 */
public interface ISocketAdapter {

    Volt get120Volt();

    Volt get12Volt();

    Volt get3Volt();
}