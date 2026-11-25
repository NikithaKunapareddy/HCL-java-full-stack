import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;//concurrent package is used for multithreading, it has callable and runnable interface.

//runable and callbale its a flow of functional interface, so we can use lambda expression to implement it.

public class main1 {
    public static void main(String[] args) throws Exception {
        Runnable task1 = () -> System.out.println("Runnable task..");

         //here callable we will return value, so type integrer we wrote.
        Callable<Integer> task2 = () -> {

            System.out.println("callable task..");

            return 100 + 200;
        };
         ExecutorService executor = Executors.newSingleThreadExecutor();//this will create a single thread executor, so it will execute the task one by one.

        executor.submit(task1);//this will submit the task to the executor service, so it will and print the result of the runable task.

        Future<Integer> result = executor.submit(task2);//this will submit the task to the executor service, so it will and print the result of the callable task.
        System.out.println(result.isDone());//this will check whether the task is done or not, it will return true if the task is done and false if the task is not done.
        System.out.println(result.get());//this will get the result of the callable task.
        executor.shutdown();

    }
}
