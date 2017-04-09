package vij.designpattern.structural.composite;

/**
 * Created by Vijay on 2017, April 09.
 */
public class Triangle implements IShape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color "+fillColor);
    }

}