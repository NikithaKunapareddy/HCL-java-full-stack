// ============================================================
//          FUNCTIONAL INTERFACE - QUESTIONS
//          Date: 16-11-26
// ============================================================


// ------------------------------------------------------------
// Q1. Employee Attendance Management
// ------------------------------------------------------------
// Scenario: A company wants to identify employees who are
//           present and generate attendance reports.
//
// Requirements:
//   - Create a list of employee attendance percentages: 95, 45, 80, 30, 100
//   - Use Predicate to check whether attendance is 75% or above.
//   - Use Consumer to print eligible attendance percentages.
//   - Use forEach() to process the list.
//
// Concepts: List, Generics, Predicate, Consumer, Lambda, forEach
//
// Solve in 3 ways:
//   File 1 -> AttendanceAnonymous.java  (Anonymous Classes)
//   File 2 -> AttendanceLambda.java     (Lambda Expressions)
//   File 3 -> AttendanceFunctional.java (Functional Interfaces + Supplier + Function)


// ------------------------------------------------------------
// Q2. Customer Order System
// ------------------------------------------------------------
// Given:
//   String customerName = "Raghuveer";
//   double price = 9000;
//   int age = 90;
//
// Requirements:
//   - Use Predicate<Integer>  -> check if age >= 18 (eligible)
//   - Use Function<Double,Double> -> apply 10% discount on price
//   - Use Consumer<String>    -> print "Order placed by <name>"
//   - Use Supplier<String>    -> supply a thank-you message
//   - Use Method Reference    -> System.out::println
//   - If eligible, apply discount and confirm order.
//   - Print thank you using Consumer (method reference).
//   - Print thank-you message using Supplier.
//
// Concepts: Predicate, Function, Consumer, Supplier, Method Reference
//
// Solve in:
//   File 4 -> Main.java  (All functional interfaces + Supplier)


// ============================================================
