package org.example.Week10_Java8_Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileReader {
    public void fileReader(String fileInput, String targetMonth, String fileOutput) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(fileInput));
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
        }

        reader.close();
        writer.close();
    }
}
