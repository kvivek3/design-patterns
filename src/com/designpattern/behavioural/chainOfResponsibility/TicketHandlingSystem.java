package com.designpattern.behavioural.chainOfResponsibility;

abstract class SupportHandler {

    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler supportHandler) {
        this.nextHandler = supportHandler;
    }
    abstract void handleRequest(String ticket);
}

class Level1 extends SupportHandler {

    @Override
    void handleRequest(String ticket) {
        if (ticket.equalsIgnoreCase("Basic")) {
            System.out.println("Level One Support: Handling basic request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }
}
class Level2 extends SupportHandler {

    @Override
    void handleRequest(String ticket) {
        if (ticket.equalsIgnoreCase("Intermediate")) {
            System.out.println("Level Two Support: Handling intermediate request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }
}
class Level3 extends SupportHandler {

    @Override
    void handleRequest(String ticket) {
        if (ticket.equalsIgnoreCase("Advanced")) {
            System.out.println("Level Three Support: Handling advanced request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
        else {
            System.out.println("Request Not Handled");
        }
    }
}

public class TicketHandlingSystem {
    public static void main(String[] args) {

        SupportHandler l1 = new Level1();
        SupportHandler l2 = new Level2();
        SupportHandler l3 = new Level3();

        l1.setNextHandler(l2);
        l2.setNextHandler(l3);

        l1.handleRequest("Basic");
        l1.handleRequest("Intermediate");
        l1.handleRequest("Advanced");
        l1.handleRequest("very very advanced");




    }
}
