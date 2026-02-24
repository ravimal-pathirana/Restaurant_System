
import java.util.Scanner;
public class Retaurent {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------------");
        System.out.println("                     WELCOME TO RESTAURANT");
        System.out.println("---------------------------------------------------------------");
        choices();

    }

    static Scanner choice = new Scanner(System.in);
    static void choices() {
        System.out.println("[1] View Menu");
        System.out.println("[2] Customize menu");
        System.out.println("[3] Exit");
        System.out.println("Enter your choice : ");
        int choose = Integer.parseInt(choice.nextLine());

        switch (choose) {
            case 1:
                viewMenu();
                choices();
                break;

            case 2:

                choices();
                break;

            case 3:
                break;
        }
    }

    //handling view menu
    static void viewMenu(){
        Food food = null;
        System.out.println("----MENU----");
        System.out.println("[1]Foods");
        System.out.println("[2]DRINKS");
        System.out.println("Enter your choice : ");
        int choose = Integer.parseInt(choice.nextLine());
        if (choose==1){
            String foodName=" ";
            double basePrice=700;
            String foodType=" ";
            System.out.println("[1]Cheese Pizza");
            System.out.println("[2]Chicken Burger");
            System.out.println("Enter your choice : ");
            int f = Integer.parseInt(choice.nextLine());
            if (f==1){
                foodName="cheese pizza";
                foodType="pizza";
                basePrice+=200;
            } else if (f==2) {
                foodName="chicken burger";
                foodType="Burger";
                basePrice+=300;
            }else {
                System.out.println("In valid choice");
            }
            Food foods=new Food(foodName,basePrice,foodType);

            System.out.println("Do you prefer any toppings?");
            System.out.println("[1]Yes");
            System.out.println("[2]No, i don't");
            System.out.println("Enter your choice : ");
            int t= Integer.parseInt(choice.nextLine());

            if (t==1) {
                System.out.println("Add topping : ");
                String topping = choice.nextLine();
                food.addTopping(topping);

            }else {
                System.out.println("That's fine");
            }

            System.out.println("-----------------------------");
            System.out.println("Selected drink:");
            System.out.println(foods.getName()
                    + " (" + foods.getTopping());


            System.out.println("-----------------------------");




        } else if (choose==2) {
            String drinkName="";
            double basePrice=200;
            String drinkSize="medium";
            System.out.println("[1]Papaya juice");
            System.out.println("[2]Cola-Cola");
            System.out.println("Enter your choice : ");
            int d = Integer.parseInt(choice.nextLine());
            if (d==1) {
                 drinkName="Papaya juice";
            }
            else if (d==2) {
                drinkName="Cola-Cola";
            }
            Drink drink= new Drink(drinkName,basePrice);

            System.out.println("Do you want iced?");
            System.out.println("[1]yes ");
            System.out.println("[2]No ");
            int iced = Integer.parseInt(choice.nextLine());
            if (iced==1){
                  drink.iced();
            }else {
                System.out.println("That's fine");
            }

            System.out.println("Which Size(Large or Medium or Small)?");
            System.out.println("Enter your choice(In letters) : ");
            String s = choice.nextLine();
            double price;
            if (s == "Large") {
                    drink.setSize("large");
            } else if (s == "Medium") {
                drink.setSize("medium");
            }else if (s  == "Small"){
                drink.setSize("small");
            }else {
                drink.setSize("medium");
            }

            System.out.println("-----------------------------");
            System.out.println("Selected drink:");
            System.out.println(drink.getName()
                    + " (" + drink.getSize()
                    + (drink.iced() ? ", Iced" : "")
                    );
            System.out.println("-----------------------------");
        }

    }



}