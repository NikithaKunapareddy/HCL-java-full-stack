import java.util.*;

class Employee {

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
               ", Department: " + department + ", Salary: " + salary;
    }
}

public class IntermediateOperations {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(1, "Ravi",  "IT",      50000),
            new Employee(2, "Raj",   "HR",      30000),
            new Employee(3, "Kiran", "IT",      70000),
            new Employee(4, "Arjun", "Finance", 45000),
            new Employee(5, "Sai",   "HR",      60000)
        );

        // filter - employees with salary <= 50000
        System.out.println("-- filter (salary <= 50000) --");
        employees.stream()
            .filter(e -> e.salary <= 50000)
            .forEach(System.out::println);

        // map - print names in uppercase
        System.out.println("\n-- map (names to uppercase) --");
        employees.stream()
            .map(e -> e.name.toUpperCase())
            .forEach(System.out::println);

        // sorted - by salary descending
        System.out.println("\n-- sorted (salary high to low) --");
        employees.stream()
            .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
            .forEach(System.out::println);

        // distinct - unique departments
        System.out.println("\n-- distinct (departments) --");
        employees.stream()
            .map(e -> e.department)
            .distinct()
            .forEach(System.out::println);

        // peek - intermediate logging
        System.out.println("\n-- peek --");
        employees.stream()
            .peek(e -> System.out.println("Processing: " + e.name))
            .forEach(System.out::println);

        // limit - first 3 employees
        System.out.println("\n-- limit (first 3) --");
        employees.stream()
            .limit(3)
            .forEach(System.out::println);

        // skip - skip first 2
        System.out.println("\n-- skip (skip first 2) --");
        employees.stream()
            .skip(2)
            .forEach(System.out::println);
    }
}
