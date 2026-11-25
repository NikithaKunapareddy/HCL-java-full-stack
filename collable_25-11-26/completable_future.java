import java.util.concurrent.CompletableFuture;
//differnce between completable future and callable future is that completable future is a new feature in java 8, it is used to run asynchronous tasks, it can be used to run multiple tasks in parallel and combine their results. It can also be used to handle exceptions and timeouts. It is more powerful than callable future.
//in code difference is in future we written Future<Integer> result = executor.submit(task2);//this will submit the task to the executor service, so it will and print the result of the callable task.
//so here in .supplyAsync() method we can write the code to run the task asynchronously and it will return a completable future object which we can use to get the result of the task.
public class completable_future {
    public static void main(String[] args) {
        System.out.println("MAIN method");
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            System.out.println("calculating .......");
        int c=80;
        int python=90;
        return c+python;
        });
        System.out.println("Math is doing other task");
        System.out.println("Result is: " + result.join());
    }
}
