package com.java.senla.model.data.readers;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCSVFile {
    private List<String[]> newList = new ArrayList<>();

    public List<String[]> getNewList() {
        return newList;
    }

    public List<String[]> importFile(String file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                newList.add(line.split(";"));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return newList;
    }
}
