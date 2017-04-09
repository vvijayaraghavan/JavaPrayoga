package vij.designpattern.structural.adapter;

/**
 * Created by Vijay on 2017, April 09.
 *
 * Connects two different interfaces to work together.
 * Mostly this pattern is not in mind nor implemented during any design
 * as this is taken to consideration only when the need or change emerges.
 *
 * Example 1:
 *      A Mobile charger is an example, which gives the optimum power supply to mobile
 *      irrespective of the voltage that it receives from the socket.
 *
 * Example from JAVA:
 *      java.util.Arrays#asList()
 */
public class Main {

    public static void main(String[] args) {

        testClassAdapter();
        testObjectAdapter();
    }

    private static void testObjectAdapter() {
        ISocketAdapter sockAdapter = new SocketObjectAdapterImpl();
        Volt v3 = getVolt(sockAdapter,3);
        Volt v12 = getVolt(sockAdapter,12);
        Volt v120 = getVolt(sockAdapter,120);
        System.out.println("v3 volts using Object Adapter="+v3.getVolts());
        System.out.println("v12 volts using Object Adapter="+v12.getVolts());
        System.out.println("v120 volts using Object Adapter="+v120.getVolts());
    }

    private static void testClassAdapter() {
        ISocketAdapter sockAdapter = new SocketClassAdapterImpl();
        Volt v3 = getVolt(sockAdapter,3);
        Volt v12 = getVolt(sockAdapter,12);
        Volt v120 = getVolt(sockAdapter,120);
        System.out.println("v3 volts using Class Adapter="+v3.getVolts());
        System.out.println("v12 volts using Class Adapter="+v12.getVolts());
        System.out.println("v120 volts using Class Adapter="+v120.getVolts());
    }

    private static Volt getVolt(ISocketAdapter sockAdapter, int i) {
        switch (i){
            case 3: return sockAdapter.get3Volt();
            case 12: return sockAdapter.get12Volt();
            case 120: return sockAdapter.get120Volt();
            default: return sockAdapter.get120Volt();
        }
    }
}
