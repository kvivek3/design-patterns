package com.designpattern.structural.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        PaymentProcessor payPal = new PayPalProcessor();
        payPal.pay(100);

        StripePaymentGateway stripePaymentGateway = new StripePaymentGateway();
        StripeAdapter stripeAdapter = new StripeAdapter(stripePaymentGateway);
        stripeAdapter.pay(100);
    }
}
