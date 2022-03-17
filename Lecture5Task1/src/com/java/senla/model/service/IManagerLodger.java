package com.java.senla.model.service;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Service;

import java.util.Comparator;

public interface IManagerLodger {
    void addLodger(Lodger lodger);

    void addServiceToLodger(Lodger lodger, Service service);

    Service[] getLodgerService(Lodger lodger);

    Service[] sortLodgesServiceByPrice(Lodger lodger, Comparator<Service> comparator);
}
