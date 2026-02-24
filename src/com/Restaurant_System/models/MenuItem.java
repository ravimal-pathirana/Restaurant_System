package com.Restaurant_System.models;

public abstract class MenuItem {

    private String name;
    private String description;
    private double basePrice;

    public MenuItem(String name, String description, double basePrice) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setbasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public abstract double calculateFinalPrice();

}
