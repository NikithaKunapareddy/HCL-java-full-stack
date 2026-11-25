import java.util.concurrent.CompletableFuture;

public class CompletableFutureStages {

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

        // 2. thenApply() transforms the previous result.
        CompletableFuture<Integer> result2 =
            CompletableFuture.supplyAsync(() -> 100);
        CompletableFuture<Integer> total =
            result2.thenApply(marks -> marks + 10);
        System.out.println("ThenApply Result: " + total.join());

        // 3. thenAccept() consumes the previous result.
        CompletableFuture<Integer> result3 =
            CompletableFuture.supplyAsync(() -> 150);
        CompletableFuture<Void> accept =
            result3.thenAccept(marks ->
                System.out.println("ThenAccept Marks: " + marks));
        accept.join();

        // 4. thenRun() runs an action without receiving the previous result.
        CompletableFuture<Integer> result4 =
            CompletableFuture.supplyAsync(() -> 200);
        CompletableFuture<Void> run =
            result4.thenRun(() ->
                System.out.println("ThenRun: Task completed!"));
        run.join();

        // 5. runAsync() runs an asynchronous action without returning a result.
        CompletableFuture<Void> result5 =
            CompletableFuture.runAsync(() ->
                System.out.println("RunAsync: Running task..."));
        result5.join();

        System.out.println("MAIN METHOD COMPLETED");
    }
}
