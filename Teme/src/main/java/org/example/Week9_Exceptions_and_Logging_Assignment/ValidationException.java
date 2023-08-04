package org.example.Week9_Exceptions_and_Logging_Assignment;

public class ValidationException extends Exception{
    public ValidationException(String message){
        super(message);
    }
}
