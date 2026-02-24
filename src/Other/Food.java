package Other;

import java.util.ArrayList;

class Food extends MainMenu {
     private final String type;
     private final ArrayList<String> toppings = new ArrayList<String>();

     public Food(String name, double price, String type){
        super(name,price);
        this.type = type;
    }
    public void addTopping(String topping) {    // better name: singular
        if (topping != null && !topping.trim().isEmpty()) {
            toppings.add(topping.trim());
        }
    }

    public ArrayList<String> getTopping(){
         return toppings;
    }
}
