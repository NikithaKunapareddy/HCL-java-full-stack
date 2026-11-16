import java.util.*;
import java.util.function.*;

// =============================================
// Customer Order System
// Using: Predicate, Function, Consumer, Supplier
// =============================================

public class Main {
    public static void main(String[] args) {

        String customerName = "Nikitha";
        double price = 9000;
        int age = 90;

        // Predicate - checks if customer age is eligible (>= 18)
        Predicate<Integer> eligible = a -> a >= 18;

        // Function - applies 10% discount on price
        Function<Double, Double> discount = p -> p - (p * 0.10);

        // Consumer - confirms order placed by customer name
        Consumer<String> confirm = name -> System.out.println("Order placed by: " + name);

        // Supplier - supplies a default thank-you message
        Supplier<String> thankYouMsg = () -> "Thank you for shopping with us, " + customerName + "!";

        System.out.println("=== Customer Order System ===");

        if (eligible.test(age)) {
            double finalPrice = discount.apply(price);
            System.out.println("Original Price : ₹" + price);
            System.out.println("Final Price (10% off): ₹" + finalPrice);
            confirm.accept(customerName);
        } else {
            System.out.println("Customer is not eligible to place an order.");
        }

        // Consumer using method reference - prints a string
        Consumer<String> print = System.out::println;
        print.accept("Thank you");

        // Supplier - get and print the thank-you message
        String msg = thankYouMsg.get();
        print.accept(msg);
    }
}
