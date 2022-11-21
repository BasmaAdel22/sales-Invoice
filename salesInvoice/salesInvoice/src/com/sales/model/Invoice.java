package com.sales.model;

import java.util.ArrayList;

public class Invoice {



    public Invoice() { }

    public Invoice(int num, String date, String customerName) {
        this.num = num;
        this.date = date;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNum() {
        return num;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Row> getRows() {
        if (rows == null)
        {
            rows = new ArrayList<>();
        }
        return rows;
    }
    public double getInvoiceTotal()
    {
        double total =0.0;
        for (Row row : getRows())
        {
            total += row.getRowTotal();
        }
        return total;
    }

    public String getAsCSV ()
    {
        return num + "," + date + "," + customerName;
    }

    private ArrayList<Row> rows;
    private String date;

    private int num ;
    private String customerName;
    
}
