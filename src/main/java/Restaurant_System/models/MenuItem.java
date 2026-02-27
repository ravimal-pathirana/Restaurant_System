package Restaurant_System.models;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuItem {

    private String name;
    private String description;
    private double basePrice;
    private String imagePath;

    private List<Extra> availableExtras;
    private List<Extra> selectedExtras;

    public MenuItem(String name, String description, double basePrice, String imagePath) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.imagePath = imagePath;

        this.availableExtras = new ArrayList<>();
        this.selectedExtras = new ArrayList<>();
    }

    public void addAvailableExtra(Extra extra) {
        this.availableExtras.add(extra);
    }

    // This is the method the Controller needs to call
    public void addSelectedExtra(Extra extra) {
        this.selectedExtras.add(extra);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getBasePrice() { return basePrice; }
    public void setbasePrice(double basePrice) { this.basePrice = basePrice; }

    public String getImagePath() { return imagePath; }

    public List<Extra> getAvailableExtras() { return availableExtras; }
    public List<Extra> getSelectedExtras() { return selectedExtras; }

    public abstract double calculateFinalPrice();

    // --- ERROR FIXED HERE ---
    // Calculates Base Price + Cost of all selected Extras
    public double getTotalPrice() {
        double total = basePrice;
        for (Extra extra : selectedExtras) {
            total += extra.getPrice();
        }
        return total;
    }
}