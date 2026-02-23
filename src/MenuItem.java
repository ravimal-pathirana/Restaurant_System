public abstract class MenuItem {
    protected String name;
    protected double price;
//    protected int quantity;


    public MenuItem(String name, double price) {
        this.name=name;
        this.price=price;
//        this.quantity=quantity;
    }
//    public int getQuantity(){
//        return quantity;
//    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }


}


