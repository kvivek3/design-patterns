package com.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void draw();
}
class Circle implements Graphic {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Graphic {

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class CompositeGraphic implements Graphic {

    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        for(Graphic graphic : graphics)
            graphic.draw();
    }
}




public class GraphicsManagement {
    public static void main(String[] args) {
        CompositeGraphic compositeGraphic = new CompositeGraphic();
        Graphic circle = new Circle();
        Graphic square = new Square();

        compositeGraphic.add(circle);
        compositeGraphic.draw();
        compositeGraphic.add(square);
        compositeGraphic.draw();
    }
}
