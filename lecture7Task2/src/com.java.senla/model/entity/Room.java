package com.java.senla.model.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private int id;
    private int numberRoom;
    private double price;
    private int capacity;
    private StatusRoomEnum status;
    private int starsRoom;
    private List<Lodger> lodgers = new ArrayList<Lodger>();
    @Serial
    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {

        this.numberRoom = numberRoom;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public StatusRoomEnum getStatus() {
        return status;
    }

    public void setStatus(StatusRoomEnum status) {
        this.status = status;
    }

    public int getStarsRoom() {

        return starsRoom;
    }

    public void setStarsRoom(int starsRoom) {

        this.starsRoom = starsRoom;
    }

    public List<Lodger> getLodgers() {
        return lodgers;
    }

    public void setLodgers(List<Lodger> lodgers) {
        this.lodgers = lodgers;
    }

    public Room() {
    }

    public Room(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public Room(int id, int numberRoom, double price, int capacity, StatusRoomEnum status, int starsRoom) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.price = price;
        this.capacity = capacity;
        this.status = status;
        this.starsRoom = starsRoom;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(id);
        s.append(", ");
        s.append(numberRoom);
        s.append(", ");
        s.append(capacity);
        s.append(", ");
        s.append(starsRoom);
        s.append(", ");
        s.append(price);
        s.append(", ");
        s.append(status);
        if (status == StatusRoomEnum.OCCUPIED) {
        } else if (status == StatusRoomEnum.SERVICED) {
        } else if (status == StatusRoomEnum.RENOVATE) {
        }
        return s.toString();
    }
}
