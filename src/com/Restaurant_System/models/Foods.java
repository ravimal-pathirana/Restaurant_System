package com.Restaurant_System.models;

public class Foods extends MenuItem {

    private boolean isSpicy;

    public Foods(String name, String description, double basePrice, boolean isSpicy) {
        super(name, description, basePrice);
        this.isSpicy = isSpicy;
    }
    public boolean isSpicy() {
        return isSpicy;
    }
    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice();
    }
}
