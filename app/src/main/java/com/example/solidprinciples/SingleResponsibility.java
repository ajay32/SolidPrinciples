package com.example.solidprinciples;

public class SingleResponsibility {
    public static void main(String args[]) {

        Marker marker = new Marker("mymarker", "green",10, "1993");
        Invoice invoice = new Invoice(marker, 5);
        invoice.calculateTota();
    }

}

// SRP says there should be only 1 reason to change

/// Lets take example of a Marker (Pen) ..we to create a Invoice for the Marker

class Marker {

    String name;
    String color;
    int price;
    String year;

    public Marker(String name, String color, int price, String year) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.year = year;
    }
}

class Invoice {
    Marker marker;
    int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public void calculateTota() { // 1 reason to change when we need this logic to add gst or discount
        System.out.println("Total amount "+(marker.price * quantity));

    }

    public void printInvoice() { // 2nd reason to change if I change print logic

    }

    public void saveInDB() { //3rd reason to change if I want to save in a file any day

    }

    //  now we have 3 reason to change the class so it is not following SRP
}

// Lets fix this by creating 2 more classes for pint and save to DB responsibility and passing invoice to it

class Dao {
    Invoice invoice;

    public Dao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        //saving to DB
    }
}

class PrintInvoice {
    Invoice invoice;

    public PrintInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        // printing the invoice
    }
}


// Easy to maintain and Easy to understand because if we need to make somechanges in to save In File I
// have to only make changes to Dao class




