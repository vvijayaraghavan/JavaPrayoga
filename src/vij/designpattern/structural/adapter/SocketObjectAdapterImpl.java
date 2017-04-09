package vij.designpattern.structural.adapter;

/**
 * Created by Vijay on 2017, April 09.
 *
 * Uses composition
 */
public class SocketObjectAdapterImpl implements ISocketAdapter {

    //Using Composition for adapter pattern
    private MySocket sock = new MySocket();

    @Override
    public Volt get120Volt() {
        return sock.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v= sock.getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v= sock.getVolt();
        return convertVolt(v,40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
}