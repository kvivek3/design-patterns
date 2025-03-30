package com.designpattern.structural.adapter;

public class StripeAdapter implements PaymentProcessor{
    private StripePaymentGateway stripePaymentGateway;

    public StripeAdapter(StripePaymentGateway stripePaymentGateway) {
        this.stripePaymentGateway = stripePaymentGateway;
    }
    @Override
    public void pay(int amount) {
        stripePaymentGateway.makePayment((double) amount);
    }
}
