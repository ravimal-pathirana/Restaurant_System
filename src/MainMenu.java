import java.util.ArrayList;
public abstract class MainMenu {
    protected String name;
    protected double price;
    protected double total;

    public MainMenu(String name, double price) {
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }


}



