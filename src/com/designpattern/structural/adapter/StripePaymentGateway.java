package com.designpattern.structural.adapter;

public class StripePaymentGateway {
    void makePayment(double amount) {
        System.out.printf("Processing payment of %f via Stripe.", amount);
    }
}
