package com.java.senla.model.data.writers;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportToCSVFile {

    public void writerToCSVFile(String file, List list) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        String line = String.valueOf(list.toString().split(";"));
        while (line != null) {
            dataOutputStream.writeBytes(line);
        }
        dataOutputStream.close();

    }

}
