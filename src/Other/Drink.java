package Other;

class Drink extends MainMenu {
     private String size;
     boolean isIced;
     public Drink(String name, double price){
         super(name,price);

     }
     public void setIced(boolean iced){
         this.isIced=iced;
     }
     public boolean iced(){
         return isIced;
     }

     public void setSize(String s){
         if (size!=null){
             String cleaned = s.trim().toLowerCase();
             if (cleaned=="large"||cleaned=="medium"||cleaned=="small"){
                 this.size=cleaned;
             }
         }
     }
     public String getSize(){
         return size;
     }
}
