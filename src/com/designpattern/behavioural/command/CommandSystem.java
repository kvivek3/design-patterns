package com.designpattern.behavioural.command;

interface Command {
    void execute();
    void undo();
}

class LightOnCommand implements Command {
    private Light light;


    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOn();

    }

    @Override
    public void undo() {
        light.switchOff();
    }
}

class LightOffCommand implements Command {
    private Light light;


    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOff();

    }

    @Override
    public void undo() {
        light.switchOn();
    }
}
class Light {
    public void switchOn() {
        System.out.println("Switching on Light");
    }
    public void switchOff() {
        System.out.println("Switching off Light");
    }
}





public class CommandSystem {
    public static void main(String[] args) {
        Light light = new Light();
        Command c1 = new LightOnCommand(light);
        Command c2 = new LightOffCommand(light);
        c1.execute();
        c1.undo();
        c1.execute();
        c2.execute();
        c2.undo();

    }
}
