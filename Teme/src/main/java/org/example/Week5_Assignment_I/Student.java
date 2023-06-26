package org.example.Week5_Assignment_I;

public class Student extends Person {
    String numeUniversitate;

    public Student(String numeUniversitate, String name, int age, int cnp) {
        super(name, age, cnp);
        this.numeUniversitate = numeUniversitate;
    }
}
