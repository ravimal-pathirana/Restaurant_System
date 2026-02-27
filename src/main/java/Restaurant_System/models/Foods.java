package Restaurant_System.models;

public class Foods extends MenuItem {

    private boolean isSpicy;

    public Foods(String name, String description, double basePrice, String imagePath, boolean isSpicy) {
        super(name, description, basePrice,  imagePath);
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
