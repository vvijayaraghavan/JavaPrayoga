package vij.designpattern.structural.adapter;

/**
 * Created by Vijay on 2017, April 09.
 *
 * Uses aggregation (inheritance)
 */
public class SocketClassAdapterImpl extends MySocket implements ISocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v= getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v= getVolt();
        return convertVolt(v,40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
}
