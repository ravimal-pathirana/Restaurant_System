import java.util.Scanner;

class Drink extends MenuItem{
    public Drink(String name, double price) {
        super(name, price);
    }
    static void drinkItems(){
            Scanner choice = new Scanner(System.in);
            String drinkSize;
            System.out.println("------------DRINK ITEMS-----------");
            System.out.println("[1] Coca-Cola  150/=");
            System.out.println("[2] Mojito     200/=");
            System.out.println("Enter your choice: ");
            int choose = Integer.parseInt(choice.nextLine());

        if(choose==1){
            Drink drink = new Drink("Coca-Cola",150);
        } else if (choose==2) {
            Drink drink = new Drink("Mojito",200);
        }else {
            System.out.println("Wrong choice!");
        }

            if (choose<3){
                System.out.println("------------DRINK SIZE-----------");
                System.out.println("1)Small");
                System.out.println("2)Medium");
                System.out.println("3)Large");
                System.out.println("Enter your choice: ");
                int size = Integer.parseInt(choice.nextLine());

                if (size==1){
                    drinkSize="Small";
                } else if (size==2) {
                    drinkSize="Medium";
                } else if (size==3) {
                    drinkSize="Large";
                }else {
                    return;
                }


            }else {
                System.out.println("Enter a valid choice !");
                return;
            }

        }

    }

