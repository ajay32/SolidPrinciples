package com.example.solidprinciples;

public class LiskovSubtitute {
    // so to Bike we also sending motercycle object... it is working fine ..one day we send the cycle object to it it will break
    public static void main(String args[]) {

        Bike bike = new MoterCycle();
        bike.turnOnEngine();

        Bike cycle = new Cycle();
        cycle.turnOnEngine();

    }


}
// It says about parent child relationship.. suppose we have parent class A (interface or class) and child class B
// so we can replace parent class object with child class object .. but it should not break the code(Program)

// passing child class object where parent class object is need should extend the capability (like bache
// parent ka business badaye ) na ki kharab kare

// like class A  +1  (feature)
// like Class B +1 (from class A) and +1 from (himself) = +2

// Lets a example using interface

interface Bike {
    void turnOnEngine();
    void accelerate();
}

class MoterCycle implements Bike {

    boolean isEngineOn;
    int speed;

    @Override
    public void turnOnEngine() {
        // turning on engine
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        // accelearting bike
        speed = +10;
    }
}

class Cycle implements Bike {
    @Override
    public void turnOnEngine() {
        //now engine
        throw new AssertionError("No engine available");
    }

    @Override
    public void accelerate() {
        // do something
    }
}


