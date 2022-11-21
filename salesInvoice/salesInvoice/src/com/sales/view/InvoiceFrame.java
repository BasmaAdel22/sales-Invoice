/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sales.view;

import com.sales.controller.Controller;
import com.sales.model.Invoice;
import com.sales.model.InvoiceTableModel;

import java.util.ArrayList;
import javax.swing.*;

public class InvoiceFrame extends javax.swing.JFrame {


    public InvoiceFrame() {
        initComponents();
        this.setTitle("Invoice");
    }


    private void initComponents() {


        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        InvoiceTable.getSelectionModel().addListSelectionListener(controller);
        javax.swing.JButton createInvoiceButton = new javax.swing.JButton();
        createInvoiceButton.addActionListener(controller);
        javax.swing.JButton deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(controller);
        JLabel jLabel1 = new JLabel();
        JLabel invoiceDateLabel = new JLabel();
        JLabel customerNameLabel = new JLabel();
        JLabel invoiceTotalLabel = new JLabel();
        JLabel jLabel5 = new JLabel();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        javax.swing.JButton createRowButton = new javax.swing.JButton();
        createRowButton.addActionListener(controller);
        javax.swing.JButton deleteRowButton = new javax.swing.JButton();
        deleteRowButton.addActionListener(controller);
        numLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        custNameLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenuItem loadFileMenuItem = new javax.swing.JMenuItem();
        loadFileMenuItem.addActionListener(controller);
        javax.swing.JMenuItem saveFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        jScrollPane1.setViewportView(InvoiceTable);

        createInvoiceButton.setText("Create New Invoice");

        deleteInvoiceButton.setText("Delete Invoice");

        jLabel1.setText("Invoice Number");

        invoiceDateLabel.setText("Invoice Date");

        customerNameLabel.setText("Customer Name");

        invoiceTotalLabel.setText("Invoice Total");

        jLabel5.setText("Invoice Items");

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        jScrollPane2.setViewportView(lineTable);

        createRowButton.setText("Create New Item");

        deleteRowButton.setText("Delete Item");

        jMenu1.setText("File");

        loadFileMenuItem.setText("Load File");
        jMenu1.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save File");
        jMenu1.add(saveFileMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(createInvoiceButton)
                                                .addGap(28, 28, 28)
                                                .addComponent(deleteInvoiceButton)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(invoiceDateLabel)
                                                                        .addComponent(customerNameLabel)
                                                                        .addComponent(invoiceTotalLabel))
                                                                .addGap(47, 47, 47)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(numLabel)
                                                                        .addComponent(dateLabel)
                                                                        .addComponent(custNameLabel)
                                                                        .addComponent(totalLabel))))
                                                .addGap(0, 10, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(createRowButton)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(deleteRowButton))
                                                        .addComponent(jLabel5))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(numLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceDateLabel)
                                                        .addComponent(dateLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(customerNameLabel)
                                                        .addComponent(custNameLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceTotalLabel)
                                                        .addComponent(totalLabel)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(createInvoiceButton)
                                                        .addComponent(deleteInvoiceButton)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createRowButton)
                                        .addComponent(deleteRowButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public int getNextInvoiceNum() {
        int num = 0;
        for (Invoice invoice : invoices) {
            if (invoice.getNum() > num)
                num = invoice.getNum();
        }
        return ++num;
    }


    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new InvoiceFrame().setVisible(true));
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoice(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public InvoiceTableModel getInvoicesTableModel() {
        return invoiceTableModel;
    }

    public void setInvoiceTableModel(InvoiceTableModel invoiceTableModel) {
        this.invoiceTableModel = invoiceTableModel;
    }

    public JTable getInvoicesTable() {
        return InvoiceTable;
    }

    public JLabel getCustomerNameLabel() {
        return custNameLabel;
    }

    public JLabel getInvoicesDateLabel() {
        return dateLabel;
    }

    public JLabel getInvoicesNumLabel() {
        return numLabel;
    }

    public JLabel getInvoicesTotalLabel() {
        return totalLabel;
    }

    public JTable getRowTable() {
        return lineTable;
    }


    public Controller getController() {
        return controller;
    }

    private final Controller controller = new Controller(this);

    private javax.swing.JTable InvoiceTable;

    private javax.swing.JLabel totalLabel;
    private ArrayList<Invoice> invoices;
    private InvoiceTableModel invoiceTableModel;

    private javax.swing.JLabel custNameLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTable lineTable;
    private javax.swing.JLabel numLabel;

}
