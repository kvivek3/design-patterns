package com.designpattern.structural.bridge;

interface Color {
    void apply();
}

class Red implements Color {

    @Override
    public void apply() {
        System.out.println("Applying Red Color");
    }
}

class Green implements Color {

    @Override
    public void apply() {
        System.out.println("Applying Green Color");
    }
}
abstract class Shape {
    protected Color color;
    public Shape(Color color) {
        this.color = color;
    }
    abstract void draw();
}
class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Drawing circle ");
        color.apply();
    }
}

class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Drawing Rectangle ");
        color.apply();
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        Circle redCircle = new Circle(new Red());
        redCircle.draw();
        Circle greenCircle = new Circle(new Green());
        greenCircle.draw();
        Rectangle rectangle = new Rectangle(new Green());
        rectangle.draw();
    }
}
