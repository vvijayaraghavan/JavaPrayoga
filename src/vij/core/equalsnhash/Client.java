package vij.core.equalsnhash;

/**
 * Created by Vijay on 2017, March 13.
 *
 * This class overrides only the equals and hashcode.
 *
 * By overriding hashcode, we always return a same value based on the variables used in equals to check the equality of the object.
 * In this case, Java will not use the integer representation of the memory of the object which may be different though the values of
 * the variables as per equals are identical.
 *
 * So, its always better to override equals and hashcode if you use the object on any Hash based Collection.
 *
 * Reference:
 *      http://www.xyzws.com/javafaq/why-always-override-hashcode-if-overriding-equals/20
 */
public class Client {

    private long crmId;
    private int nameSpace;

    public Client() {}

    public Client(long crmId, int nameSpace) {

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

        Client client = (Client) o;

        if (getCrmId() != client.getCrmId()) return false;
        return getNameSpace() == client.getNameSpace();
    }

    @Override
    public int hashCode() {
        int result = (int) (getCrmId() ^ (getCrmId() >>> 32));
        result = 31 * result + getNameSpace();
        return result;
    }

}