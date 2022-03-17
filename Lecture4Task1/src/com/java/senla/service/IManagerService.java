package com.java.senla.service;

import com.java.senla.entity.Service;

import java.util.Comparator;

public interface IManagerService {
    void addService(Service service);

    Service[] sortService(Comparator<Service> comparator);
}
