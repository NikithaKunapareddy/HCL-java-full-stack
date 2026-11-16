import java.util.*;
import java.util.function.*;

// =============================================
// Employee Attendance Management
// Approach 1: Using ANONYMOUS CLASSES
// =============================================

public class AttendanceAnonymous {
    public static void main(String[] args) {

        // List of employee attendance percentages
        List<Integer> attendanceList = new ArrayList<>(Arrays.asList(95, 45, 80, 30, 100));

        // Predicate using Anonymous Class - check if attendance >= 75
        Predicate<Integer> isEligible = new Predicate<Integer>() {
            @Override
            public boolean test(Integer attendance) {
                return attendance >= 75;
            }
        };

        // Consumer using Anonymous Class - print eligible attendance
        Consumer<Integer> printEligible = new Consumer<Integer>() {
            @Override
            public void accept(Integer attendance) {
                System.out.println("Eligible Attendance: " + attendance + "%");
            }
        };

        System.out.println("=== Employee Attendance Management (Anonymous Classes) ===");
        System.out.println("All Attendance: " + attendanceList);
        System.out.println("\nEligible Employees (>= 75%):");

        // forEach with anonymous class
        attendanceList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer attendance) {
                if (isEligible.test(attendance)) {
                    printEligible.accept(attendance);
                }
            }
        });
    }
}
