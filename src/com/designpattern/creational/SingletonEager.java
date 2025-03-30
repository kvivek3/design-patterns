package com.designpattern.creational;

public class SingletonEager {

    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {};

    public static SingletonEager getInstance() {
        return  instance;
    }

    public void log(String message) {
        System.out.println(String.format("Logging %s", message));
    }
}
