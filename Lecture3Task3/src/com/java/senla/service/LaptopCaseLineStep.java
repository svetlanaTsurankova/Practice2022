package com.java.senla.service;

import com.java.senla.entity.LaptopCase;

public class LaptopCaseLineStep implements ILineStep {
    LaptopCase laptopCase = new LaptopCase(15);

    @Override
    public IProductPart buildProductPart() {
        System.out.println("LaptopCase building");
        return this.laptopCase;
    }
}
