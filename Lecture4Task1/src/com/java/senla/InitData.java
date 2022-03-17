package com.java.senla;

import com.java.senla.entity.Lodger;
import com.java.senla.entity.Room;
import com.java.senla.entity.Service;

public class InitData {
    Room room1 = new Room(1,101, 105.8, 1, "RENOVATE", 2);
    Room room2 = new Room(2,102, 205.8, 1, "SERVICED", 3);
    Room room3 = new Room(3,103, 305.8, 2, "RENOVATE", 2);
    Room room4 = new Room(4,104, 405.8, 3, "SERVICED", 3);
    Room room5 = new Room(5,105, 505.8, 2, "SERVICED", 5);
    Room room6 = new Room(6,106, 105.8, 1, "RENOVATE", 2);
    Room room7 = new Room(7,107, 205.8, 1, "SERVICED", 3);
    Room room8 = new Room(8,108, 305.8, 2, "RENOVATE", 2);
    Room room9 = new Room(9,109, 405.8, 4, "SERVICED", 3);
    Room room10 = new Room(10,100, 505.8, 2, "SERVICED", 5);
    Lodger lodger1 = new Lodger("Ivanov");
    Lodger lodger2 = new Lodger("Petrov");
    Lodger lodger3 = new Lodger("Sidorov");
    Lodger lodger4 = new Lodger("Dubina");
    Service service1 = new Service("cleaning", 5.26);
    Service service2 = new Service("wi-fi in the room", 6.25);
    Service service3 = new Service("food in the room", 7.63);
    Service service4 = new Service("car rental", 9.72);
    Service service5 = new Service("gym", 5.14);

}
