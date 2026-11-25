import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;//concurrent package is used for multithreading, it has callable and runnable interface.

//runable and callbale its a flow of functional interface, so we can use lambda expression to implement it.

public class main1 {
    public static void main(String[] args) throws Exception {

         //here callable we will return value, so type integrer we wrote.
        Callable<Integer> task2 = () -> {

            System.out.println("callable task..");

            return 100 + 200;
        };
         ExecutorService executor = Executors.newSingleThreadExecutor();//this will create a single thread executor, so it will execute the task one by one.

        Future<Integer> result = executor.submit(task2);//this will submit the task to the executor service, so it will and print the result of the callable task.
        boolean cancelled=result.cancel(true);//this will cancel the task if it is not done yet, it will return true if the task is cancelled and false if the task is already done.
        System.out.println(cancelled);
        System.out.println("cancel status: " + result.isCancelled());//this will check whether the task is cancelled or not, it will return true if the task is cancelled and false if the task is not cancelled.


        System.out.println(result.isDone());//this will check whether the task is done or not, it will return true if the task is done and false if the task is not done.
        if (!cancelled) {
            System.out.println(result.get());//this will get the result of the callable task.
        }
        executor.shutdown();

    }
}
