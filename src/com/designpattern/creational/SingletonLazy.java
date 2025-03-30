package com.designpattern.creational;

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {

    }

    public static synchronized SingletonLazy getInstance() {
        if(instance == null)
            instance = new SingletonLazy();
        return instance;
    }

    public void log(String message) {
        System.out.printf("Log %s%n", message);
    }
}
