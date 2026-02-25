package Restaurant_System.models;

public abstract class MenuItem {

    private String name;
    private String description;
    private double basePrice;
    private String imagePath;

    public MenuItem(String name, String description, double basePrice, String imagePath) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setbasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public abstract double calculateFinalPrice();

}
