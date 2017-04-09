package vij.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay on 2017, April 09.
 */
public class Drawing implements IShape {

    //collection of Shapes
    private List<IShape> shapes = new ArrayList<>();

    @Override
    public void draw(String fillColor) {
        for(IShape sh : shapes)
        {
            sh.draw(fillColor);
        }
    }

    //adding shape to drawing
    public void add(IShape s){
        this.shapes.add(s);
    }

    //removing shape from drawing
    public void remove(IShape s){
        shapes.remove(s);
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }
}