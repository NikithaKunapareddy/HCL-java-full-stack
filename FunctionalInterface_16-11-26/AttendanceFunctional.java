import java.util.*;
import java.util.function.*;

// =============================================
// Employee Attendance Management
// Approach 3: Using FUNCTIONAL INTERFACES
//             (Predicate, Consumer, Supplier, Function, forEach)
// =============================================

// Custom Functional Interface for attendance report
@FunctionalInterface
interface AttendanceReport {
    void generate(List<Integer> list, Predicate<Integer> filter, Consumer<Integer> printer);
}

public class AttendanceFunctional {
    public static void main(String[] args) {

        // Supplier - supplies the list of attendance percentages
        Supplier<List<Integer>> attendanceSupplier = () ->
                new ArrayList<>(Arrays.asList(95, 45, 80, 30, 100));

        List<Integer> attendanceList = attendanceSupplier.get();

        // Predicate - checks if attendance >= 75
        Predicate<Integer> isEligible = attendance -> attendance >= 75;

        // Consumer - prints eligible attendance
        Consumer<Integer> printEligible = attendance ->
                System.out.println("Eligible Attendance: " + attendance + "%");

        // Function - returns a label for attendance status
        Function<Integer, String> statusLabel = attendance ->
                attendance >= 75 ? "PRESENT (Eligible)" : "ABSENT (Not Eligible)";

        // Custom Functional Interface implementation using Lambda
        AttendanceReport report = (list, filter, printer) -> {
            System.out.println("\nDetailed Attendance Report:");
            list.forEach(a -> System.out.println("  " + a + "% -> " + statusLabel.apply(a)));
            System.out.println("\nEligible Employees (>= 75%):");
            list.forEach(a -> {
                if (filter.test(a)) printer.accept(a);
            });
        };

        System.out.println("=== Employee Attendance Management (Functional Interfaces) ===");
        System.out.println("All Attendance: " + attendanceList);

        // Generate report using custom functional interface
        report.generate(attendanceList, isEligible, printEligible);
    }
}
