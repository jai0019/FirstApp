package com.example.firstapp;

public class Student2 {

    int rollno;
    String name;
    int marks;
    String photo;

    Student2(int rollno,String name, int marks, String photo)
    {
        this.rollno=rollno;
        this.name=name;
        this.marks=marks;
        this.photo=photo;
    }


    Student2()
    {
        rollno=0;
        name="NO NAME";
        marks=0;
        photo="";
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
