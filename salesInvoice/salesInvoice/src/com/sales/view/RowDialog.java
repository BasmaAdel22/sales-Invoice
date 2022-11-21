package com.sales.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RowDialog extends JDialog {


    public RowDialog(InvoiceFrame frame) {
        JButton okBtn = new JButton("OK");
        JButton cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("createRowOK");
        cancelBtn.setActionCommand("createRowCancel");

        itemNameField = new JTextField(20);
        itemCountField = new JTextField(20);
        itemPriceField = new JTextField(20);

        JLabel itemNameLbl = new JLabel("Item Name");
        JLabel itemCountLbl = new JLabel("Item Count");
        JLabel itemPriceLbl = new JLabel("Item Price");

        okBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 2));

        add(itemNameLbl);
        add(itemNameField);
        add(itemCountLbl);
        add(itemCountField);
        add(itemPriceLbl);
        add(itemPriceField);
        add(okBtn);
        add(cancelBtn);

        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }


    private final JTextField itemNameField;
    private final JTextField itemCountField;
    private final JTextField itemPriceField;

}
