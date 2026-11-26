import java.util.concurrent.CompletableFuture;

public class future{
    public static void main(String[] args) {
      
      //supplyAsync() method is used to run a task asynchronously and return a CompletableFuture that holds the result of the computation.
      CompletableFuture<Integer> foodprice = CompletableFuture.supplyAsync(()->{
         System.out.println(" calulc.. food price");
         return 490;
      });

//thenApply() method is used to transform the result of a CompletableFuture when it becomes available. It takes a Function as an argument and returns a new CompletableFuture that holds the transformed result.
      CompletableFuture<Double> finalprice = foodprice.thenApply(price->{
        return price + (price * 5 /100.0);
      });

//thenAccept() method is used to consume the result of a CompletableFuture when it becomes available. It takes a Consumer as an argument and returns a new CompletableFuture that completes when the Consumer has finished processing the result.
      CompletableFuture<Void> display =  finalprice.thenAccept(Amount->{
     System.out.print(Amount);
      });

//thenRun() method is used to run a task after the completion of a CompletableFuture. It takes a Runnable as an argument and returns a new CompletableFuture that completes when the Runnable has finished executing.

       CompletableFuture<Void> completed = display.thenRun(() -> {
            System.out.println("Food order completed");
        });

   completed.join();
   
    }
}