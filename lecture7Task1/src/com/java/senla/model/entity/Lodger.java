package com.java.senla.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lodger {
    private int idLodger;
    private String fullName;
    private LocalDate dateCheckIn;
    private LocalDate dateCheckOut;
    private Room room;
    private List<Service> services = new ArrayList<Service>();


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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Lodger() {
    }

    public Lodger(String fullName) {
        this.fullName = fullName;
    }

    public Lodger(int idLodger, String fullName, LocalDate dateCheckIn, LocalDate dateCheckOut, Room room,
                  List<Service> service) {
        this.idLodger = idLodger;
        this.fullName = fullName;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.room = room;
        this.services = service;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(idLodger);
        s.append(", ");
        s.append(fullName);
        s.append(", ");
        s.append(dateCheckIn);
        s.append(", ");
        s.append(dateCheckOut);
        return s.toString();
    }


}
