package Restaurant_System.models;

import java.util.ArrayList;
import java.util.List;

public class MenuCatalog {

    private List<MenuItem> menuItems;

    public MenuCatalog() {
        this.menuItems = new ArrayList<>();
        initializeMenu();
    }
    private void initializeMenu() {

        Extra extraCheese = new Extra("Extra Cheese", 150.00);
        Extra mushrooms = new Extra("Mushrooms", 100.00);
        Extra chicken = new Extra("Chicken", 50.00);
        Extra gravy = new Extra("Gravy", 50.00);

        Extra largeSize = new Extra("Large Size", 150.00);
        Extra extraIce = new Extra("Extra Ice", 0.00);
        Extra extraSalt = new Extra("Extra Soda", 0.00);

        Foods pizza = new Foods("Cheese Pizza", "FOOD DESCRIPTION",950.00,"/images/ChickenPizza.jpg" ,  false);
        pizza.addAvailableExtra(extraCheese);
        pizza.addAvailableExtra(mushrooms);
        menuItems.add(pizza);

        Foods burger = new Foods("Chicken Burger", "FOOD DESCRIPTION", 600.00, "/images/ChickenBurger.jpg", true);
        burger.addAvailableExtra(extraCheese);
        burger.addAvailableExtra(mushrooms);
        menuItems.add(burger);

        Foods kottu = new Foods("Kottu", "FOOD DESCRIPTION", 750.00, "/images/Kottu.jpg", false);
        kottu.addAvailableExtra(chicken);
        kottu.addAvailableExtra(gravy);
        menuItems.add(kottu);

        Foods frenchFries = new Foods("French Fries", "FOOD DESCRIPTION", 350, "/images/FrenchFries.jpg", false);
        frenchFries.addAvailableExtra(extraSalt);
        menuItems.add(frenchFries);

        Drinks cocaCola = new Drinks("Coca-Cola", "DRINK DESCRIPTION", 250.00, "/images/CocaCola.jpg", "Regular");
        menuItems.add(cocaCola);

        Drinks papayaJuice = new Drinks("Papaya Juice", "DRINK DESCRIPTION", 200.00, "/images/PapayaJuice.jpg", "Large");
        menuItems.add(papayaJuice);

        Drinks milkTea = new Drinks("Milk Tea", "DRINK DESCRIPTION", 50.00, "/images/MilkTea.jpg", "Regular");
        menuItems.add(milkTea);

        Drinks iceCoffee = new Drinks("Ice Coffee", "DRINK DESCRIPTION", 60.00, "/images/IceCoffee.jpg", "Regular");
        menuItems.add(iceCoffee);

//        menuItems.add(new Foods("Cheese Pizza", "FOOD DESCRIPTION",950.00,"/images/ChickenPizza.jpg" ,  false));
//        menuItems.add(new Foods("Chicken Burger", "FOOD DESCRIPTION", 600.00, "/images/ChickenBurger.jpg", true));
//        menuItems.add(new Foods("Kottu", "FOOD DESCRIPTION", 750.00, "/images/Kottu.jpg", false));
//        menuItems.add(new Foods("French Fries", "FOOD DESCRIPTION", 350, "/images/FrenchFries.jpg", false));
//
//        menuItems.add(new Drinks("Coca-Cola", "DRINK DESCRIPTION", 250.00, "/images/CocaCola.jpg","Regular"));
//        menuItems.add(new Drinks("Papaya Juice", "DRINK DESCRIPTION", 200.00, "/images/PapayaJuice.jpg","Large"));
//        menuItems.add(new Drinks("Milk Tea", "DRINK DESCRIPTION", 50.00, "/images/MilkTea.jpg","Regular"));
//        menuItems.add(new Drinks("Ice Coffee", "DRINK DESCRIPTION", 60.00, "/images/IceCoffee.jpg","Regular"));

    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
