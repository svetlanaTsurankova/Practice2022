package com.java.senla.service;

import com.java.senla.entity.Monitor;

public class MonitorLineStep implements ILineStep{
    Monitor monitor = new Monitor(15);

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Monitor building");
        return this.monitor;
    }
}
