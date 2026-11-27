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

//exceptionally: will handle the exception if any exception occurs in the completable future

CompletableFuture<String> payment = CompletableFuture.supplyAsync(()->{
System.out.println("processing payment");
     
     int amount = 1000;
     if(amount>500){
        throw new RuntimeException("payement is declined");
     }  
     return "payment is successful";
    }).exceptionally(error-> {
        System.out.println("payment is failed");
        return "try again";
    });
    System.out.println(payment.join());

//handle: will handle the exception if any exception occurs in the completable future and return a new completable future
    CompletableFuture<String> payment1 = CompletableFuture.supplyAsync(()->{
        System.out.println("processing payment");
             
             int amount = 1000;
             if(amount>500){
                throw new RuntimeException("payement is declined");
             }  
             return "payment is successful";
            }).handle((result,error)-> {
                if(error!=null){
                    System.out.println("payment is failed");
                    return "try again";
                }
                return result;
            });
            System.out.println(payment1.join());

    }
}
