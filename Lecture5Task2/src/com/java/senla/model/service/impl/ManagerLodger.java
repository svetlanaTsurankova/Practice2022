package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerLodger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ManagerLodger implements IManagerLodger {
    private int allLodger = 0;
    private List<Lodger> lodgers;

    public ManagerLodger() {
        lodgers = new ArrayList<>();
        lodgers.add(new Lodger(1, "Ivanov", LocalDate.of(2022, 02, 17), LocalDate.of(2022, 02, 20), new Room(10), null, 505.8));
        lodgers.add(new Lodger(2, "Petrov", LocalDate.of(2022, 02, 12), LocalDate.of(2022, 02, 28), new Room(5), null, 205.8));
        lodgers.add(new Lodger(3, "Sidorov", LocalDate.of(2022, 02, 03), LocalDate.of(2022, 02, 24), new Room(2), null, 205.8));
        lodgers.add(new Lodger(4, "Dubina", LocalDate.of(2022, 02, 19), LocalDate.of(2022, 02, 21), new Room(7), null, 505.8));
    }

    public Lodger getLodgerById(Integer idLodger) {
        for (Lodger lodger : lodgers) {
            if (lodger.getIdLodger() == idLodger) {
                return lodger;
            }
        }
        return null;
    }

    public List<Lodger> getLodgers() {
        return lodgers;
    }

    public void addLodger(Lodger lodger) {
        lodgers.add(lodger);
        allLodger++;
    }

    public List<Service> getLodgerService(Lodger lodger) {
        return lodger.getServices();
    }

    public int getCountLodgerService(Lodger lodger) {
        int count = 0;
        for (int i = 0; i < getLodgerService(lodger).size(); i++) {
            if (lodger.getServices().get(i) != null) {
                count++;
            }
        }
        return count;
    }

    public void addServiceToLodger(Lodger lodger, Service service) {
        int i = getCountLodgerService(lodger);
        lodger.getServices().add(service);
        System.out.println("Lodger add service: " + lodger.getServices().get(i).getServiceName());
    }

    public List<Service> sortLodgesServiceByPrice(Lodger lodger, Comparator<Service> comparator) {
        List<Service> sortedLodgerService = getLodgerService(lodger);
        sortedLodgerService.sort(comparator);
        return sortedLodgerService;
    }
}
