package com.designpattern.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

//Observer Interface
interface Observer {
    void update(double price);
}
//Subject Interface
interface Subject {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObserver();
}

//Concrete Subject
class Stock implements Subject {
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public void setPrice(double price) {
        this.price = price;
        notifyObserver();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.update(price);
        }
    }
}

//Concrete Observer (Display)
class StockChart implements Observer {
    private String name;

    public StockChart(String name) {
        this.name = name;
    }
    @Override
    public void update(double price) {
        System.out.println("Price Update Display " + price);
    }
}

class Notification implements Observer {

    private String name;

    public Notification(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println("New Stock Price " + price);
    }
}

public class StockPriceUpdateSystem {
    public static void main(String[] args) {
        Observer observer1 = new StockChart("Dispay1");
        Observer observer2 = new Notification("WhatsAPP");

        Stock stock = new Stock();
        stock.registerObserver(observer1);
        stock.registerObserver(observer2);

        stock.setPrice(5.0);
        stock.deregisterObserver(observer1);
        stock.setPrice(1.0);

    }
}
