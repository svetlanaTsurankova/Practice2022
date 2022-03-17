package com.java.senla;

public class Flower {
    private String name;
    private String color;
    private double price;

    public Flower(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
