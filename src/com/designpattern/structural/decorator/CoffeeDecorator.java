package com.designpattern.structural.decorator;


/*
CoffeeDecorator needs to be implemented
 */
public abstract class CoffeeDecorator implements Coffee{

    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDiscription() {
        return decoratedCoffee.getDiscription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
