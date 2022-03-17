package com.java.senla;

import com.java.senla.service.AssemblyLine;
import com.java.senla.service.Product;

public class Test {
    public static void main(String[] args) {
        AssemblyLine assemblyLine = new AssemblyLine();
        Product product = new Product();
        assemblyLine.assembleProduct(product);
        System.out.println("laptop assembled");
    }
}
