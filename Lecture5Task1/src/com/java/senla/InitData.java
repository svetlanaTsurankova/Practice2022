package com.java.senla;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.entity.StatusRoomEnum;

public class InitData {

    Room room1  = new Room(1, 100, 105.8, 1, StatusRoomEnum.RENOVATE, 2,null);
    Room room2  = new Room(2, 102, 205.8, 1, StatusRoomEnum.OCCUPIED, 3,new Lodger[2]);
    Room room3 = new Room(3, 103, 305.8, 2, StatusRoomEnum.RENOVATE, 2,null);
    Room room4  = new Room(4, 104, 405.8, 3, StatusRoomEnum.SERVICED, 3,null);
    Room room5  = new Room(5, 105, 505.8, 2, StatusRoomEnum.OCCUPIED, 5,new Lodger[1]);
    Room room6  = new Room(6, 106, 105.8, 1, StatusRoomEnum.RENOVATE, 2,null);
    Room room7  = new Room(7, 107, 205.8, 1, StatusRoomEnum.OCCUPIED, 3,new Lodger[3]);
    Room room8  = new Room(8, 108, 305.8, 2, StatusRoomEnum.RENOVATE, 2,null);
    Room room9  = new Room(9, 109, 405.8, 4, StatusRoomEnum.SERVICED, 3,null);
    Room room10  = new Room(10, 110, 505.8, 2, StatusRoomEnum.OCCUPIED, 5,new Lodger[0]);

    Lodger lodger1 = new Lodger("Ivanov");
    Lodger lodger2 = new Lodger("Petrov");
    Lodger lodger3 = new Lodger("Sidorov");
    Lodger lodger4 = new Lodger("Dubina");

    Service service1 = new Service(1, "cleaning", 5.26);
    Service service2 = new Service(2, "wi-fi in the room", 6.25);
    Service service3 = new Service(3, "food in the room", 7.63);
    Service service4 = new Service(4, "car rental", 9.72);
    Service service5 = new Service(5, "gym", 5.14);

}
