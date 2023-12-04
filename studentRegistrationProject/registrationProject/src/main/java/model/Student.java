package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    public static int rollNumberCounter = 1001;

    String name;
    String address;
    String contact;
    String email;
    String studentRollNumber;

    public Student() {
        this.studentRollNumber="ZorbaStd"+rollNumberCounter++;
    }

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public static String getStudentRollNumber() {
//        return ("ZorbaStd" + getRollNumber()) ;
//    }

    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }


}
