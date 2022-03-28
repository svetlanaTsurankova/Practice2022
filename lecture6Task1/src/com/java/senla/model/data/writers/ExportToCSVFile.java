package com.java.senla.model.data.writers;

import com.java.senla.model.entity.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportToCSVFile {

    public void writerToCSVFile(String file, List list) throws IOException {
        try (PrintWriter printWriter= new PrintWriter(new File(file))) {
            StringBuilder sb = new StringBuilder();
      
            printWriter.write(sb.toString());
        }
        System.out.println("Export OK");

    }

}
