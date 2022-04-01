package com.java.senla.utils.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportCSVFile {
    private final String regex = "\\s*;\\s*";

    public ArrayList<Object> importFile(String fileName) {
        ArrayList<Object> line = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String s = bufferedReader.readLine();
            while (s != null) {
                line.add(convertStringCSV(s));
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file" + fileName);
            e.printStackTrace();
        }
        return line;
    }

    public List<String> convertStringCSV(String stringCSV) {
        return Arrays.asList(stringCSV.split(regex));
    }
}
