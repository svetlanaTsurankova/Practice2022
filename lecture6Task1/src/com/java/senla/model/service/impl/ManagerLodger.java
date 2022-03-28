package com.java.senla.model.service.impl;

import com.java.senla.model.data.readers.ImportCSVFile;
import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.entity.StatusRoomEnum;
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

    public void importLodgerCsv(String file) {
        ImportCSVFile importCSVFile = new ImportCSVFile();
        ArrayList<Object> list = importCSVFile.importFile(file);
        if (list != null)
            for (Object o : list) {
                lodgers.add(parseString((ArrayList<Object>) o));
            }
    }

    public Lodger parseString(ArrayList<Object> listparse){
        Lodger newLodger = new Lodger();
        if (listparse !=null){
            for (int i=0;i< listparse.size();i++){
                newLodger.setIdLodger(Integer.parseInt(String.valueOf(listparse.get(0))));
                newLodger.setFullName(String.valueOf(listparse.get(1)));
                newLodger.setDateCheckIn(LocalDate.parse((CharSequence) listparse.get(2)));
                newLodger.setDateCheckOut(LocalDate.parse((CharSequence) listparse.get(3)));
                newLodger.setCost(Double.parseDouble(String.valueOf(listparse.get(6))));
            }
        }
        return newLodger;
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