package com.java.senla.model.service;

import com.java.senla.model.entity.Service;

import java.util.Comparator;

public interface IManagerService {
    void addService(Service service);

    Service getServiceById(Integer id);

    Service[] sortService(Comparator<Service> comparator);
}
