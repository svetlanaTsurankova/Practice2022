package com.java.senla.entity;

public class Room {
    private int numberRoom;
    private double price;
    private int capacity;
    private String status;
    private int starsRoom;
    private boolean occupiedRoom;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStarsRoom() {
        return starsRoom;
    }

    public void setStarsRoom(int starsRoom) {
        this.starsRoom = starsRoom;
    }

    public boolean getOccupiedRoom() {
        return occupiedRoom;
    }

    public void setOccupiedRoom(boolean occupiedRoom) {
        this.occupiedRoom = occupiedRoom;
    }


    public Room(int numberRoom, double price, int capacity, String status,
                int starsRoom, boolean occupiedRoom) {

        this.numberRoom = numberRoom;
        this.price = price;
        this.capacity = capacity;
        this.status = status;
        this.starsRoom = starsRoom;
        this.occupiedRoom = occupiedRoom;

    }
}
