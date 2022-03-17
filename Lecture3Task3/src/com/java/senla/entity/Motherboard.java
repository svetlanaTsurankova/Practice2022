package com.java.senla.entity;

import com.java.senla.service.IProductPart;

public class Motherboard {
    private String installHdd;

    public String getInstallHdd() {
        return installHdd;
    }

    public void setInstallHdd(String installHdd) {
        this.installHdd = installHdd;
    }

    public Motherboard(String installHdd) {
        this.installHdd = installHdd;
    }
}
