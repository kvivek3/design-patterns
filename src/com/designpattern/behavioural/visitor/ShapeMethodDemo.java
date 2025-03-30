package com.designpattern.behavioural.visitor;



interface Visitor {
    void VisitCircle(Circle circle);
    void VisitRectangle(Rectangle rectangle);
}
class AreaCalculator implements Visitor {

    @Override
    public void VisitCircle(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        System.out.println("Circle Area: " + area);
    }

    @Override
    public void VisitRectangle(Rectangle rectangle) {
        double area = rectangle.getLength() * rectangle.getBreadth();
        System.out.println("Rectangle Area: " + area);
    }
}

interface Shape {
    void accept(Visitor visitor);
}

class Circle implements Shape {
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitCircle(this);
    }
}

class Rectangle implements Shape {
    private double length;
    private double breadth;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitRectangle(this);
    }
}

public class ShapeMethodDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(23);
        Visitor visitor = new AreaCalculator();
        circle.accept(visitor);
        Rectangle rectangle = new Rectangle();
        rectangle.setBreadth(2);
        rectangle.setLength(5);
        rectangle.accept(visitor);
    }
}
