package com.sales.controller;

import com.sales.model.Invoice;
import com.sales.model.InvoiceTableModel;
import com.sales.model.Row;
import com.sales.model.RowTableModel;
import com.sales.view.InvoiceDialog;
import com.sales.view.InvoiceFrame;
import com.sales.view.RowDialog;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener {

    public Controller(InvoiceFrame frame) {
        this.frame = frame;
    }

    public Controller(RowDialog rowDialog) {
        this.rowDialog = rowDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "createInvoiceCancel":
                createInvoiceCancel();
                break;
            case "createRowOK":
                createRowOK();
                break;
            case "createRowCancel":
                createRowCancel();
                break;
            case "Load File":
                loadFile();
                break;

            case "Delete Invoice":
                deleteInvoice();
                break;

            case "Save File":
                saveFile();
                break;
            case "Create New Invoice":
                createNewInvoice();
                break;
            case "Create New Item":
                createNewItem();
                break;

            case "createInvoiceOK":
                createInvoiceOK();
                break;
            case "Delete Item":
                deleteItem();
                break;

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedIndex != -1) {

            Invoice currentInvoice = frame.getInvoices().get(selectedIndex);
            frame.getCustomerNameLabel().setText(currentInvoice.getCustomerName());
            frame.getInvoicesDateLabel().setText(currentInvoice.getDate());
            frame.getInvoicesTotalLabel().setText("" + currentInvoice.getInvoiceTotal());
            frame.getInvoicesNumLabel().setText("" + currentInvoice.getNum());
            RowTableModel rowTableModel = new RowTableModel(currentInvoice.getRows());
            frame.getRowTable().setModel(rowTableModel);
            rowTableModel.fireTableDataChanged();
        }

    }


    private void loadFile() {
        JFileChooser jfc = new JFileChooser();
        try {
            int result = jfc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = jfc.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerRows = Files.readAllLines(headerPath);

                ArrayList<Invoice> invoicesArray = new ArrayList<>();

                for (String headerRow : headerRows) {
                    String[] headerParts = headerRow.split(",");
                    int invoiceNum = Integer.parseInt(headerParts[0]);
                    String invoiceDate = headerParts[1];
                    String customerName = headerParts[2];

                    Invoice invoice = new Invoice(invoiceNum, invoiceDate, customerName);
                    invoicesArray.add(invoice);
                }

                result = jfc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    fromCsv(jfc, invoicesArray);
                }
                frame.setInvoice(invoicesArray);
                InvoiceTableModel invoiceTableModel = new InvoiceTableModel(invoicesArray);
                frame.setInvoiceTableModel(invoiceTableModel);
                frame.getInvoicesTable().setModel(invoiceTableModel);
                frame.getInvoicesTableModel().fireTableDataChanged();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void fromCsv(JFileChooser jfc, ArrayList<Invoice> invoicesArray) throws IOException {
        File RowFile = jfc.getSelectedFile();
        Path RowPath = Paths.get(RowFile.getAbsolutePath());
        List<String> rowRows = Files.readAllLines(RowPath);
        for (String rowRow : rowRows) {
            String[] rowParts = rowRow.split(",");
            int invoiceNum = Integer.parseInt(rowParts[0]);
            String itemName = rowParts[1];
            double itemPrice = Double.parseDouble(rowParts[2]);
            int count = Integer.parseInt(rowParts[3]);
            Invoice inv = null;
            for (Invoice invoice : invoicesArray) {
                if (invoice.getNum() == invoiceNum) {
                    inv = invoice;
                    break;
                }
            }
            Row row = new Row(itemName, itemPrice, count, inv);
            assert inv != null;
            inv.getRows().add(row);
        }
    }

    private void saveFile() {
        ArrayList<Invoice> invoices = frame.getInvoices();
        String headers = "";
        String Rows = "";
        for (Invoice invoice : invoices) {
            String invCSV = invoice.getAsCSV();
            headers += invCSV;
            headers += "\n";
            for (Row row : invoice.getRows()) {
                String rowCSV = row.toCSV();
                Rows += rowCSV;
                Rows += "\n";
            }

        }

        try {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = jfc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();

                result = jfc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File rowFile = jfc.getSelectedFile();
                    FileWriter lfw = new FileWriter(rowFile);
                    lfw.write(Rows);
                    lfw.flush();
                    lfw.close();


                }

            }

        } catch (Exception ex) {
        }
    }

    private void createNewInvoice() {
        invoiceDialog = new InvoiceDialog(frame);
        invoiceDialog.setVisible(true);

    }

    private void createNewItem() {
        rowDialog = new RowDialog(frame);
        rowDialog.setVisible(true);

    }

    private void createInvoiceOK() {
        String date = invoiceDialog.getDateField().getText();
        String customer = invoiceDialog.getCustomerNameField().getText();
        int num = frame.getNextInvoiceNum();
        Invoice invoice = new Invoice(num, date, customer);
        frame.getInvoices().add(invoice);
        frame.getInvoicesTableModel().fireTableDataChanged();
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
    }


    private void createRowCancel() {
        rowDialog.setVisible(false);
        rowDialog.dispose();
        rowDialog = null;

    }


    private void createInvoiceCancel() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;

    }


    private void deleteInvoice() {
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        if (selectedRow != -1) {
            frame.getInvoices().remove(selectedRow);
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }


    private void deleteItem() {

        int selectedRow = frame.getRowTable().getSelectedRow();
        if (selectedRow != -1) {

            RowTableModel rowTableModel = (RowTableModel) frame.getRowTable().getModel();
            rowTableModel.getRows().remove(selectedRow);
            rowTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();

        }
    }


    private void createRowOK() {
        String item = rowDialog.getItemNameField().getText();
        String countStr = rowDialog.getItemCountField().getText();
        String priceStr = rowDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
        if (selectedInvoice != -1) {
            Invoice invoice = frame.getInvoices().get(selectedInvoice);
            Row row = new Row(item, price, count, invoice);
            invoice.getRows().add(row);
            RowTableModel rowTableModel = (RowTableModel) frame.getRowTable().getModel();
            rowTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }

        rowDialog.setVisible(false);
        rowDialog.dispose();
        rowDialog = null;

    }


    private InvoiceFrame frame;
    private InvoiceDialog invoiceDialog;
    private RowDialog rowDialog;


}
