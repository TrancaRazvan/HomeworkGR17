package org.example.Week5_Assignment_I;

public class Hired extends Person{
    int salariu;

    public Hired(String name, int age, int cnp, int salariu) {
        super(name, age, cnp);
        this.salariu = salariu;
    }
}
