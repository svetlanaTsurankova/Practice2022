package com.java.senla.model.service;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.entity.StatusRoomEnum;
import com.java.senla.model.properti.Settings;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.model.service.impl.ManagerService;
import com.java.senla.model.sorters.SortingServiceByPrice;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

public class ManagerHotel {
    private static ManagerHotel hotelManager;
    public ManagerRoom managerRoom = new ManagerRoom();
    public ManagerService managerService = new ManagerService();
    public ManagerLodger managerLodger = new ManagerLodger();

    public static ManagerHotel managerHotel() {
        if (hotelManager == null) {
            hotelManager = new ManagerHotel();
        }
        return hotelManager;
    }

    public void showAllRooms() {
        List<Room> rooms = managerRoom.getRooms();
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    public void showAllFreeRooms() {
        List<Room> freeRooms = managerRoom.getFreeRooms();
        for (Room room : freeRooms) {
            System.out.println(room.toString());
        }
    }

    public void showAllServices() {
        List<Service> services = managerService.getServices();
        for (Service service : services) {
            System.out.println(service.toString());
        }
    }

    public void showAllLodger() {
        List<Lodger> lodgers = managerLodger.getLodgers();
        for (Lodger lodger : lodgers) {
            System.out.println(lodger.toString());
        }
    }

    public void createRoom(Room room) {
        try {
            managerRoom.addRoom(room);
        } catch (Exception e) {
            System.err.println("Failed to add a Room. Input valid parameters!");
        }
    }


    public void createService(Service service) {
        try {
            managerService.addService(service);
        } catch (Exception e) {
            System.err.println("Failed to add a Service. Input valid parameters!");
        }
    }

    public void receiveLodger(Lodger lodger) {
        try {
            managerLodger.addLodger(lodger);
        } catch (Exception e) {
            System.err.println("Failed to add a Lodger. Input valid parameters!");
        }
    }

    public void checkIn(Lodger lodger, Room room, LocalDate dateIn, LocalDate dateOut) {
        try {
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
        }catch (Exception e) {
            System.err.println("Failed input parameters.Try again!");
        }
    }

    public void checkOut(Lodger lodger, Room room) {
      try {
            if (room.getStatus().equals(StatusRoomEnum.SERVICED)) {
                System.out.println(" The Room# " + room.getNumberRoom() + "   has no lodgers ");
            } else if (room.getStatus().equals(StatusRoomEnum.OCCUPIED)) {
                room.setStatus(StatusRoomEnum.SERVICED);
                System.out.println(lodger.getFullName() + " has checked-out from Room #" + room.getNumberRoom());
            } else {
                System.out.println("Renovate Room #" + room.getNumberRoom());
            }
        }catch (Exception e) {
            System.err.println("Failed input Id Lodger or Id Room!");
        }
    }

    public void changePriceRoom(Room room, double price) {
        try {
            room.setPrice(price);
        } catch (Exception e) {
            System.err.println("Failed input Id Room or price room!");
        }
    }

    public void changeStatusRoom(Room room) {
        try {
            boolean isStatusRoom = Boolean.parseBoolean(Settings.getSettings().getProperty("status"));
            if (isStatusRoom){
            if (room.getStatus().equals(StatusRoomEnum.RENOVATE)) {
                room.setStatus(StatusRoomEnum.SERVICED);
                System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
            } else if (room.getStatus().equals(StatusRoomEnum.SERVICED)) {
                room.setStatus(StatusRoomEnum.RENOVATE);
                System.out.println("Room number  " + room.getNumberRoom() + "  status change :  " + room.getStatus());
            }}else{
                System.out.println("Status room unavailable");
            }

        } catch (Exception e) {
            System.err.println("Failed input Id Room!");
        }
    }

    public void changePriceService(Service service, double price) {
        try {
            service.setPrice(price);
            System.out.println("Change price service " + service.getServiceName() + "  new price :  " + service.getPrice());
        } catch (Exception e) {
            System.err.println("Failed input Id Service or price !");
        }

    }

    public void sortRoom(Comparator<Room> roomComparator) {
        managerRoom.getRooms().sort(roomComparator);
    }

    public void sortFreeRoom(Comparator<Room> roomFreeComparator) {
        managerRoom.getFreeRooms().sort(roomFreeComparator);
    }

    public void sortLodger(Comparator<Lodger> lodgerComparator) {
        managerLodger.getLodgers().sort(lodgerComparator);
    }

    public void countFreeRooms() {
        System.out.println(" Count free room  " + managerRoom.getCountFreeRooms());
    }

    public void countLodger() {
        System.out.println(" Count lodger " + managerLodger.getLodgers().size());
    }

    public void sortedServiceByPrice() {
        List<Service> sortService = managerService.sortService(new SortingServiceByPrice());
        for (Service service : sortService) {
            System.out.println("sorting service by price : " + service.toString());
        }
    }

    public void showEmptyRoomOnDate(LocalDate date) {
        try {
            List<Room> room = managerRoom.getRooms();
            for (int i = 0; i < room.size(); i++) {
                Room r = room.get(i);
                if (r != null && r.getStatus().equals(StatusRoomEnum.OCCUPIED)) {
                    for (int k = 0; k < r.getLodgers().size(); k++) {
                        if (date.isBefore(r.getLodgers().get(k).getDateCheckIn()) || date.isAfter(r.getLodgers().get(k).getDateCheckOut())) {
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
        } catch (Exception e) {
            System.err.println("Failed input LocalDate!");
        }
    }

    public void billRoom(Lodger lodger) {
        try {
            if (lodger.getDateCheckIn() != null && lodger.getDateCheckOut() != null) {
                Period period = Period.between(lodger.getDateCheckIn(), lodger.getDateCheckOut());
                double bill = lodger.getRoom().getPrice() * period.getDays();
                System.out.println(lodger.getFullName() + " need pay " + bill);
            } else {
                System.out.println(lodger.getFullName() + "not lodger ");
            }
        } catch (Exception e) {
            System.err.println("Failed input Id Lodger!");
        }
    }

    public void showLastLodgersRoom(Room room) {
        try {
            int propertyCount = Integer.parseInt(Settings.getSettings().getProperty("count"));
            List<Lodger> r = room.getLodgers();
            if (r.size() <= propertyCount) {
                for (int i = 0; i < r.size(); i++) {
                    System.out.println("showLastLodgersRoom " + r.toString());
                }
            } else {
                for (int i = r.size() - propertyCount; i < r.size(); i++) {
                    System.out.println("showLastLodgersRoom " + r.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("Failed input Id Room!");
        }
    }

    public void addService(Lodger lodger, Service service) {
        try {
            managerLodger.addServiceToLodger(lodger, service);
        } catch (Exception e) {
            System.err.println("Failed input Id Lodger or failed input Id Service!");
        }
    }

    public void sortLodgerService(Lodger lodger) {
        try {
            List<Service> sortService = managerLodger.sortLodgesServiceByPrice(lodger, new SortingServiceByPrice());
            for (Service service : sortService) {
                if (service != null) {
                    System.out.println("sorting lodger: " + lodger.getFullName() + ", service by price : " + service.getServiceName() + "(" +
                            service.getPrice() + ")");
                }
            }
        } catch (Exception e) {
            System.err.println("Failed input Id Lodger!");
        }
    }

    public void printDetailsOfRoom(int roomid) {
        try {
            System.out.println(" Details room: " + managerRoom.getRoomById(roomid).toString());
        } catch (Exception e) {
            System.err.println("Failed input Id Room!");
        }
    }

    public void importServiceCsvFile(String file) {
        try {
            managerService.importServiceByCsv(file);
        } catch (Exception e) {
            System.err.println("Failed import Service file!");
        }
    }

    public void importRoomCsvFile(String file) {
        try {
            managerRoom.importRoomByCsv(file);
        } catch (Exception e) {
            System.err.println("Failed import Room file!");
        }
    }

    public void importLodgerCsvFile(String file) {
        try {
            managerLodger.importLodgerCsv(file);
        } catch (Exception e) {
            System.err.println("Failed import Lodger file!");
        }
    }

    public void exportServiceCsvFile(String file) {
        try {
            managerService.exportServiceCsvFile(file);
        } catch (Exception e) {
            System.err.println("Failed export Service file!");
        }
    }

    public void exportLodgerCsvFile(String file) {
        try {
            managerLodger.exportLodgerCsvFile(file);
        } catch (Exception e) {
            System.err.println("Failed export Lodger file!");
        }
    }

    public void exportRoomCsvFile(String file) {
        try {
            managerRoom.exportRoomCsvFile(file);
        } catch (Exception e) {
            System.err.println("Failed export Room file!");
        }
    }

}
