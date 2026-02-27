package Restaurant_System.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;
    private List<MenuItem> Items;
    private boolean isReady;

    public Order(int orderId) {
        this.orderId = orderId;
        this.Items = new ArrayList<>();
        this.isReady = false;
    }

    public void addItem(MenuItem item){
        Items.add(item);
    }

    public void removeItem(MenuItem item){
        Items.remove(item);
    }

    public double calculateTotalPrice(){
        double totalPrice = 0.0;

        for(MenuItem item : Items){
            totalPrice += item.calculateFinalPrice();
        }
    return totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return Items;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }



}
