package com.java.senla.model.service;

import com.java.senla.model.entity.Service;

import java.util.Comparator;
import java.util.List;

public interface IManagerService {
    void addService(Service service);

    Service getServiceById(Integer id);

    List<Service> sortService(Comparator<Service> comparator);
}
