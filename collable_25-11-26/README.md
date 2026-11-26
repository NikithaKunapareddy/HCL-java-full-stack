# Callable and CompletableFuture examples

These examples require Java 8 or later. From this folder, compile them with:

```powershell
javac main.java main1.java student.java completable_future.java CompletableFutureStages.java
```

Run an example with `java` and its class name:

```powershell
java main
java main1
java student
java completable_future
java CompletableFutureStages
```

- `main` demonstrates `Runnable`, `Callable`, and `ExecutorService`.
- `main1` demonstrates cancelling a submitted `Callable`.
- `student` calculates a percentage in a `Callable`.
- `completable_future` demonstrates `supplyAsync()` and `join()`.
- `CompletableFutureStages` demonstrates `thenApply()`, `thenAccept()`, `thenRun()`, and `runAsync()`.
