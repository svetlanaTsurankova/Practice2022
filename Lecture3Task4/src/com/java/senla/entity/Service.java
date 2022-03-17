package com.java.senla.entity;

public class Service {
    private String serviceName;
    private double price;

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

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }
}
