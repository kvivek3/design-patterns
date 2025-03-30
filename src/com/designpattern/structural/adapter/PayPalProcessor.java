package com.designpattern.structural.adapter;

public class PayPalProcessor implements PaymentProcessor{
    @Override
    public void pay(int amount) {
        System.out.printf("Processing payment of $ %d via PayPal.", amount);
    }
}
