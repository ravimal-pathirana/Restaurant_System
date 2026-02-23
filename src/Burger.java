import java.util.Scanner;

 class Burger extends MenuItem {
     public Burger(String name, double price) {
         super(name, price);
     }


    static void burgerVarities() {
        Scanner choice = new Scanner(System.in);
        System.out.println("------------BURGER VERITIES-----------");
        System.out.println("[1] Zinger Burger  1500/=");
        System.out.println("[2] Beaf Burger    2000/=");
        System.out.println("[3] Chicken Burger  900/=");

        System.out.println("Enter your choice: ");
        int choose = Integer.parseInt(choice.nextLine());

        System.out.println("quantity: ");
        int quantity = Integer.parseInt(choice.nextLine());

        if(choose==1){
            Burger burger = new Burger("Zinger Burger",1500);
        } else if (choose==2) {
            Burger burger = new Burger("Beaf Burger",2000);
        }else if (choose==3){
            Burger burger = new Burger("Chicken Burger",900);
        }else {
            System.out.println("Wrong choice!");
        }
    }
}
