package com.designpattern.structural.decorator;

/*
The implementation of Simple Coffee is also given
 */
public class SimpleCoffee implements Coffee{
    @Override
    public String getDiscription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
