package com.photographermembers;
//superclass som Contact
public class Person {
    private String name;
    private String mobileNumber;

    public Person(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public static Person createPerson(String name, String mobileNumber){
        return new Person(name,mobileNumber);
    }
}
