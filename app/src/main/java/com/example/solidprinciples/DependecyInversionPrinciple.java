package com.example.solidprinciples;

public class DependecyInversionPrinciple {
}
// it has 2 principles
// 1. class should depend on interface rather than concrete implementation
// 2. Constructor Injection rather than creating real objects

// I am creating a macbook with keyboard and mouse

interface Keyboard {
    void pressKeys();
}

class WiredKeyboard implements Keyboard {
    @Override
    public void pressKeys() {

    }
}

class BluetoothKeyboard implements Keyboard {
    @Override
    public void pressKeys() {

    }
}

interface Mouse {
    void moveMouse();
}

class Macbook1  {
    WiredKeyboard keyboard; // wrong it should be interface otherwise if i have to change the bluetooth keyboard how will I change
 // it should be Keyboard keyboard;
    public Macbook1(WiredKeyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setKeyboard() {
        System.out.println("Set keyboard was"+keyboard);
    }
}


class Macbook  {
    Keyboard keyboard;

    public Macbook(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setKeyboard() {
        System.out.println("Set keyboard was"+keyboard);
    }
}





