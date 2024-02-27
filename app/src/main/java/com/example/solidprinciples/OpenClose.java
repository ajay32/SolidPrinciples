package com.example.solidprinciples;

public class OpenClose {
}

// Open for Extension and close for Modification

// lets take previous solid example.. now I got the new requirement to save the data in file as we were saving
//data in db


class Dao1 {
    Invoice invoice;

    public Dao1(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        //saving to DB
    }

    public void saveToFile() {
        //saving to file
    }

    // now I added saveToFile method here so it is breaking the open close principle
    // because it modified the  Test Class , Live class with incoming traffic
}


//Fix for it .. Extend it

interface Dao2 {
    public void save(Invoice invoice);
}

 class SaveToDB implements Dao2 {

     @Override
     public void save(Invoice invoice) {
        // save to DB
     }
 }

class SaveToFile implements Dao2 {

    @Override
    public void save(Invoice invoice) {
        // save to file
    }
}


class ExtendToOtherRequirement implements Dao2 {

    @Override
    public void save(Invoice invoice) {
        // save to any other storage
    }
}