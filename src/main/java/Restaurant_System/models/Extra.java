package Restaurant_System.models;

public class Extra {
    private String name;
    private double price;

    public  Extra(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName(){return name;}
    public double getPrice(){return price;}

    @Override
    public String toString(){
        return name + " (+Rs." + String.format("%.2f",price) + ")";
    }
}
