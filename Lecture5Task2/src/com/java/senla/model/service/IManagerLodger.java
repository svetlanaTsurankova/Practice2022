package com.java.senla.model.service;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Service;

import java.util.Comparator;
import java.util.List;

public interface IManagerLodger {
    void addLodger(Lodger lodger);

    void addServiceToLodger(Lodger lodger, Service service);

    List<Service> getLodgerService(Lodger lodger);

    List<Service> sortLodgesServiceByPrice(Lodger lodger, Comparator<Service> comparator);
}
