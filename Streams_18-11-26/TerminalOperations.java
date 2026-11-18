import java.util.*;
import java.util.stream.*;

class Emp {

    int id;
    String name;
    String department;
    double salary;

    Emp(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
               ", Dept: " + department + ", Salary: " + salary;
    }
}

public class TerminalOperations {
    public static void main(String[] args) {

        List<Emp> employees = Arrays.asList(
            new Emp(1, "Ravi",  "IT",      50000),
            new Emp(2, "Raj",   "HR",      30000),
            new Emp(3, "Kiran", "IT",      70000),
            new Emp(4, "Arjun", "Finance", 45000),
            new Emp(5, "Sai",   "HR",      60000)
        );

        // forEach
        System.out.println("-- forEach --");
        employees.stream()
            .forEach(System.out::println);

        // count
        long count = employees.stream()
            .filter(e -> e.salary > 40000)
            .count();
        System.out.println("\nEmployees with salary > 40000: " + count);

        // min salary
        Emp minSal = employees.stream()
            .min(Comparator.comparingDouble(e -> e.salary))
            .get();
        System.out.println("\nLowest salary: " + minSal);

        // max salary
        Emp maxSal = employees.stream()
            .max(Comparator.comparingDouble(e -> e.salary))
            .get();
        System.out.println("Highest salary: " + maxSal);

        // sum of all salaries using reduce
        double total = employees.stream()
            .mapToDouble(e -> e.salary)
            .sum();
        System.out.println("\nTotal salary: " + total);

        // average salary
        double avg = employees.stream()
            .mapToDouble(e -> e.salary)
            .average()
            .getAsDouble();
        System.out.println("Average salary: " + avg);

        // collect to list (IT dept only)
        List<String> itEmps = employees.stream()
            .filter(e -> e.department.equals("IT"))
            .map(e -> e.name)
            .collect(Collectors.toList());
        System.out.println("\nIT employees: " + itEmps);

        // anyMatch - anyone from HR?
        boolean hasHR = employees.stream()
            .anyMatch(e -> e.department.equals("HR"));
        System.out.println("\nHR department exists: " + hasHR);

        // allMatch - all salary > 20000?
        boolean allAbove = employees.stream()
            .allMatch(e -> e.salary > 20000);
        System.out.println("All salary > 20000: " + allAbove);

        // noneMatch - no salary < 10000?
        boolean noneBelow = employees.stream()
            .noneMatch(e -> e.salary < 10000);
        System.out.println("None below 10000: " + noneBelow);

        // findFirst
        Emp first = employees.stream()
            .filter(e -> e.department.equals("HR"))
            .findFirst()
            .get();
        System.out.println("\nFirst HR employee: " + first);

        // toArray
        Object[] arr = employees.stream()
            .map(e -> e.name)
            .toArray();
        System.out.println("\nAll names as array: " + Arrays.toString(arr));
    }
}
