package com.example.firstapp;

public class Employee {

    int empno;
    String name;
    int sal;
    String dept;

    Employee()
    {
        empno=-1;
        name="";
        sal=0;
        dept="NO DEPT";
    }

    public Employee(int empno, String name, int sal, String dept) {
        this.empno = empno;
        this.name = name;
        this.sal = sal;
        this.dept = dept;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
