package com.Restaurant_System.models;

import java.util.ArrayList;
import java.util.List;

public class MenuCatalog {

    private List<MenuItem> menuItems;

    public MenuCatalog() {
        this.menuItems = new ArrayList<>();
        initializeMenu();
    }
    private void initializeMenu() {

        menuItems.add(new Foods("Cheese Pizza", "FOOD DESCRIPTION",950.00, false));
        menuItems.add(new Foods("Chicken Burger", "FOOD DESCRIPTION", 600.00, true));
        menuItems.add(new Foods("Kottu", "FOOD DESCRIPTION", 750.00, false));
        menuItems.add(new Foods("French Fries", "FOOD DESCRIPTION", 350, false));

        menuItems.add(new Drinks("Coca-Cola", "DRINK DESCRIPTION", 250.00, "Regular"));
        menuItems.add(new Drinks("Papaya Juice", "DRINK DESCRIPTION", 200.00, "Large"));
        menuItems.add(new Drinks("Milk Tea", "DRINK DESCRIPTION", 50.00, "Regular"));
        menuItems.add(new Drinks("Ice Coffee", "DRINK DESCRIPTION", 60.00, "Regular"));

    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
