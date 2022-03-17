package com.java.senla.entity;

import java.time.LocalDate;

public class Lodger {
    private int idLodger;
    private String fullName;
    private int phoneLodger;
    private LocalDate dateCheckIn;
    private LocalDate dateCheckOut;
    private Room room;
    private Service services;
    private double cost;

    public int getIdLodger() {
        return idLodger;
    }

    public void setIdLodger(int idLodger) {
        this.idLodger = idLodger;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneLodger() {
        return phoneLodger;
    }

    public void setPhoneLodger(int phoneLodger) {
        this.phoneLodger = phoneLodger;
    }

    public LocalDate getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(LocalDate dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public LocalDate getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(LocalDate dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Service getServices() {
        return services;
    }

    public void setServices(Service services) {
        this.services = services;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Lodger(String fullName) {
        this.fullName = fullName;
    }

    public Lodger(int idLodger, String fullName, int phoneLodger, LocalDate dateCheckIn, LocalDate dateCheckOut, Room room,
                  Service services, double cost) {
        this.idLodger = idLodger;
        this.fullName = fullName;
        this.phoneLodger = phoneLodger;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.room = room;
        this.services = services;
        this.cost = cost;
    }
}
