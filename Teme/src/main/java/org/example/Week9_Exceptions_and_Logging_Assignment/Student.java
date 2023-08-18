package org.example.Week9_Exceptions_and_Logging_Assignment;

import java.time.Year;
import java.util.Calendar;

public class Student {
    String firstName;
    String lastName;
    String dateOfBirth;
    String gender;
    String cnp;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, String cnp) throws ValidationException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cnp = cnp;

        validateFirstName(firstName);
        validateLastName(lastName);
        validateDateOfBirth(dateOfBirth);
        validateGender(gender);
        validateCNP(cnp);
    }

    private void validateFirstName(String firstName) throws ValidationException {
        if (firstName.isEmpty()) {
            throw new ValidationException("First name should not be empty.");
        }
    }

    private void validateLastName(String lastName) throws ValidationException {
        if (lastName.isEmpty()) {
            throw new ValidationException("Last name should not be empty.");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) throws ValidationException {
        try {
            int year = Integer.parseInt(dateOfBirth);
            int currentYear = Year.now().getValue();
            if (year < 1900 && year < currentYear - 18) {
                throw new ValidationException("Date of birth should be between 1900 and " + (currentYear - 18));
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Date of birth should be a number. Format example: YYYY");
        }
    }

    private void validateGender(String gender) throws ValidationException {
        if (!gender.equalsIgnoreCase("female") && !gender.equalsIgnoreCase("male")) {
            throw new ValidationException("Gender should be male of female.");
        }
    }

    private void validateCNP(String cnp) throws ValidationException {
        try {
            if (cnp.length() != 13) {
                throw new ValidationException("CNP should be 13 figure long");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("CNP should contain only numbers");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
