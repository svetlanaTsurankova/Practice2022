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
            this.services =new ArrayList<Service>();
    }

    public int getAllService() {
        return allService;
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
        List<Service> arr = services;
        for (Service service : arr) {
            printWriter.println(service);
        }
        printWriter.close();
        System.out.println("Export OK");
    }

    public List<Service> importServiceByCsv(String file) {
        ImportCSVFile importCSVFile = new ImportCSVFile();
        importCSVFile.importFile(file);
        List<String[]> list = importCSVFile.getNewList();
        if (list != null) {
            for (String[] str : list) {
                Service service = new Service();
                service.setId(Integer.parseInt(str[0]));
                service.setServiceName(str[1]);
                service.setPrice(Double.parseDouble(str[2]));
               services.add(service);
            }
        }
        return services;
    }

}
