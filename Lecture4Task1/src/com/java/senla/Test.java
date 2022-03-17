package com.java.senla;

import com.java.senla.service.ManagerHotel;
import com.java.senla.sorters.*;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        // "OCCUPIED" "RENOVATE" "SERVICED"
        ManagerHotel managerHotel = new ManagerHotel();
        InitData initData = new InitData();
// create Lodger , Room , Service
        managerHotel.createRoom(initData.room1);
        managerHotel.createRoom(initData.room2);
        managerHotel.createRoom(initData.room3);
        managerHotel.createRoom(initData.room4);
        managerHotel.createRoom(initData.room5);
        managerHotel.createRoom(initData.room6);
        managerHotel.createRoom(initData.room7);
        managerHotel.createRoom(initData.room8);
        managerHotel.createRoom(initData.room9);
        managerHotel.createRoom(initData.room10);
        System.out.println(" show all rooms  ");
        managerHotel.showAllRooms();
        managerHotel.receiveLodger(initData.lodger1);
        managerHotel.receiveLodger(initData.lodger2);
        managerHotel.receiveLodger(initData.lodger3);
        managerHotel.receiveLodger(initData.lodger4);
        System.out.println(" show all Lodger  ");
        managerHotel.showAllLodger();
        managerHotel.createService(initData.service1);
        managerHotel.createService(initData.service2);
        managerHotel.createService(initData.service3);
        managerHotel.createService(initData.service4);
        managerHotel.createService(initData.service5);
        System.out.println("  show all service  ");
        managerHotel.showAllServices();
//CheckIn lodger
        System.out.println("Check in lodger : ");
        managerHotel.checkIn(initData.lodger1, initData.room10, LocalDate.of(2022, 02, 17), LocalDate.of(2022, 02, 20));
        managerHotel.checkIn(initData.lodger2, initData.room7, LocalDate.of(2022, 02, 12), LocalDate.of(2022, 02, 28));
        managerHotel.checkIn(initData.lodger4, initData.room5, LocalDate.of(2022, 02, 19), LocalDate.of(2022, 02, 21));
        managerHotel.checkIn(initData.lodger3, initData.room2, LocalDate.of(2022, 02, 03), LocalDate.of(2022, 02, 24));
        System.out.println("sorting room by price ");
//Sorting Room, Lodger ,  Service
        managerHotel.sortRoom(new SortingRoomByPrice().getSortingRoomByPrice());
        managerHotel.showAllRooms();
        System.out.println("sorting room by stars ");
        managerHotel.sortRoom(new SortingRoomByStars().getSortingRoomByStars());
        managerHotel.showAllRooms();
        System.out.println("sorting room by capacity ");
        managerHotel.sortRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        managerHotel.showAllRooms();
        System.out.println("sorting free room by price ");
        managerHotel.sortFreeRoom(new SortingRoomByPrice().getSortingRoomByPrice());
        managerHotel.showAllFreeRooms();
        System.out.println("sorting free room by stars ");
        managerHotel.sortFreeRoom(new SortingRoomByStars().getSortingRoomByStars());
        managerHotel.showAllFreeRooms();
        System.out.println("sorting free room by capacity ");
        managerHotel.sortFreeRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        managerHotel.showAllFreeRooms();
        managerHotel.sortLodger(new SortingLodger().getSortingLodger());
        managerHotel.showAllLodger();
        managerHotel.sortLodger(new SortingLodgerDate().getSortingLodgerByDate());
        managerHotel.showAllLodger();
        managerHotel.sortedServiceByPrice();
//change StatusRoom , PriceRoom, PriceService
        managerHotel.changeStatusRoom(initData.room8);
        managerHotel.changePriceRoom(initData.room6, 702.65);
        managerHotel.changePriceService(initData.service5, 12.25);
//Count FreeRoom , Lodgers
        managerHotel.countFreeRooms();
        managerHotel.countLodger();
//Add Service to lodger and Sorting this service
        managerHotel.addService(initData.lodger3, initData.service5);
        managerHotel.addService(initData.lodger3, initData.service4);
        managerHotel.sortLodgerService(initData.lodger3);
// billLodgers
        managerHotel.billRoom(initData.lodger3);
//Free room on date
        System.out.println("Free room on date  " + LocalDate.of(2022, 02, 21));
        managerHotel.showEmptyRoomOnDate(LocalDate.of(2022, 02, 21));
//Checkout Lodger
        managerHotel.checkOut(initData.lodger4, initData.room5);
        managerHotel.checkOut(initData.lodger1, initData.room10);
 //Details room
        managerHotel.printDetailsOfRoom(initData.room10);
 //Show Last 3 lodger in room
        managerHotel.checkIn(initData.lodger1, initData.room10, LocalDate.of(2022, 02, 20), LocalDate.of(2022, 02, 22));
        managerHotel.checkOut(initData.lodger1, initData.room10);
        managerHotel.checkIn(initData.lodger2, initData.room10, LocalDate.of(2022, 02, 23), LocalDate.of(2022, 02, 24));
        managerHotel.checkOut(initData.lodger2, initData.room10);
        managerHotel.checkIn(initData.lodger4, initData.room10, LocalDate.of(2022, 02, 25), LocalDate.of(2022, 02, 26));
        managerHotel.checkOut(initData.lodger4, initData.room10);
        managerHotel.checkIn(initData.lodger3, initData.room10, LocalDate.of(2022, 02, 27), LocalDate.of(2022, 02, 28));
        managerHotel.checkOut(initData.lodger3, initData.room10);
        managerHotel.showLastLodgersRoom(initData.room10);
    }
}
