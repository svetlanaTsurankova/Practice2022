package com.java.senla.entity;

import com.java.senla.service.IProductPart;

public class Monitor {
    private int sizeMonitor;

    public int getSizeMonitor() {
        return sizeMonitor;
    }

    public void setSizeMonitor(int sizeMonitor) {
        this.sizeMonitor = sizeMonitor;
    }

    public Monitor(int sizeMonitor) {
        this.sizeMonitor = sizeMonitor;
    }
}
