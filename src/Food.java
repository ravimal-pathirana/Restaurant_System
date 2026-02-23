import java.util.Scanner;

class Food   {
    static void foodItems(){
        Scanner choice = new Scanner(System.in);
        System.out.println("------------FOOD ITEMS-----------");
        System.out.println("[1]Pizza");
        System.out.println("[2]Burger");
        System.out.println("Enter your choice: ");
        int choose = Integer.parseInt(choice.nextLine());

        switch (choose){
            case 1:
                Pizza.pizzaVarities();
                break;

            case 2:
                Burger.burgerVarities();
                break;
        }
    }

}
