import java.util.Scanner;
public class Restaurant {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------------");
        System.out.println("                     WELCOME TO RESTAURANT");
        System.out.println("---------------------------------------------------------------");
        choices();

    }


    static void choices(){
        Scanner choice = new Scanner(System.in);
        System.out.println("[1] Order item");
        System.out.println("[2] Cart");
        System.out.println("[3] Exit");
        System.out.println("Enter your choice : ");
        int choose = Integer.parseInt(choice.nextLine());

        switch (choose) {
            case 1:
                orderItem();
                break;

            case 2:
//                cart();
                break;

            case 3:
                break;
        }

    }

//Handling the order items
    static void orderItem(){
        Scanner choice = new Scanner(System.in);
        System.out.println("----Order item----");
        System.out.println("[1]Foods");
        System.out.println("[2]Drinks");
        System.out.println("Enter your choice : ");
        int choose = Integer.parseInt(choice.nextLine());

        switch (choose){
            case 1:
                Food.foodItems();
                break;

            case 2:
                Drink.drinkItems();
                break;
        }
    }

    //Handling the cart
    static void cart(){

    }
    
}