package com.java.senla.service;

import com.java.senla.entity.Lodger;
import com.java.senla.entity.Room;
import com.java.senla.entity.Service;

import java.time.LocalDate;

public class ManagerHotel {
    ManagerRoom roomManager = new ManagerRoom();
    ManagerService managerService = new ManagerService();
    ManagerLodger managerLodger = new ManagerLodger();

    public void showAllRooms() {
        Room rooms[] = roomManager.getRooms();
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("room number : " + rooms[i].getNumberRoom() + ", capacity: " + rooms[i].getCapacity() + ", price: " +
                    rooms[i].getPrice() + ",status Room : " + rooms[i].getStatus() + ", stars Room : " + rooms[i].getStarsRoom() + ",occupied Room : " + rooms[i].getOccupiedRoom());
        }
    }

    public void showAllServices() {
        Service services[] = managerService.getServices();
        for (int i = 0; i < services.length; i++) {
            System.out.println("Service : " + services[i].getServiceName() + ", price : " + services[i].getPrice());
        }
    }

    public void showAllLodger() {
        Lodger lodgers[] = managerLodger.getLodgers();
        for (int i = 0; i < lodgers.length; i++) {
            System.out.println(lodgers[i].getFullName());
        }
    }

    public void createRoom(Room room) {
        roomManager.addRoom(room);
    }

    public void createService(Service service) {
        managerService.addService(service);
    }

    public void receiveLodger(Lodger lodger) {
        managerLodger.addLodger(lodger);
    }

    public void checkIn(Lodger lodger, Room room, LocalDate dateIn, LocalDate dateOut) {
        if (room.getStatus() == "Serviced" & room.getOccupiedRoom() == true) {
            room.setOccupiedRoom(true);
            StringBuilder s = new StringBuilder();
            s.append("Lodger ");
            s.append(lodger.getFullName());
            s.append(" checked in room ");
            s.append(room.getNumberRoom());
            System.out.println(s.toString());
        } else if (room.getStatus() == "Serviced" & room.getOccupiedRoom() == false) {
            StringBuilder s = new StringBuilder();
            s.append(" Room  ");
            s.append(room.getNumberRoom());
            s.append(" was rented ");
            System.out.println(s.toString());
        } else {
            StringBuilder s = new StringBuilder();
            s.append(" Room    ");
            s.append(room.getNumberRoom());
            s.append("   is being renovated ");
            System.out.println(s.toString());
        }
    }


    public void checkOut(Lodger lodger, Room room) {
        if (room.getOccupiedRoom() == true) {
            StringBuilder s = new StringBuilder();
            s.append(" Room    ");
            s.append(room.getNumberRoom());
            s.append("   check out  ");
            s.append(lodger.getFullName());
            System.out.println(s.toString());
        }else {
            System.out.println(" Room is empty");
        }
    }

    public void changePriceRoom(Room room, double price) {
        room.setPrice(price);
    }

    public void changeStatusRoom(Room room) {
        if (room.getStatus() == "Renovate") {
            room.setStatus("Serviced");
            System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
        } else {
            room.setStatus("Renovate");
            System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
        }
    }

    public void changePriceService(Service service, double price) {
        service.setPrice(price);
        System.out.println("Change price service " + service.getServiceName() + "  new pice :  " + service.getPrice());
    }

    public void addService(Lodger lodger, Service service) {
        managerLodger.addServiceToLodger(lodger, service);
        System.out.println("Lodger  " + lodger.getFullName() + " add service :  " + service.getServiceName());
    }
}
