package com.java.senla;

import com.java.senla.entity.Lodger;
import com.java.senla.entity.Room;
import com.java.senla.entity.Service;
import com.java.senla.service.ManagerHotel;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        ManagerHotel managerHotel = new ManagerHotel();

        Room room1 = new Room(1, 105.8, 1, "Renovate", 2, false);
        Room room2 = new Room(2, 205.8, 1, "Serviced", 3, true);
        Room room3 = new Room(3, 305.8, 2, "Renovate", 2, false);
        Room room4 = new Room(4, 405.8, 3, "Serviced", 3, false);
        Room room5 = new Room(5, 505.8, 2, "Serviced", 5, true);
        Room room6 = new Room(6, 105.8, 1, "Renovate", 2, false);
        Room room7 = new Room(7, 205.8, 1, "Serviced", 3, true);
        Room room8 = new Room(8, 305.8, 2, "Renovate", 2, false);
        Room room9 = new Room(9, 405.8, 4, "Serviced", 3, false);
        Room room10 = new Room(10, 505.8, 2, "Serviced", 5, true);
        System.out.println(" create rooms  ");
        managerHotel.createRoom(room10);
        managerHotel.createRoom(room9);
        managerHotel.createRoom(room8);
        managerHotel.createRoom(room7);
        managerHotel.createRoom(room6);
        managerHotel.createRoom(room5);
        managerHotel.createRoom(room4);
        managerHotel.createRoom(room3);
        managerHotel.createRoom(room2);
        managerHotel.createRoom(room1);
        System.out.println(" show  rooms  ");
        managerHotel.showAllRooms();
        System.out.println(" create Lodger  ");
        Lodger lodger1 = new Lodger("Ivanov");
        Lodger lodger2 = new Lodger("Petrov");
        Lodger lodger3 = new Lodger("Sidorov");
        Lodger lodger4 = new Lodger("Dubina");
        managerHotel.receiveLodger(lodger1);
        managerHotel.receiveLodger(lodger2);
        managerHotel.receiveLodger(lodger3);
        managerHotel.receiveLodger(lodger4);
        System.out.println(" show Lodger  ");
        managerHotel.showAllLodger();
        System.out.println(" create service  ");
        Service service1 = new Service("Service1", 5.26);
        Service service2 = new Service("Service2", 6.25);
        Service service3 = new Service("Service3", 7.63);
        Service service4 = new Service("Service4", 3.72);
        Service service5 = new Service("Service5", 5.14);
        managerHotel.createService(service1);
        managerHotel.createService(service2);
        managerHotel.createService(service3);
        managerHotel.createService(service4);
        managerHotel.createService(service5);
        System.out.println("  Show service  ");
        managerHotel.showAllServices();
        System.out.println("  Check in lodger : ");
        managerHotel.checkIn(lodger1, room10, LocalDate.of(2022, 02, 17), LocalDate.of(2022, 02, 20));
        managerHotel.checkIn(lodger2, room7, LocalDate.of(2022, 02, 12), LocalDate.of(2022, 02, 28));
        managerHotel.checkIn(lodger4, room5, LocalDate.of(2022, 02, 19), LocalDate.of(2022, 02, 21));
        managerHotel.checkIn(lodger3, room2, LocalDate.of(2022, 02, 03), LocalDate.of(2022, 02, 24));
        managerHotel.changeStatusRoom(room8);
        managerHotel.changePriceRoom(room10, 702.65);
        managerHotel.changePriceService(service5, 12.25);
        managerHotel.addService(lodger3, service5);
        managerHotel.checkOut(lodger4, room5);
        managerHotel.checkOut(lodger1, room10);
    }
}
