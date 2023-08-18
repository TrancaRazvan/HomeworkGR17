package org.example.Week9_Exceptions_and_Logging_Assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class StudentRepository {
    private static Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public static List<Student> students;

    static FileHandler fileHandler = null;

    public StudentRepository()  {
        students = new ArrayList<>();

    }

    static void setupLogger() throws IOException {
        try {
            fileHandler = new FileHandler("Teme/src/main/resources/logger.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        }
    }

    public void addStudent(Student student) {

        students.add(student);
        logger.info("Added student");
        System.out.println(students.get(students.size()-1));
    }

    public  void deleteStudent(String cnp) throws ValidationException {

        if (cnp.isEmpty()) {

            throw new ValidationException("Cnp must not be empty.");
        }
        Student student = getStudentCNP(cnp);
        if (student == null) {
            String e = "Student does not exist";
            logger.info(e);
            throw new ValidationException("Student does not exist");
        }
        System.out.println(student + " removed.");
        students.remove(student);


    }

    public List<Student> retrieveAllStudentsWithAge(String age) throws ValidationException {
        List<Student> listStudens = new ArrayList<>();
        try {
            if (Integer.parseInt(age) < 0) {
                logger.log(Level.SEVERE, "Age should be positive number.");
                throw new ValidationException("Age should be positive number.");
            }


            for (Student student : students) {
                if (calculateDateOfBirth(student) == Integer.parseInt(age)) {
                    listStudens.add(student);
                    System.out.println(student);
                }
            }
        } catch ( NumberFormatException e) {
            throw new NumberFormatException("Age should be a number");
        }
        return listStudens;
    }

    public void orderList(String orderType) throws ValidationException {
        List<Student> sortedList = students;

        if (orderType.isEmpty()) {
            logger.log(Level.SEVERE, "Order type cannot be empty.");
            throw new ValidationException("Order type cannot be empty.");
        }
        if (orderType.equalsIgnoreCase("last name")) {
            sortedList.sort((o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
            for (Student student : sortedList) {
                System.out.println(student);
            }
        } else if (orderType.equalsIgnoreCase("date of birth")) {
            sortedList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getDateOfBirth())));
            for (Student student : sortedList) {
                System.out.println(student);
            }
        } else {
            logger.log(Level.SEVERE, "Order type should be 'Last Name' or 'Date of Birth'.");
            throw new ValidationException("Order type should be 'Last Name' or 'Date of Birth'.");
        }
    }

    private Student getStudentCNP(String cnp) {
        for (Student student : students) {
            if (student.getCnp().equals(cnp)) {
                return student;
            }
        }
        return null;
    }

    private int  calculateDateOfBirth(Student student) {
        int currentYear = Year.now().getValue();
        int dateOfBirth = Integer.valueOf(student.getDateOfBirth());
        return currentYear - dateOfBirth;
    }
}

