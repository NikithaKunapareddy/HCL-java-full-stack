
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

// Student class
class StudentData {
    int m1, m2, m3, m4;
    StudentData(int m1, int m2, int m3, int m4) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
    }
}

public class student {
    public static void main(String[] args) throws Exception {
        Runnable task1 = () -> {
            System.out.println("Runnable task..");
        };
        Callable<Double> task2 = () -> {

            System.out.println("Callable task..");
            StudentData s = new StudentData(90, 85, 95, 80);
            int total = s.m1 + s.m2 + s.m3 + s.m4;
            double percentage = (total / 400.0) * 100;
            System.out.println("Total Marks: " + total);
            return percentage;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(task1);
        Future<Double> result = executor.submit(task2);
        System.out.println("Percentage: " + result.get() + "%");
        executor.shutdown();
    }
}
