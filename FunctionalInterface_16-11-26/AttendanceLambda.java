import java.util.*;
import java.util.function.*;

// =============================================
// Employee Attendance Management
// Approach 2: Using LAMBDA EXPRESSIONS
// =============================================

public class AttendanceLambda {
    public static void main(String[] args) {

        // List of employee attendance percentages
        List<Integer> attendanceList = new ArrayList<>(Arrays.asList(95, 45, 80, 30, 100));

        // Predicate using Lambda - check if attendance >= 75
        Predicate<Integer> isEligible = attendance -> attendance >= 75;

        // Consumer using Lambda - print eligible attendance
        Consumer<Integer> printEligible = attendance ->
                System.out.println("Eligible Attendance: " + attendance + "%");

        System.out.println("=== Employee Attendance Management (Lambda Expressions) ===");
        System.out.println("All Attendance: " + attendanceList);
        System.out.println("\nEligible Employees (>= 75%):");

        // forEach with lambda
        attendanceList.forEach(attendance -> {
            if (isEligible.test(attendance)) {
                printEligible.accept(attendance);
            }
        });
    }
}
