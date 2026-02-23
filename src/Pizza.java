import java.util.Scanner;

 class Pizza extends MenuItem {
     public Pizza(String name, double price) {
         super(name, price);
     }

    static void pizzaVarities() {
        Scanner choice = new Scanner(System.in);
        System.out.println("------------PIZZA VARITIES-----------");
        System.out.println("[1]Chees pizza    1500/=");
        System.out.println("[2]Beaf pizza     2000/=");
        System.out.println("[3]Chicken pizza  1800/=");

        System.out.println("Enter your choice: ");
        int choose = Integer.parseInt(choice.nextLine());

        System.out.println("quantity: ");
        int quantity = Integer.parseInt(choice.nextLine());

        if(choose==1){
            Pizza pizza=new Pizza("Chees pizza",1500);
        } else if (choose==2) {
            Pizza pizza=new Pizza("Beaf pizza",2000);
        }else if (choose==3){
            Pizza pizza=new Pizza("Chicken pizza",1800);
        }else {
            System.out.println("Wrong choice!");
        }


    }
}
