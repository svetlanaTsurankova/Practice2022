package com.java.senla.utils.writers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExportToCSVFile {
    private final String regex = "\\s*,";

    public void writerToCSVFile(String fileName, List<Object> list) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            List<Object> arr = new ArrayList<>(list);
            for (Object o : arr) {
                String[] split = o.toString().split(regex);
                printWriter.write(String.join(";", split));
                printWriter.write("\n");
            }
        }
    }
}
