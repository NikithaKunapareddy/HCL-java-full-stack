import java.util.concurrent.CompletableFuture;
public class EmployeeExample{
    public static void main(string []args){
        CompletableFuture<Integer>employeeid=CompletableFuture.supplyAsync(()->{
            System.out.println("fetching employee id");
            return 100;
        });
        System.out.println("employee id is: "+employeeid.join());
        //thenApply: will transform the result of a completable future when it becomes available
        CompletableFuture<String> employeename=employeeid.thenApply(id->{
            System.out.println("fetching employee name");
            return "nikit";
        }); 
        //thenAccept: will consume the result of a completable future when it becomes available
        CompletableFuture<Void> display=employeename.thenAccept(name->{     
            
            System.out.println("employee name is: "+name);
        });
        //thenRun: will run a task after the completion of a completable future
        CompletableFuture<Void> completed=display.thenRun(()->{
            System.out.println("employee details are fetched");
        });
        //thenCombine: will combine two completable future and return a new completable future
        CompletableFuture<Integer> employeeage=CompletableFuture.supplyAsync(()->{
            System.out.println("fetching employee age");
            return 25;
        });
        //thenCombine: will combine two completable future and return a new completable future
        CompletableFuture<String> employeedetails=employeename.thenCombine(employeeage,(name,age)->{
            return "employee name is: "+name+" and employee age is: "+age;
        }); 
        //thenCompose: will combine two completable future and return a new completable future
        CompletableFuture<String> employeedetails1=employeeid.thenCompose(id->{     
            return CompletableFuture.supplyAsync(()->{
                System.out.println("fetching employee details");
                return "employee id is: "+id+" and employee name is: "+"nikit";
            });
        }); 
        //exceptionally: will handle the exception if any exception occurs in the completable future
        CompletableFuture<String> employeeaddress=CompletableFuture.supplyAsync(()->{   
            System.out.println("fetching employee address");
            int amount=1000;
            if(amount>500){
                throw new RuntimeException("address is not available");
            }
            return "employee address is: "+"pune";
        }).exceptionally(error->{
            System.out.println("address is not available");
            return "try again";
        }); 
        //handle: will handle the exception if any exception occurs in the completable future and return a new completable future
        CompletableFuture<String> employeeaddress1=CompletableFuture.supplyAsync(()->{      
            System.out.println("fetching employee address");
            int amount=1000;
            if(amount>500){
                throw new RuntimeException("address is not available");
            }
            return "employee address is: "+"pune";
        }).handle((result,error)->{
            if(error!=null){
                System.out.println("address is not available");
                return "try again";
            }
            return result;
        });
        
    }
}
