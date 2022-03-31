package com.java.senla.model.entity;

public class Service {
    private int id;
    private String serviceName;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Service() {
    }

    public Service(int id, String serviceName, double price) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(id);
        s.append(", ");
        s.append(serviceName);
        s.append(", ");
        s.append(price);
        return s.toString();
    }
}
