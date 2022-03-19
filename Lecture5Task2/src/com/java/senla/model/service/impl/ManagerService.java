package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ManagerService implements IManagerService {
    private int allService;
    private List<Service> services;

    public ManagerService() {
        services = new ArrayList<>();
        services.add(new Service(1, "cleaning", 5.26));
        services.add(new Service(2, "wi-fi in the room", 6.25));
        services.add(new Service(3, "food in the room", 7.63));
        services.add(new Service(4, "car rental", 9.72));
        services.add(new Service(5, "gym", 5.14));
    }

    public int getAllService() {
        return allService;
    }

    public void addService(Service service) {
        services.add(service);
        allService++;
    }

    public Service getServiceById(Integer id) {
        for (Service service : services) {
            if (service.getId() == id) {
                return service;
            }
        }
        return null;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Service> sortService(Comparator<Service> comparator) {
        List<Service> sortService = getServices();
        sortService.sort(comparator);
        return sortService;
    }
}

