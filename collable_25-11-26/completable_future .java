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




import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        System.out.println("MAIN METHOD");

        // 1. supplyAsync() + join()
        // supplyAsync() executes a task asynchronously.
        // join() waits and gets the result.

        CompletableFuture<Integer> result1 =
            CompletableFuture.supplyAsync(() -> {

                int c = 80;
                int python = 90;

                return c + python;
            });

        System.out.println("SupplyAsync Result: " + result1.join());


        // 2. thenApply() + join()
        // thenApply() takes the previous result,
        // performs an operation and returns a new result.

        CompletableFuture<Integer> result2 =
            CompletableFuture.supplyAsync(() -> 100);

        CompletableFuture<Integer> total =
            result2.thenApply(marks -> marks + 10);

        System.out.println("ThenApply Result: " + total.join());


        // 3. thenAccept() + join()
        // thenAccept() receives the previous result.
        // It does not return any value.

        CompletableFuture<Integer> result3 =
            CompletableFuture.supplyAsync(() -> 150);

        CompletableFuture<Void> accept =
            result3.thenAccept(marks -> {
                System.out.println("ThenAccept Marks: " + marks);
            });

        // join() waits until thenAccept() completes.
        accept.join();


        // 4. thenRun() + join()
        // thenRun() does not receive the previous result.
        // It simply executes the next task.

        CompletableFuture<Integer> result4 =
            CompletableFuture.supplyAsync(() -> 200);

        CompletableFuture<Void> run =
            result4.thenRun(() -> {
                System.out.println("ThenRun: Task completed!");
            });

        // join() waits until thenRun() completes.
        run.join();


        // 5. runAsync() + join()
        // runAsync() executes a task asynchronously.
        // It does not return any result.

        CompletableFuture<Void> result5 =
            CompletableFuture.runAsync(() -> {
                System.out.println("RunAsync: Running task...");
            });

        // join() waits until the task completes.
        result5.join();


        System.out.println("MAIN METHOD COMPLETED");
    }
}
