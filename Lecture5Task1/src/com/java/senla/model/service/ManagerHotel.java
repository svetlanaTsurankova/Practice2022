package com.java.senla.model.service;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.entity.StatusRoomEnum;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.model.service.impl.ManagerService;
import com.java.senla.model.sorters.SortingServiceByPrice;

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
        if (room == null) {
            System.out.println("Incorrect input");
        } else {
            managerRoom.addRoom(room);
        }
    }

    public void createService(Service service) {
        if (service == null) {
            System.out.println("Incorrect input");
        } else {
            managerService.addService(service);
        }
    }

    public void receiveLodger(Lodger lodger) {
        if (lodger == null) {
            System.out.println("Incorrect input");
        } else {
            managerLodger.addLodger(lodger);
        }
    }

    public void checkIn(Lodger lodger, Room room, LocalDate dateIn, LocalDate dateOut) {
        if (room == null || lodger == null) {
            System.out.println("Incorrect input");
        } else {
            if (room.getStatus().equals(StatusRoomEnum.SERVICED)) {
                lodger.setFullName(lodger.getFullName());
                lodger.setRoom(room);
                lodger.setDateCheckIn(dateIn);
                lodger.setDateCheckOut(dateOut);
                lodger.getRoom().setStatus(StatusRoomEnum.OCCUPIED);
                lodger.getRoom().setLodgers(managerLodger.getLodgers());
                System.out.println(lodger.getFullName() + ", was checked-in. Room #" + room.getNumberRoom());
            } else if (room.getStatus().equals(StatusRoomEnum.OCCUPIED)) {
                System.out.println("Room #" + room.getNumberRoom() + " is being occupied now.");
            } else {
                System.out.println(" Room " + room.getNumberRoom() + "   is being renovated ");
            }
        }
    }

    public void checkOut(Lodger lodger, Room room) {
        if (room == null || lodger == null) {
            System.out.println("Incorrect input");
        } else {
            if (room.getStatus().equals(StatusRoomEnum.SERVICED)) {
                System.out.println(" The Room# " + room.getNumberRoom() + "   has no lodgers ");
            } else if (room.getStatus().equals(StatusRoomEnum.OCCUPIED)) {
                room.setStatus(StatusRoomEnum.SERVICED);
                System.out.println(lodger.getFullName() + " has checked-out from Room #" + room.getNumberRoom());
            } else {
                System.out.println("Renovate Room #" + room.getNumberRoom());
            }
        }
    }

    public void changePriceRoom(Room room, double price) {
        if (room == null) {
            System.out.println("Incorrect input");
        } else {
            room.setPrice(price);
        }
    }

    public void changeStatusRoom(Room room) {
        if (room == null) {
            System.out.println("Incorrect input");
        } else {
            if (room.getStatus().equals(StatusRoomEnum.RENOVATE)) {
                room.setStatus(StatusRoomEnum.SERVICED);
                System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
            } else if (room.getStatus().equals(StatusRoomEnum.SERVICED)) {
                room.setStatus(StatusRoomEnum.RENOVATE);
                System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
            }
        }
    }

    public void changePriceService(Service service, double price) {
        if (service == null) {
            System.out.println("Incorrect input");
        } else {
            service.setPrice(price);
            System.out.println("Change price service " + service.getServiceName() + "  new price :  " + service.getPrice());
        }
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
        Room[] room = managerRoom.getRooms();
        for (int i = 0; i < room.length; i++) {
            Room r= room[i];
            if (r != null && r.getStatus().equals(StatusRoomEnum.OCCUPIED)) {
                for (int k = 0; k < r.getLodgers().length; k++) {
                    if (date.isBefore(r.getLodgers()[k].getDateCheckIn()) || date.isAfter(r.getLodgers()[k].getDateCheckOut())) {
                        System.out.println(r.getNumberRoom());
                    }
                }
            }
        }
        for (Room value : room) {
            if (value != null && value.getStatus().equals(StatusRoomEnum.SERVICED)) {
                System.out.println(value.getNumberRoom());
            }
        }
    }

    public void billRoom(Lodger lodger) {
        if (lodger == null) {
            System.out.println("Incorrect input");
        } else {
            if (lodger.getDateCheckIn() != null && lodger.getDateCheckOut() != null) {
                Period period = Period.between(lodger.getDateCheckIn(), lodger.getDateCheckOut());
                double bill = lodger.getRoom().getPrice() * period.getDays();
                System.out.println(lodger.getFullName() + " need pay " + bill);
            } else {
                System.out.println(lodger.getFullName() + "not lodger ");
            }
        }
    }

    public void showLastLodgersRoom(Room room) {
        if (room == null) {
            System.out.println("Incorrect input");
        } else {
            Lodger[] r = room.getLodgers();
            if (r.length <= 3) {
                for (int i = 0; i < r.length; i++) {
                    System.out.println("showLastLodgersRoom " + r.toString());
                }
            } else {
                for (int i = r.length - 3; i < r.length; i++) {
                    System.out.println("showLastLodgersRoom " + r.toString());
                }
            }
        }
    }

    public void addService(Lodger lodger, Service service) {
        if (lodger != null && service != null) {
            managerLodger.addServiceToLodger(lodger, service);
        } else {
            System.out.println("Incorrect input");
        }
    }

    public void sortLodgerService(Lodger lodger) {
        if (lodger == null) {
            System.out.println("Incorrect input");
        } else {
            Service[] sortService = managerLodger.sortLodgesServiceByPrice(lodger, new SortingServiceByPrice());
            for (Service service : sortService) {
                if (service != null) {
                    System.out.println("sorting lodger: " + lodger.getFullName() + ", service by price : " + service.getServiceName() + "(" + +service.getPrice() + ")");
                }
            }
        }
    }

    public void printDetailsOfRoom(Room room) {
        if (room == null) {
            System.out.println("Incorrect input");
        } else {
            System.out.println(" Details room: " + room.toString());
        }
    }
}
