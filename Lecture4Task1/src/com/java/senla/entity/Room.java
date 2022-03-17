package com.java.senla.entity;

public class Room {
    private int id;
    private int numberRoom;
    private double price;
    private int capacity;
    private String status;
    private int starsRoom;
    private Lodger[] lodgers= new Lodger[4];

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

    public Lodger[] getLodgers() {
        return lodgers;
    }

    public void setLodgers(Lodger[] lodgers) {
        this.lodgers = lodgers;
    }

    public Room(int id,int numberRoom, double price, int capacity, String status,
                int starsRoom) {
        this.id=id;
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
        s.append(" can hold up to (capacity) : ");
        s.append(capacity);
        s.append(" lodgers. Stars: ");
        s.append(starsRoom);
        s.append(". price is ");
        s.append(price);
        s.append("  ");
        if (status.equals("OCCUPIED")) {
            s.append("Room is occupied. ");
        } else if (status.equals("SERVICED")) {
            s.append("Room is being serviced.");
        } else if (status.equals("RENOVATE")) {
            s.append("Room is being renovate.");
        }
        return s.toString();
    }

    public String getEntityParameters() {
        return String.valueOf(id + " " + numberRoom + " " + capacity +
                " " + starsRoom + " " + price);
    }
}
