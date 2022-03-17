package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerService;

import java.util.Arrays;
import java.util.Comparator;

public class ManagerService implements IManagerService {
    private int allService;
    private Service[] services = new Service[5];

    public ManagerService() {
        services = new Service[]{
                services[0] = new Service(1, "cleaning", 5.26),
                services[1] = new Service(2, "wi-fi in the room", 6.25),
                services[2] = new Service(3, "food in the room", 7.63),
                services[3] = new Service(4, "car rental", 9.72),
                services[4] = new Service(5, "gym", 5.14),
        };
    }

    public void addService(Service service) {
        services[allService] = service;
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

    public Service[] getServices() {
        return services;
    }

    public Service[] sortService(Comparator<Service> comparator) {
        Service[] sortService = services;
        Arrays.sort(sortService, comparator);
        return sortService;
    }
}
