package vij.core.equalsnhash;

import java.util.Hashtable;

/**
 * Created by Vijay on 2017, March 13.
 */
public class Main {

    public static void main(String[] args) {

        Hashtable ht = new Hashtable();
        long crmId = 12345L;
        int nameSpace = 0;

        //Create a customer object and add it to Hashtable
        Customer customer = new Customer();
        customer.setCrmId(crmId);
        customer.setNameSpace(nameSpace);
        ht.put(customer, "Vijay");

        //Create a client object and add it to Hashtable
        Client client = new Client();
        client.setCrmId(crmId);
        client.setNameSpace(nameSpace);
        ht.put(client, "Vijay");

        //Try to lookup the customer object and client object from Hashtable
        //using a new customer and client object but with same data
        System.out.println("Customer Available: " + ht.containsKey(new Customer(crmId, nameSpace)));
        System.out.println("Client Available: " + ht.containsKey(new Client(crmId, nameSpace)));
    }
}