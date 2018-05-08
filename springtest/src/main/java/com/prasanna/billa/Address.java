package com.prasanna.billa;

public class Address {

    private int addrId;
    private String location;

    /*public Address(int addrId, String location){
        this.addrId = addrId;
        this.location = location;
    }*/

    public int getAddrId() {
        return addrId;
    }

    public String getLocation() {
        return location;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "addrId "+this.addrId+" location "+this.location;
    }
}

//<bean id="addressBean" class="com.prasanna.billa.Address" >
//<property name="addrId" value="100"/>
//<property name="location" value="hyderabad"/>
//</bean>
