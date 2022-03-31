package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Service;
import com.java.senla.model.service.IManagerLodger;
import com.java.senla.utils.readers.ImportCSVFile;
import com.java.senla.utils.writers.ExportToCSVFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ManagerLodger implements IManagerLodger {
    private int allLodger = 0;
    private List<Lodger> lodgers = new ArrayList<>();

    public ManagerLodger() {

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

    public void importLodgerCsv(String file) {
        ImportCSVFile importCSVFile = new ImportCSVFile();
        List<Lodger> lodger = new ArrayList<>();
        ArrayList<Object> list = importCSVFile.importFile(file);
        if (list != null)
            for (Object o : list) {
                lodger.add(parseString((List<Lodger>) o));
                lodgers = lodger.stream().map(old -> lodgers.stream()
                                .filter(update -> old.getIdLodger() == update.getIdLodger() &&
                                        Objects.equals(old.getFullName(), update.getFullName()) &&
                                        old.getDateCheckIn() == update.getDateCheckIn() &&
                                        old.getDateCheckOut() == update.getDateCheckOut())
                                .findFirst()
                                .orElse(old))
                        .collect(Collectors.toList());
            }
    }

    public Lodger parseString(List<Lodger> listparse) {
        Lodger newLodger = new Lodger();
        if (listparse != null) {
            for (int i = 0; i < listparse.size(); i++) {
                newLodger.setIdLodger(Integer.parseInt(String.valueOf(listparse.get(0))));
                newLodger.setFullName(String.valueOf(listparse.get(1)));
                newLodger.setDateCheckIn(LocalDate.parse(String.valueOf(listparse.get(2))));
                newLodger.setDateCheckOut(LocalDate.parse(String.valueOf(listparse.get(3))));
            }
        }
        return newLodger;
    }

    public void exportLodgerCsvFile(String file) {
        ExportToCSVFile exportToCSVFile = new ExportToCSVFile();
        try {
            if (lodgers != null) {
                List<Object> lodger = new ArrayList<>(lodgers);
                exportToCSVFile.writerToCSVFile(file, lodger);
            } else {
                System.out.println("List of services is empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Export OK");
    }
}