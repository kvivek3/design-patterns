package com.designpattern.structural.facade;

class DVDPlayer {

    public void on() {
        System.out.println("Switching on DVD Player");
    }
    public void play() {
        System.out.println("Playing dvd now");
    }
}
class Projector {
    public void on() {
        System.out.println("Switching on projector");
    }
}
class Amplifier {
    public void on() {
        System.out.println("Switching on Amplifier");
    }
    public void setSoundLevel(int level) {
        System.out.println("Setting sound level to " + level);
    }
}
class Lights {
    public void setLight(int level) {
        System.out.println("Setting brightness to " + level);
    }
}
class HomeTheaterFacade {
    private Projector projector;
    private DVDPlayer dvdPlayer;
    private  Amplifier amplifier;
    private Lights lights;

    public HomeTheaterFacade(Projector projector, DVDPlayer dvdPlayer, Amplifier amplifier, Lights lights) {
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.lights = lights;
    }

    public void watchMovie() {
        projector.on();
        dvdPlayer.on();
        amplifier.on();
        lights.setLight(10);
        amplifier.setSoundLevel(20);
        dvdPlayer.play();
    }
}
public class HomeTheaterSystem {
    public static void main(String[] args) {

        Projector projector = new Projector();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(projector, dvdPlayer, amplifier, lights);
        homeTheaterFacade.watchMovie();

    }
}
