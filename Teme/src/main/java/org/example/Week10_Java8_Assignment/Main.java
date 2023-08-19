package org.example.Week10_Java8_Assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader();

        String input = "Teme/src/main/resources/personReader.cvs";
        String output = "Teme/src/main/resources/personWriter.cvs";

        reader.fileReader(input, "05", output);
    }
}
