package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerLodger;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ManagerLodger implements IManagerLodger {

    private Lodger[] lodgers = new Lodger[4];
    private int allLodger = 0;

    public ManagerLodger() {
        lodgers = new Lodger[]{
                lodgers[0] = new Lodger(1, "Ivanov", LocalDate.of(2022, 02, 17), LocalDate.of(2022, 02, 20), new Room(110), null, 505.8),
                lodgers[1] = new Lodger(2, "Petrov", LocalDate.of(2022, 02, 12), LocalDate.of(2022, 02, 28), new Room(105), null, 205.8),
                lodgers[2] = new Lodger(3, "Sidorov", LocalDate.of(2022, 02, 03), LocalDate.of(2022, 02, 24), new Room(102), null, 205.8),
                lodgers[3] = new Lodger(4, "Dubina", LocalDate.of(2022, 02, 19), LocalDate.of(2022, 02, 21), new Room(107), null, 505.8),
        };
    }

    public Lodger getLodgerById(Integer idLodger) {
        for (Lodger lodger : lodgers) {
            if (lodger.getIdLodger() == idLodger) {
                return lodger;
            }
        }
        return null;
    }

    public Lodger[] getLodgers() {
        return lodgers;
    }

    public void addLodger(Lodger lodger) {
        lodgers[allLodger] = lodger;
        allLodger++;
    }

    public Service[] getLodgerService(Lodger lodger) {
        return lodger.getServices();
    }

    public int getCountLodgerService(Lodger lodger) {
        int count = 0;
        for (int i = 0; i < getLodgerService(lodger).length; i++) {
            if (lodger.getServices()[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void addServiceToLodger(Lodger lodger, Service service) {
        int i = getCountLodgerService(lodger);
        lodger.getServices()[i] = service;
        System.out.println("Lodger add service: " + lodger.getServices()[i].getServiceName());
    }

    public Service[] sortLodgesServiceByPrice(Lodger lodger, Comparator<Service> comparator) {
        Service[] sortedLodgerService = getLodgerService(lodger);
        Arrays.sort(sortedLodgerService, comparator);
        return sortedLodgerService;
    }
}
