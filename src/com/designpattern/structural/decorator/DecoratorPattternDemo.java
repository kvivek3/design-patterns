package com.designpattern.structural.decorator;

public class DecoratorPattternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDiscription() + " -> $" + coffee.getCost());


        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDiscription() + " -> $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDiscription() + " -> $" + coffee.getCost());

    }
}
