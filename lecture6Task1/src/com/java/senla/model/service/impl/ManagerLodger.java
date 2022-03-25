package com.java.senla.model.service.impl;

import com.java.senla.model.data.readers.ImportCSVFile;
import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerLodger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ManagerLodger implements IManagerLodger {
    private int allLodger = 0;
    private List<Lodger> lodgers;

    public ManagerLodger() {
        lodgers = new ArrayList<>();
    }

    public Lodger getLodgerById(Integer idLodger) {
        for (Lodger lodger : lodgers) {
            if (lodger.getIdLodger() == idLodger) {
                return lodger;
            }
        }
        return null;
    }

    public List<Lodger> getLodgers() {
        return lodgers;
    }

    public void addLodger(Lodger lodger) {
        lodgers.add(lodger);
        allLodger++;
    }

    public List<Service> getLodgerService(Lodger lodger) {
        return lodger.getServices();
    }

    public int getCountLodgerService(Lodger lodger) {
        int count = 0;
        for (int i = 0; i < getLodgerService(lodger).size(); i++) {
            if (lodger.getServices().get(i) != null) {
                count++;
            }
        }
        return count;
    }

    public void addServiceToLodger(Lodger lodger, Service service) {
        int i = getCountLodgerService(lodger);
        lodger.getServices().add(service);
        System.out.println("Lodger add service: " + lodger.getServices().get(i).getServiceName());
    }

    public List<Service> sortLodgesServiceByPrice(Lodger lodger, Comparator<Service> comparator) {
        List<Service> sortedLodgerService = getLodgerService(lodger);
        sortedLodgerService.sort(comparator);
        return sortedLodgerService;
    }

    public List<Lodger> importLodgerCsv(String file) {
        ImportCSVFile importCSVFile = new ImportCSVFile();
        importCSVFile.importFile(file);
        List<String[]> list = importCSVFile.getNewList();
        if (list != null) {
            for (String[] arr : list) {
                Lodger newLodger = new Lodger();
                newLodger.setIdLodger(Integer.parseInt(arr[0]));
                newLodger.setFullName(arr[1]);
                newLodger.setDateCheckIn(LocalDate.parse(arr[2]));
                newLodger.setDateCheckOut(LocalDate.parse(arr[3]));
                newLodger.setCost(Double.parseDouble(arr[6]));
                lodgers.add(newLodger);
            }
        }
        return lodgers;
    }

    public void exportLodgerCsvFile(String file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        List<Lodger> arr = lodgers;
        for (Lodger lodger : arr) {
            printWriter.println(lodger);
        }
        printWriter.close();
        System.out.println("Export OK");
    }
}