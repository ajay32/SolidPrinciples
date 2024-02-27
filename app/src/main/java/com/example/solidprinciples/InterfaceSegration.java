package com.example.solidprinciples;

public class InterfaceSegration {
}


// It says interfaces should be such, clients should not implement un necessary  methods they do not need

interface ResturantEmployee {
    void cookFood();
    void washDishes();
    void serveCustomers();
}

class Waiter implements ResturantEmployee {
    @Override
    public void cookFood() {
        // no need
    }

    @Override
    public void washDishes() {
        // no need
    }

    @Override
    public void serveCustomers() {
        System.out.println("Serving the customers");
    }
}

// above is breaking the Interface segration principle

//==========

interface WaiterInterface {
    void serveCustomers();
    void takeOrder();
}

interface ChefInterface {
    void cookFood();
    void decideMenu();
}

class Waiter2 implements WaiterInterface {

    @Override
    public void serveCustomers() {
        // serving the customers
    }

    @Override
    public void takeOrder() {
        // taking the orders
    }
}

// now its fine we are only using methods that are relevant

