package org.example.Week8_IO_Assignment;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    public void test_check_if_throws_NoSuchFileException() {  //nu stiu daca merge corect
        File cvs = new File("Teme/src/main/resources/athl.cvs");
        assertThrows(NoSuchFileException.class, () -> {
            try (CVSReader reader = new CVSReader(Files.newBufferedReader(cvs.toPath()))) {
                String result = reader.readAthletes();
                System.out.println(result);
            }catch (IOException nsfe){
                throw new NoSuchFileException("File not found");
            }
        });

    }
}