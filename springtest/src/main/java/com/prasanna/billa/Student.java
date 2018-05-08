package com.prasanna.billa;

import java.util.List;

public class Student {
    private String name;
    private String phoneNo;
    private Address address;
    private List<Courses> courses;


    public String getPhoneNo() {
        return phoneNo;
    }

    public Address getAddress() {
        return address;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void displayInfo(){
        System.out.println("Hello: "+name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address=" + address +
                ", courses=" + courses +
                '}';
    }
}
