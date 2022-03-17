package com.java.senla.service;

import com.java.senla.entity.LaptopCase;
import com.java.senla.entity.Monitor;
import com.java.senla.entity.Motherboard;
import com.java.senla.service.IProduct;
import com.java.senla.service.IProductPart;

public class Product implements IProduct{
    private LaptopCase laptopCase;
    private Motherboard motherboard;
    private Monitor monitor;

    public Product() {
    }

    public void installFirstPat(IProductPart firstProductPart) {
        laptopCase = (LaptopCase) firstProductPart;
        System.out.println("Install laptopCase");
    }

    public void installSecondPat(IProductPart secondProductPart) {
        motherboard = (Motherboard) secondProductPart;
        System.out.println("Install motherboard");
    }

    public void installThirdPat(IProductPart thirdProductPart) {
        monitor = (Monitor) thirdProductPart;
        System.out.println("Install monitor");
    }
}
