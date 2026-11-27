import java.util.concurrent.CompletableFuture;

public class fum {
    public static void main(String[] args) {
      
      CompletableFuture<Integer> foodprice = CompletableFuture.supplyAsync(()->{
        System.out.println("call foodd price");

        return 500;
      });
     
     CompletableFuture<Double> finalprice = foodprice.thenApply(price->{
      return price + (price * 5 /100.0);
     });

    CompletableFuture<Void> display = finalprice.thenAccept(ammount->{
    System.out.println("your bill amount is "+ ammount);
    });

    CompletableFuture<Double> delivery = CompletableFuture.supplyAsync(()->{
        System.out.println("del charges are added");

        return 50.0;
    });

//then combine: will combine two completable future and return a new completable future
    CompletableFuture<Double> totalprice = finalprice.thenCombine(delivery,(food,charge)->{
         
         return food + charge;
    });
//then compose: will combine two completable future and return a new completable future
    CompletableFuture<String> result=CompletableFuture.supplyAsync(()->{
        System.out.println("order is placed");
        return "ORDER202";
    }).thenCombine(totalprice,(orderid,price)->{
        return "your order id is "+orderid+" and total price is "+price;
    });
    
    System.out.println(result.join());

    System.out.println(totalprice.join());

    }
}
