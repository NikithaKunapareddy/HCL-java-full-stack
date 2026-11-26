import java.util.concurrent.CompletableFuture;

public class Main {
     public static void main(String[] args) {
      System.out.println("Customer Placed an Order");
     CompletableFuture<Void> result = CompletableFuture.supplyAsync(()-> {
       int price = 2000;
     int delprice = 100;

      System.out.println("Sending the Order Conformation");
     });
      System.out.println("Updating the order");
    System.out.println("generating a invoice");
        System.out.println("Order Process is completed");

}
 }