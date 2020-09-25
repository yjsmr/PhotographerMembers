package com.photographermembers;
//subclass like programmer
public class Member extends Person{
    private String cameraBrand;
    private String genre;

    public Member(String name, String mobileNumber, String cameraBrand, String genre){
        super(name, mobileNumber);
        this.cameraBrand = cameraBrand;
        this.genre = genre;
    }

    public String getCameraBrand(){
        return cameraBrand;
    }

    public String getGenre(){
        return genre;
    }
}
