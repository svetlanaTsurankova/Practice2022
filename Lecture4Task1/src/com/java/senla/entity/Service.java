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

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Service : ");
        s.append(serviceName);
        s.append(" ");
        s.append(price);
        s.append("  price");
        return s.toString();
    }

    public String getEntityParameters() {
        return String.valueOf(new StringBuilder().
                append(" ").
                append(serviceName).
                append(" ").
                append(price));
    }
}
