package com.java.senla.model.service.impl;


import com.java.senla.model.data.readers.ImportCSVFile;
import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerService;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ManagerService implements IManagerService {
    private int allService;
  private List<Service> services;

    public ManagerService() {
        services= new ArrayList<>();
        services.add(new Service(1, "cleaning", 5.26));
        services.add(new Service(2, "wi-fi in the room", 6.25));
        services.add(new Service(3, "food in the room", 7.63));
        services.add(new Service(4, "car rental", 9.72));
        services.add(new Service(5, "gym", 5.14));

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

    public void exportServiceCsvFile(String file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (Service service : services) {
            printWriter.println(service);
        }
        printWriter.close();
        System.out.println("Export OK");
    }

    public List<Service> importServiceByCsv(String file) {
        ImportCSVFile importCSVFile = new ImportCSVFile();
        ArrayList<Object> list = importCSVFile.importFile(file);
        if (list != null)
            for (Object o : list) {
                services.add(parseString((ArrayList<Object>) o));
            }
        return services;
    }

    public Service parseString(ArrayList<Object> listparse) {
        Service service = new Service();
        if (listparse != null) {
            for (int i = 0; i < listparse.size(); i++) {
                service.setId(Integer.parseInt(String.valueOf(listparse.get(0))));
                service.setServiceName(String.valueOf(listparse.get(1)));
                service.setPrice(Double.parseDouble(String.valueOf(listparse.get(2))));
            }
        }
        return service;
    }

}

