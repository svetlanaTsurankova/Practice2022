package com.java.senla.model.service.impl;


import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerService;
import com.java.senla.utils.readers.ImportCSVFile;
import com.java.senla.utils.writers.ExportToCSVFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ManagerService implements IManagerService {
    private int allService;
    private List<Service> services = new ArrayList<>();
    private static ManagerService managerService;

    public static ManagerService serviceManager() {
        if (managerService == null) {
            managerService = new ManagerService();
        }
        return managerService;
    }
    public ManagerService() {
    }

    public void addService(Service service) {
        services.add(service);
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> sortService(Comparator<Service> comparator) {
        List<Service> sortService = getServices();
        sortService.sort(comparator);
        return sortService;
    }

    public void exportServiceCsvFile(String file) {
        ExportToCSVFile exportToCSVFile = new ExportToCSVFile();
        try {
            if (services != null) {
                List<Object> service = new ArrayList<>(services);
                exportToCSVFile.writerToCSVFile(file, service);
            } else {
                System.out.println("List of services is empty");
            }
        } catch (IOException e) {
            System.err.println("File export error!");
            e.printStackTrace();
        }
        System.out.println("Export OK");
    }

    public void importServiceByCsv(String file) {
        ImportCSVFile importCSVFile = new ImportCSVFile();
        List<Service> service = new ArrayList<>();
        ArrayList<Object> list = importCSVFile.importFile(file);
        if (list != null)
            for (Object o : list) {
                service.add(parseString((List<Service>) o));
                services = service.stream().map(old -> services.stream()
                                .filter(update -> old.getId() == update.getId() &&
                                        Objects.equals(old.getServiceName(), update.getServiceName()) &&
                                        old.getPrice() == update.getPrice())
                                .findFirst()
                                .orElse(old))
                        .collect(Collectors.toList());
            }
    }

    public Service parseString(List<Service> listparse) {
        Service service = new Service();
        for (int i = 0; i < listparse.size(); i++) {
            service.setId(Integer.parseInt(String.valueOf(listparse.get(0))));
            service.setServiceName(String.valueOf(listparse.get(1)));
            service.setPrice(Double.parseDouble(String.valueOf(listparse.get(2))));
        }
        return service;
    }
}

