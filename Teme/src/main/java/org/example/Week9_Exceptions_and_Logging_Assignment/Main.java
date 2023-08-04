package org.example.Week9_Exceptions_and_Logging_Assignment;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException, ValidationException {
        StudentRepository studentRepository = new StudentRepository();

        Student student1 = new Student("Alex", "Alex", "1999", "male", "0123454123451");
        Student student2 = new Student("Laur", "Laur", "2001", "male", "0124454234234");
        Student student3 = new Student("Ana", "Ana", "1999", "female", "1123453667543");
        Student student4 = new Student("Maria", "Maria", "2004", "female", "0123451241231");
        Student student5 = new Student("Cristina", "Cristina", "1995", "female", "0123454354675");

        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.addStudent(student3);
        studentRepository.addStudent(student4);
        studentRepository.addStudent(student5);

        studentRepository.deleteStudent("0123454354675");
         // studentRepository.deleteStudent("0111111111111");

        System.out.println("retrieveAllStudentsWithAge");
        studentRepository.retrieveAllStudentsWithAge("22");
        //   studentRepository.retrieveAllStudentsWithAge("asd12");
        //  studentRepository.retrieveAllStudentsWithAge("-22");

        System.out.println("orderList last name");
        studentRepository.orderList("Last Name");
        System.out.println("orderList date of birth");
        studentRepository.orderList("date of birth");
        //   studentRepository.orderList("");

    }
}
