
package com.sales.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RowTableModel extends AbstractTableModel {

    public RowTableModel(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int column){
        return columns[column];
   
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Row row = rows.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> row.getInvoice().getNum();
            case 1 -> row.getItem();
            case 2 -> row.getPrice();
            case 3 -> row.getCount();
            case 4 -> row.getRowTotal();
            default -> "";
        };
    }

    private final ArrayList<Row> rows;
    private final String [] columns= {"No." ,"Item Name" ,"Price","Count" ,"Total"};

}
