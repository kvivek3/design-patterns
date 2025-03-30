What is the Strategy Pattern?

The Strategy pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. It 1  lets the algorithm vary independently from clients that 2  use it. In essence, it allows you to select an algorithm at runtime.

Key Components:

Strategy Interface: Defines the common interface for all supported algorithms.
Concrete Strategies: Implement the specific algorithms.
Context: Maintains a reference to a Strategy object. The Context is not aware of the specific Concrete Strategy being used.
Scenario: Order Processing with Different Shipping Methods

Imagine an e-commerce platform that needs to calculate shipping costs for orders. The platform supports multiple shipping methods:

Standard Shipping: Fixed rate.
Express Shipping: Higher rate, faster delivery.
International Shipping: Complex calculations based on destination and weight.

Naive Approach (Without Strategy Pattern)

Java
```java
class Order {
    private String shippingMethod;
    private double weight;
    private String destination;

    public Order(String shippingMethod, double weight, String destination) {
        this.shippingMethod = shippingMethod;
        this.weight = weight;
        this.destination = destination;
    }

    public double calculateShippingCost() {
        if (shippingMethod.equals("Standard")) {
            return 5.0; // Fixed standard rate
        } else if (shippingMethod.equals("Express")) {
            return 15.0; // Fixed express rate
        } else if (shippingMethod.equals("International")) {
            // Complex international shipping calculation
            if (destination.equals("USA")) {
                return weight * 10.0; // Example calculation
            } else {
                return weight * 12.0; // Example calculation
            }
        } else {
            return 0.0; // Unknown shipping method
        }
    }
}

public class NaiveExample {
public static void main(String[] args) {
Order order1 = new Order("Standard", 1.0, "Anywhere");
System.out.println("Shipping cost: $" + order1.calculateShippingCost());

        Order order2 = new Order("International", 2.0, "USA");
        System.out.println("Shipping cost: $" + order2.calculateShippingCost());
    }
}
```
Problems with the Naive Approach:

Tight Coupling: The Order class is tightly coupled with the shipping logic. If you add or change shipping methods, you need to modify the Order class.
Violation of Open/Closed Principle: The Order class is not open for extension but closed for modification.
Code Duplication: If the shipping logic becomes more complex, you might have duplicate code within the if-else blocks.
Difficult to Test: Testing becomes complex due to the large, monolithic calculateShippingCost() method.