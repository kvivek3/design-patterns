package com.designpattern.behavioural.state;

interface State {
    void insertMoney(VendingMachine machine);
    void dispense(VendingMachine machine);
}

class IdleState implements State {

    @Override
    public void insertMoney(VendingMachine machine) {

        System.out.println("Money Inserted");
        machine.setMachineState(new Dispense());

    }

    @Override
    public void dispense(VendingMachine machine) {

        System.out.println("Insert Money First");

    }
}
class Dispense implements State {

    @Override
    public void insertMoney(VendingMachine machine) {
        System.out.println("Money already inserted");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Dispensing Items");
        machine.setMachineState(new IdleState());
    }
}

class VendingMachine {

    private State machineState;

    public VendingMachine() {
        this.machineState = new IdleState();
    }

    public void setMachineState(State machineState) {
        this.machineState = machineState;
    }

    public void insertMoney() {
        machineState.insertMoney(this);
    }
    public void dispenseItem() {
        machineState.dispense(this);
    }
}

public class VendingMachineDemo {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.insertMoney();
        machine.insertMoney();
        machine.dispenseItem();
        machine.dispenseItem();
    }
}
