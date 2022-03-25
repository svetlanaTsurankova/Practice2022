package com.java.senla.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private int numberRoom;
    private double price;
    private int capacity;
    private StatusRoomEnum status;
    private int starsRoom;
    private List<Lodger> lodgers = new ArrayList<Lodger>();

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
        s.append("Room #");
        s.append(numberRoom);
        s.append(" can hold up to ");
        s.append(capacity);
        s.append(" lodgers. Rate: ");
        s.append(starsRoom);
        s.append(". price is ");
        s.append(price);
        s.append("  ");
        if (status == StatusRoomEnum.OCCUPIED) {
            s.append("Room is occupied. ");
        } else if (status == StatusRoomEnum.SERVICED) {
            s.append("Room is being serviced.");
        } else if (status == StatusRoomEnum.RENOVATE) {
            s.append("Room is being renovate.");
        }
        return s.toString();
    }

    public String getEntityParameters() {
        return String.valueOf(new StringBuilder().append(id).append(" ").append(numberRoom).append(" ").append(capacity)
                .append(" ").append(starsRoom).append(" ").append(price));
    }
}
