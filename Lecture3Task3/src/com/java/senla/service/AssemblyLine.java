package com.java.senla.service;

import com.java.senla.entity.LaptopCase;
import com.java.senla.entity.Monitor;
import com.java.senla.entity.Motherboard;

public class AssemblyLine implements IAssemblyLine {

    public AssemblyLine() {
    }

    public IProduct assembleProduct(IProduct iProduct) {
        LaptopCase laptopCase = (LaptopCase) new LaptopCaseLineStep().buildProductPart();
        Monitor monitor = (Monitor) new MonitorLineStep().buildProductPart();
        Motherboard motherboard = (Motherboard) new MotherboardLineStep().buildProductPart();

        System.out.println("Stat ....");
        iProduct.installFirstPat(laptopCase);
        iProduct.installSecondPat(motherboard);
        iProduct.installThirdPat(monitor);
        System.out.println("Completed ....");
        return iProduct;
    }
}
