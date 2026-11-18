import java.util.*;
import java.util.stream.*;

class Order {

    int orderId;
    String customerName;
    String product;
    String category;
    double amount;
    String status;
    String city;

    Order(int orderId, String customerName, String product,
          String category, double amount, String status, String city) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.city = city;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + " | " + customerName +
               " | " + product + " | " + category +
               " | Rs." + amount + " | " + status + " | " + city;
    }
}

public class ECommerceOrders {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order(101, "Ravi",   "Laptop",  "Electronics", 55000, "Delivered", "Hyderabad"),
            new Order(102, "Raj",    "Shirt",   "Clothing",     1500, "Pending",   "Chennai"),
            new Order(103, "Kiran",  "Phone",   "Electronics", 25000, "Delivered", "Bangalore"),
            new Order(104, "Arjun",  "Shoes",   "Clothing",     3000, "Cancelled", "Hyderabad"),
            new Order(105, "Sai",    "Fridge",  "Appliances",  40000, "Delivered", "Mumbai"),
            new Order(106, "Meena",  "Watch",   "Electronics",  8000, "Pending",   "Chennai"),
            new Order(107, "Priya",  "Jeans",   "Clothing",     2500, "Delivered", "Bangalore"),
            new Order(108, "Vikram", "Washing Machine", "Appliances", 32000, "Delivered", "Mumbai")
        );

        // filter orders with amount > 10000
        System.out.println("-- Orders above Rs.10000 --");
        orders.stream()
            .filter(o -> o.amount > 10000)
            .forEach(System.out::println);

        // filter by status = Delivered
        System.out.println("\n-- Delivered Orders --");
        orders.stream()
            .filter(o -> o.status.equals("Delivered"))
            .forEach(System.out::println);

        // sort by amount ascending
        System.out.println("\n-- Sorted by Amount (low to high) --");
        orders.stream()
            .sorted(Comparator.comparingDouble(o -> o.amount))
            .forEach(System.out::println);

        // highest order amount
        Order highest = orders.stream()
            .max(Comparator.comparingDouble(o -> o.amount))
            .get();
        System.out.println("\nHighest order: " + highest);

        // lowest order amount
        Order lowest = orders.stream()
            .min(Comparator.comparingDouble(o -> o.amount))
            .get();
        System.out.println("Lowest order: " + lowest);

        // total sales (only Delivered)
        double totalSales = orders.stream()
            .filter(o -> o.status.equals("Delivered"))
            .mapToDouble(o -> o.amount)
            .sum();
        System.out.println("\nTotal Sales (Delivered): Rs." + totalSales);

        // count of orders
        long totalOrders = orders.stream().count();
        System.out.println("Total Orders: " + totalOrders);

        // average order amount
        double avg = orders.stream()
            .mapToDouble(o -> o.amount)
            .average()
            .getAsDouble();
        System.out.println("Average Order Amount: Rs." + avg);

        // group by category
        System.out.println("\n-- Orders Grouped by Category --");
        Map<String, List<Order>> byCategory = orders.stream()
            .collect(Collectors.groupingBy(o -> o.category));
        byCategory.forEach((cat, list) -> {
            System.out.println(cat + ":");
            list.forEach(o -> System.out.println("  " + o));
        });

        // group by city
        System.out.println("\n-- Orders Grouped by City --");
        Map<String, List<Order>> byCity = orders.stream()
            .collect(Collectors.groupingBy(o -> o.city));
        byCity.forEach((city, list) -> {
            System.out.println(city + ":");
            list.forEach(o -> System.out.println("  " + o));
        });
    }
}
