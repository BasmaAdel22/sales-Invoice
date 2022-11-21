package com.sales.view;

import java.awt.GridLayout;
import javax.swing.JDialog;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class InvoiceDialog extends JDialog {

    private final JTextField customerNameField;
    private final JTextField dateField;


    public InvoiceDialog (InvoiceFrame frame)
    {
        JLabel customerNameLabel = new JLabel("Customer Name ");
        customerNameField = new JTextField (20);
        JLabel dateLabel = new JLabel("Invoice Date");
        dateField = new JTextField (20);
        JButton okBtn = new JButton("Ok");
        JButton cancelBtn = new JButton("Cancel");
        okBtn.setActionCommand("createInvoiceOK");
        cancelBtn.setActionCommand("createInvoiceCancel");
        okBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        setLayout(new GridLayout(3,2));
        
        add (dateLabel);
        add (dateField);
        add (customerNameLabel);
        add (customerNameField);
        add (okBtn);
        add (cancelBtn);
        
        pack ();

        
    }
    
    public JTextField getCustomerNameField()
    {
        return customerNameField;
    }
    
    public JTextField getDateField()
    {
        return dateField;
    }
    
    
}
