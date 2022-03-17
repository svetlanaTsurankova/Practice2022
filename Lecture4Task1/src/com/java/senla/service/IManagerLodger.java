package com.java.senla.service;

import com.java.senla.entity.Lodger;
import com.java.senla.entity.Service;

import java.util.Comparator;

public interface IManagerLodger {
    void addLodger(Lodger lodger);

    void addServiceToLodger(Lodger lodger, Service service);

    Service[] getLodgerService(Lodger lodger);

   // Lodger[] sortLodger(Comparator<Lodger> comparator);

   Service[] sortLodgesServiceByPrice(Lodger lodger, Comparator<Service> comparator);
}
