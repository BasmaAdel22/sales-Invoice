package com.sales.model;

public class Row {

    


    public Row(String item, double price, int count, Invoice invoice) {
        
        this.item = item;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public double getRowTotal(){
        return price*count;
    }

    public String toCSV()
    {
        return invoice.getNum() + "," + item + "," + price +"," + count;
    }


    private final String item;
    private final double price;
    private final int count;
    private final Invoice invoice;

}
