package com.example.firstapp;

public class Student3 {

    int rollno;
    String name;
    int marks;

    Student3()
    {
        rollno=-1;
        name="NO NAME";
        marks=0;
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
