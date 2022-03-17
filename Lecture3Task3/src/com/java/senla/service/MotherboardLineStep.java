package com.java.senla.service;

import com.java.senla.entity.Motherboard;

public class MotherboardLineStep implements ILineStep {
    Motherboard motherboard = new Motherboard("HDD4");

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Motherboard building");
        return this.motherboard;
    }
}
