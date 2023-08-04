package org.example.Week10_Java8_Assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "Teme/src/main/resources/personReader.cvs";
        String output = "Teme/src/main/resources/personWriter.cvs";
        Main.fileReader(input, "05", output);
    }

    public static void fileReader(String fileInput, String targetMonth, String fileOutput) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
        String line;
        while ((line = reader.readLine()) != null) {
            ArrayList<String> arrayList = new ArrayList<>();

            Stream.of(line.split("[ .]"))
                    .forEach(i -> {
                        arrayList.add(i);
                        if (i.equals(targetMonth)) {
                            try {
                                writer.write(arrayList.get(0) + " - " + arrayList.get(arrayList.size() - 1) + "\n");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    });


//            String[] lines = line.split(" ");
//            String[] date = lines[2].split("\\.");
//            if (date[1].equals(targetMonth)) {
//                writer.write(lines[0] + " - " + date[1] + "\n");
//            }
        }

        reader.close();
        writer.close();
    }
}
