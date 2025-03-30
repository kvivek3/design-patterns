package com.designpattern.behavioural.strategy;


interface ShippingStrategy {
    double calculateCost(double weight, String destination);
}
class StandardShipping implements  ShippingStrategy {

    @Override
    public double calculateCost(double weight, String destination) {
        return 5.0;
    }
}

class ExpressShipping implements ShippingStrategy {

    @Override
    public double calculateCost(double weight, String destination) {
        return 15.0;
    }
}

class InternationShipping implements ShippingStrategy {

    @Override
    public double calculateCost(double weight, String destination) {
        if(destination.equals("USA"))
                return 10.0 * weight;
        else
                return  12.9 * weight;
    }
}
class Order {
    private ShippingStrategy shippingStrategy;
    private double weight;
    private String destination;

    public Order(String destination, double weight, ShippingStrategy shippingStrategy) {
        this.destination = destination;
        this.weight = weight;
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShippingCost() {
        return shippingStrategy.calculateCost(weight, destination);
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }
}
public class ShippingSystem {
    public static void main(String[] args) {

        ShippingStrategy s1 = new StandardShipping();
        ShippingStrategy s2 = new ExpressShipping();
        ShippingStrategy s3 = new InternationShipping();

        Order o1 = new Order("USA", 10.5, s1);
        System.out.println("Shipping cost for order1 $" + o1.calculateShippingCost());

        Order o2 = new Order("Anywhere", 5.0, s2);
        System.out.println("Shipping cost for order2 $" + o2.calculateShippingCost());
        o1.setShippingStrategy(s3);
        System.out.println("Shipping cost for order1 after changing shipping strategy $" + o1.calculateShippingCost());

    }
}
