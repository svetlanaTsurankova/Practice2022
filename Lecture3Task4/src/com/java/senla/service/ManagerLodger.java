package com.java.senla.service;

import com.java.senla.entity.Lodger;
import com.java.senla.entity.Service;

public class ManagerLodger {
    private Lodger[] lodgers = new Lodger[4];
    private int allLodger = 0;

    public Lodger[] getLodgers() {
        return lodgers;
    }

    public void setLodgers(Lodger[] lodgers) {
        this.lodgers = lodgers;
    }

    public void addLodger(Lodger lodger) {
        lodgers[allLodger] = lodger;
        allLodger++;
        StringBuilder s = new StringBuilder();
        s.append(lodger);
    }

    public void addServiceToLodger(Lodger lodger, Service service) {
        StringBuilder s = new StringBuilder();
        s.append(lodger);
        s.append(service);
    }
}
