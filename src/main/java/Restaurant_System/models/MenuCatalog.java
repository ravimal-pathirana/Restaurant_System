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

        // Each extra addons are placed here.

        Extra extraCheese = new Extra("Extra Cheese", 150.00);
        Extra mushrooms = new Extra("Mushrooms", 100.00);
        Extra chicken = new Extra("Chicken", 50.00);
        Extra gravy = new Extra("Gravy", 50.00);

        Extra largeSize = new Extra("Large Size", 150.00);
        Extra extraIce = new Extra("Extra Ice", 0.00);
        Extra extraSalt = new Extra("Extra Salt", 0.00);

        // Menu Items are stored here.

        Foods pizza = new Foods("Pizza", "A thin, stone-baked crust topped with sun-ripened tomato sauce, melted mozzarella, and a fragrant touch of fresh basil.",950.00,"/images/ChickenPizza.jpg" ,  false);
        pizza.addAvailableExtra(extraCheese);
        pizza.addAvailableExtra(mushrooms);
        menuItems.add(pizza);

        Foods burger = new Foods("Burger", "A succulent, golden-fried chicken patty nestled in a toasted brioche bun with crisp lettuce and our signature creamy mayo.", 600.00, "/images/ChickenBurger.jpg", true);
        burger.addAvailableExtra(extraCheese);
        menuItems.add(burger);

        Foods kottu = new Foods("Kottu", "A rhythmic symphony of chopped flatbread, stir-fried with fresh vegetables, eggs,chicken and aromatic Sri Lankan spices for the ultimate island comfort.", 750.00, "/images/Kottu.jpg", false);
        kottu.addAvailableExtra(chicken);
        kottu.addAvailableExtra(gravy);
        menuItems.add(kottu);

        Foods frenchFries = new Foods("French Fries", "Hand-cut, double-fried russet potatoes seasoned with a light dusting of sea salt for the ultimate crunch.", 350, "/images/FrenchFries.jpg", false);
        frenchFries.addAvailableExtra(extraSalt);
        menuItems.add(frenchFries);

        Drinks cocaCola = new Drinks("Coca-Cola", "The world’s favorite iconic sparkling cola, served ice-cold for the ultimate crisp and refreshing finish.", 250.00, "/images/CocaCola.jpg", "Regular");
        cocaCola.addAvailableExtra(extraIce);
        menuItems.add(cocaCola);

        Drinks papayaJuice = new Drinks("Papaya Juice", "A vibrant, sun-ripened blend of fresh papaya nectar, chilled to perfection for a smooth and naturally sweet island escape.", 200.00, "/images/PapayaJuice.jpg", "Large");
        menuItems.add(papayaJuice);

        Drinks milkTea = new Drinks("Milk Tea", "A comforting blend of strong-brewed Ceylon tea and creamy milk, sweetened to perfection for that authentic local warmth.", 50.00, "/images/MilkTea.jpg", "Regular");
        menuItems.add(milkTea);

        Drinks iceCoffee = new Drinks("Ice Coffee", "A smooth, bold shot of premium espresso poured over chilled milk and served with plenty of ice for a crisp caffeine kick.", 260.00, "/images/IceCoffee.jpg", "Regular");
        iceCoffee.addAvailableExtra(extraIce);
        menuItems.add(iceCoffee);

        Drinks Milo = new Drinks("Milo", "The classic chocolate-malt favorite that gives you the energy to go further, served ice-cold for that unmistakable \"Great Food, Great Life\" experience", 100.00, "/images/Milo.jpeg", "Regular");
        menuItems.add(Milo);

    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
