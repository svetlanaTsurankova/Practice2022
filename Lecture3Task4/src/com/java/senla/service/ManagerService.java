package com.java.senla.service;

import com.java.senla.entity.Service;

public class ManagerService {
    private int allService;
    private Service[] services = new Service[5];

    public int getAllService() {
        return allService;
    }

    public void addService(Service service) {
        services[allService] = service;
        allService++;
        StringBuilder s = new StringBuilder();
        s.append(service);
    }

    public Service[] getServices() {
        return services;
    }

}
