package vij.guava.multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.List;

/**
 * Created by Vijay on 3/11/2017.
 *
 * References:
 *      https://www.leveluplunch.com/java/examples/guava-multimap-example/
 *      https://www.tutorialspoint.com/guava/guava_multimap.htm
 */
public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Multimap<String,String> multimap = m.getMultimap();

        List<String> lowerList = (List<String>)multimap.get("lower");
        System.out.println("Initial lower case list");
        System.out.println(lowerList.toString());
    }

    private Multimap<String,String> getMultimap(){

        //Map<String, List<String>>
        // lower -> a, b, c, d, e
        // upper -> A, B, C, D

        Multimap<String,String> multimap = ArrayListMultimap.create();

        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "e");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");

        return multimap;
    }
}
