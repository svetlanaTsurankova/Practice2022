package com.java.senla.entity;

import com.java.senla.service.IProductPart;

public class LaptopCase {
    private int sizeLaptopCase;

    public int getSizeLaptopCase() {
        return sizeLaptopCase;
    }

    public void setSizeLaptopCase(int sizeLaptopCase) {
        this.sizeLaptopCase = sizeLaptopCase;
    }

    public LaptopCase(int sizeLaptopCase) {
        this.sizeLaptopCase = sizeLaptopCase;
    }
}
