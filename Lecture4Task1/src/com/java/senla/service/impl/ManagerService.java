package com.java.senla.service.impl;

import com.java.senla.entity.Service;
import com.java.senla.service.IManagerService;

import java.util.Arrays;
import java.util.Comparator;

public class ManagerService implements IManagerService {
    private int allService;
    private Service[] services = new Service[5];

    public void addService(Service service) {
        services[allService] = service;
        allService++;
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
