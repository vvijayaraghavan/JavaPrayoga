package vij.designpattern.structural.composite;

/**
 * Created by Vijay on 2017, April 09.
 *
 * When we need to have a structure where all the contents inside it has to be treated same
 * for any (or set of) operations performed on them.
 *
 * Example 1:
 *      Folders in a computer. It contains folders, files. Both are considered as contents of the folder.
 *
 * Example 2:
 *      There is a drawing and there are many shapes in the drawing, say circle, square etc.
 *      When we want to fill the drawing with some color or pattern, it applies uniformly to
 *      all the shapes inside the drawing.
 *
 * Example from JAVA:
 *      java.awt.Container#add(Component) is a great example of Composite pattern in java
 *      and used a lot in Swing
 */
public class Main {

    public static void main(String[] args) {

        IShape tri = new Triangle();
        IShape tri1 = new Triangle();
        IShape cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");

        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }

}