package ru.shepico.homeacc.system;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableModelAcc extends AbstractTableModel {
    private String[] columnNames = {"id", "name"};
    Object[][] data = {
            {"1", "Rub"},
            {"2", "Euro"},
            {"3", "Dollars",}
    };

    public TableModelAcc(String[] columnNames){
        super();
        this.columnNames = new String[columnNames.length];
        System.arraycopy(columnNames,0, this.columnNames, 0, columnNames.length);

    }

    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
