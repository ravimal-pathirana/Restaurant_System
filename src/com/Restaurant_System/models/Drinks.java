package com.Restaurant_System.models;

public class Drinks extends MenuItem {
    private String size;

    public Drinks(String name,String description, double basePrice, String size) {
        super(name, description, basePrice);
        this.size = size;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculateFinalPrice() {
        double finalPrice = getBasePrice();
        if (size.equalsIgnoreCase("Large")){
            finalPrice+= 1.00;
        }
        return finalPrice;
    }
}
