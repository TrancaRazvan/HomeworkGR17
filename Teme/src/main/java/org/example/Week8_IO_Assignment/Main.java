package org.example.Week8_IO_Assignment;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class Main {
    public static void main(String[] args) throws IOException {
        File cvs = new File("Teme/src/main/resources/athlete.cvs");
        try(CVSReader reader = new CVSReader(Files.newBufferedReader(cvs.toPath()))) {
            String result = reader.readAthletes();
            System.out.println(result);
        }

    }

}
