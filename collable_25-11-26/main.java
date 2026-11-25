
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;//concurrent package is used for multithreading, it has callable and runnable interface.

//runable and callbale its a flow of functional interface, so we can use lambda expression to implement it.

public class main {
    public static void main(String[] args) throws Exception {

        //here in runnabale its just write print statemet, its doesnot return any value, so we can use runnable interface.
        Runnable task1 = () -> {
            System.out.println("runable task..");
        };

        //here callable we will return value, so type integrer we wrote.
        Callable<Integer> task2 = () -> {

            System.out.println("callable task..");

            return 100 + 200;
        };

        //when we use callable and runable we cant exeute it directly, so we need to use executor service to execute the thread.
        //then callbale and runanle are just the worked threads

        //for multithreading we can use thread class, so we can create thread object and pass the runnable object to it.so we use exceutaor service to execute the thread.
        ExecutorService executor = Executors.newSingleThreadExecutor();//this will create a single thread executor, so it will execute the task one by one.

        executor.submit(task1);//this will submit the task to the executor service, so it will and print the result of the runable task.

        Future<Integer> result = executor.submit(task2);//this will submit the task to the executor service, so it will and print the result of the callable task.

        System.out.println(result.get());//this will get the result of the callable task.

        executor.shutdown();//this will shutdown the executor service, so it will not accept any new tasks.it is written due to withiut this in output it will print exceuted timed out exception because the executor service will not accept any new tasks after shutdown is called.
    }
}
