package org.example.Week5_Assignment_I;

import java.util.*;

public class Person {
   private String name;
    private int age;
    private int cnp;
    public Person(String name, int age, int cnp) {
        this.name = name;
        this.age = age;
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCnp() {
        return cnp;
    }


    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && cnp == person.cnp && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, cnp);
    }
}
