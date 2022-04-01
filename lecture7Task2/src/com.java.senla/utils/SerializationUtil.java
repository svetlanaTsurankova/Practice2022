package com.java.senla.utils;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.properti.Settings;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.model.service.impl.ManagerService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SerializationUtil {
    private static final String SAVELOAD_PROPERTY = Settings.getSettings().getProperty("saveload");

    public static void serialize(List<Service> services, List<Room> rooms, List<Lodger> lodgers) {
        List entity = new ArrayList<>();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Objects.requireNonNull(SerializationUtil.class.getClassLoader().getResource(SAVELOAD_PROPERTY)).getFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            entity.add(lodgers);
            entity.add(rooms);
            entity.add(services);
            objectOutputStream.writeObject(entity);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize() {
        try {
            FileInputStream fileInputStream = new FileInputStream(SerializationUtil.class.getClassLoader().getResource(SAVELOAD_PROPERTY).getFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List entities = (List) objectInputStream.readObject();
            ManagerLodger.lodgerManager().setLodgers((List<Lodger>) entities.get(0));
            ManagerRoom.roomManager().setRooms((List<Room>) entities.get(1));
            ManagerService.serviceManager().setServices((List<Service>) entities.get(2));
            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}