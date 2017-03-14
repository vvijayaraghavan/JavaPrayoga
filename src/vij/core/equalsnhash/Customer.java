package vij.core.equalsnhash;

/**
 * Created by Vijay on 2017, March 13.
 *
 * This class overrides only the equals and not hashcode.
 * By default, the integer representation of the object's memory is returned by Java for hashcode.
 */
public class Customer {

    private long crmId;
    private int nameSpace;

    public Customer() {}

    public Customer(long crmId, int nameSpace) {

        this.crmId = crmId;
        this.nameSpace = nameSpace;
    }

    public long getCrmId() {
        return crmId;
    }

    public void setCrmId(long crmId) {
        this.crmId = crmId;
    }

    public int getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(int nameSpace) {
        this.nameSpace = nameSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (getCrmId() != customer.getCrmId()) return false;
        return getNameSpace() == customer.getNameSpace();
    }

}