package com.java.senla.model.service;

import com.java.senla.model.entity.Service;

import java.util.Comparator;

public interface IManagerService {
    void addService(Service service);

    Service[] sortService(Comparator<Service> comparator);
}
