package com.java.senla.model.data.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportCSVFile {

    public ArrayList<Object> importFile(String file) {
        BufferedReader bufferedReader;
        ArrayList<Object> line = new ArrayList<>();
        String s;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((s = bufferedReader.readLine()) != null) {
                line.add(convertStringCSV(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public ArrayList<String> convertStringCSV(String stringCSV) {
        ArrayList<String> newArray = new ArrayList<>();
        if (stringCSV != null) {
            String[] split = stringCSV.split("\\s*;\\s*");
            for (String s : split) {
                if ((s == null) || !(s.length() == 0)) {
                    newArray.add(s.trim());
                }
            }
        }
        return newArray;
    }
}
