package com.java.senla.service;

import com.java.senla.entity.Lodger;
import com.java.senla.entity.Room;
import com.java.senla.entity.Service;
import com.java.senla.service.impl.ManagerLodger;
import com.java.senla.service.impl.ManagerRoom;
import com.java.senla.service.impl.ManagerService;
import com.java.senla.sorters.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;


public class ManagerHotel {
    ManagerRoom managerRoom = new ManagerRoom();
    ManagerService managerService = new ManagerService();
    ManagerLodger managerLodger = new ManagerLodger();

    public void showAllRooms() {
        Room[] rooms = managerRoom.getRooms();
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    public void showAllFreeRooms() {
        Room[] freeRooms = managerRoom.getFreeRooms();
        for (Room room : freeRooms) {
            System.out.println(room.toString());
        }
    }

    public void showAllServices() {
        Service[] services = managerService.getServices();
        for (Service service : services) {
            System.out.println(service.toString());
        }
    }

    public void showAllLodger() {
        Lodger[] lodgers = managerLodger.getLodgers();
        for (Lodger lodger : lodgers) {
            System.out.println(lodger.toString());
        }
    }

    public void createRoom(Room room) {
        managerRoom.addRoom(room);
    }

    public void createService(Service service) {
        managerService.addService(service);
    }

    public void receiveLodger(Lodger lodger) {
        managerLodger.addLodger(lodger);
    }

    public void checkIn(Lodger lodger, Room room, LocalDate dateIn, LocalDate dateOut) {
        if (room.getStatus().equals("SERVICED")) {
            lodger.setFullName(lodger.getFullName());
            lodger.setRoom(room);
            lodger.setDateCheckIn(dateIn);
            lodger.setDateCheckOut(dateOut);
            lodger.getRoom().setStatus("OCCUPIED");
            lodger.getRoom().setLodgers(managerLodger.getLodgers());
            System.out.println(lodger.getFullName() + ", was checked-in. Room #" + room.getNumberRoom());
        } else if (room.getStatus().equals("OCCUPIED")) {
            System.out.println("Room #" + room.getNumberRoom() + " is being occupied now.");
        } else {
            System.out.println(" Room " + room.getNumberRoom() + "   is being renovated ");
        }
    }

    public void checkOut(Lodger lodger, Room room) {
        if (room.getStatus().equals("SERVICED")) {
            System.out.println(" The Room# " + room.getNumberRoom() + "   has no lodgers ");
        } else if (room.getStatus().equals("OCCUPIED")) {
            room.setStatus("SERVICED");
            System.out.println(lodger.getFullName() + " has checked-out from Room #" + room.getNumberRoom());
        } else {
            System.out.println("Renovate Room #" + room.getNumberRoom());
        }
    }

    public void changePriceRoom(Room room, double price) {
        room.setPrice(price);
    }

    public void changeStatusRoom(Room room) {
        if (room.getStatus().equals("RENOVATE")) {
            room.setStatus("SERVICED");
            System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
        } else if (room.getStatus().equals("SERVICED")) {
            room.setStatus("RENOVATE");
            System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
        }
    }

    public void changePriceService(Service service, double price) {
        service.setPrice(price);
        System.out.println("Change price service " + service.getServiceName() + "  new price :  " + service.getPrice());
    }

    public void sortRoom(Comparator<Room> roomComparator) {
        Arrays.sort(managerRoom.getRooms(), roomComparator);
    }

    public void sortFreeRoom(Comparator<Room> roomFreeComparator) {
        Arrays.sort(managerRoom.getFreeRooms(), roomFreeComparator);
    }

    public void sortLodger(Comparator<Lodger> lodgerComparator) {
        Arrays.sort(managerLodger.getLodgers(), lodgerComparator);
    }

    public void countFreeRooms() {
        System.out.println(" Count free room  " + managerRoom.getCountFreeRooms());
    }

    public void countLodger() {
        System.out.println(" Count lodger " + managerLodger.getLodgers().length);
    }

    public void sortedServiceByPrice() {
        Service[] sortService = managerService.sortService(new SortingServiceByPrice());
        for (Service service : sortService) {
            System.out.println("sorting service by price : " + service.toString());
        }
    }

    public void showEmptyRoomOnDate(LocalDate date) {
        Room[] rooms = managerRoom.getRooms();
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room != null && room.getStatus().equals("OCCUPIED")) {
                for (int k = 0; k < room.getLodgers().length; k++) {
                    if (date.isBefore(room.getLodgers()[k].getDateCheckIn()) ||
                            date.isAfter(room.getLodgers()[k].getDateCheckOut())) {
                        System.out.println(room.getNumberRoom());
                    }
                }
            }
        }
        for (Room value : rooms) {
            if (value != null && value.getStatus().equals("SERVICED")) {
                System.out.println(value.getNumberRoom());
            }
        }
    }

    public void billRoom(Lodger lodger) {
        if (lodger.getDateCheckIn() != null && lodger.getDateCheckOut() != null) {
            Period period = Period.between(lodger.getDateCheckIn(), lodger.getDateCheckOut());
            double bill = lodger.getRoom().getPrice() * period.getDays();
            System.out.println(lodger.getFullName() + " need pay " + bill);
        } else {
            System.out.println(lodger.getFullName() + "not lodger ");
        }
    }

    public void showLastLodgersRoom(Room room) {
        Lodger[] r = room.getLodgers();
        if (r.length <= 3) {
            for (int i = 0; i < r.length; i++) {
                System.out.println("showLastLodgersRoom " + r[i].getFullName() + " "
                        + r[i].getRoom().toString() + "  " + r[i].getDateCheckIn() + " - " + r[i].getDateCheckOut());
            }
        } else {
            for (int i = r.length - 3; i < r.length; i++) {
                System.out.println("showLastLodgersRoom " + r[i].getFullName() + " "
                        + r[i].getRoom().toString() + "  " + r[i].getDateCheckIn() + " - " + r[i].getDateCheckOut());
            }
        }
    }

    public void addService(Lodger lodger, Service service) {
        managerLodger.addServiceToLodger(lodger, service);
    }

    public void sortLodgerService(Lodger lodger) {
        Service[] sortService = managerLodger.sortLodgesServiceByPrice(lodger, new SortingServiceByPrice());
        for (Service service : sortService) {
            if (service != null) {
                service.getServiceName();
                service.getPrice();
                System.out.println("sorting lodger: " + lodger.getFullName() + ", service by price : " + service.getServiceName() + "(" +
                        +service.getPrice() + ")");
            }
        }
    }

    public void printDetailsOfRoom(Room room) {
        Room r = managerRoom.getRoomById(room.getId());
        System.out.println(" Details room: " + r.toString());

    }
}
