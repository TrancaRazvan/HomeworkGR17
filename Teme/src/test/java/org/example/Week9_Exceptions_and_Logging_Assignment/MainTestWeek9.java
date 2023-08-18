package org.example.Week9_Exceptions_and_Logging_Assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTestWeek9 {

    @Test
    public void test_remove_student_bycnp_succes() throws ValidationException {
        StudentRepository studentRepository = new StudentRepository();

        Student student1 = new Student("Alex", "Alex", "1999", "male", "0123454123451");

        studentRepository.addStudent(student1);

       assertThrows(ValidationException.class,() -> studentRepository.deleteStudent("0111111111111"));

    }

    @Test
    public void test_retrieveAllStudentsWithAge_negative_succes() throws ValidationException {

        StudentRepository studentRepository = new StudentRepository();

        Student student1 = new Student("Alex", "Alex", "1999", "male", "0123454123451");

        studentRepository.addStudent(student1);

        assertThrows(ValidationException.class,() -> studentRepository.retrieveAllStudentsWithAge("-22"));

    }
    @Test
    public void test_retrieveAllStudentsWithAge_not_a_number_succes() throws ValidationException {

        StudentRepository studentRepository = new StudentRepository();

        Student student1 = new Student("Alex", "Alex", "1999", "male", "0123454123451");

        studentRepository.addStudent(student1);

        assertThrows(NumberFormatException.class,() -> studentRepository.retrieveAllStudentsWithAge("asd"));

    }
}