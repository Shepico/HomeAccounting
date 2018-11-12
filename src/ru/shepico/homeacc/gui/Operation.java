package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.HomeAccMain;
import ru.shepico.homeacc.system.TableModelAcc;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;

import java.util.Vector;

public class Operation extends JFrame {
    private final String TITLE = "Operations";
    //
    private JPanel pnlMain;
    private JTable resultTable;
    //private JTableHeader resultTableHeader;
    private JScrollPane scrollPaneTable;

    public Operation(HomeAccMain listener){
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //

        JPanel panelButtonTop = new JPanel(new GridLayout(1,5, ConstantAccount.GAP_TABLE, ConstantAccount.GAP_TABLE ));
        JButton btnAddOperation = new JButton("Add");
        JButton btnChangeOperation = new JButton("Change");
        JButton btnRemoveOperation = new JButton("Remove");
        panelButtonTop.add(btnAddOperation);
        panelButtonTop.add(btnChangeOperation);
        panelButtonTop.add(btnRemoveOperation);
        //
        //initTable();

        String[] columnNames = {"id", "name"};
        resultTable = new JTable(new TableModelAcc(columnNames));
        scrollPaneTable = new JScrollPane();
        scrollPaneTable.setViewportView(resultTable);
        //

        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout(ConstantAccount.GAP_TABLE, ConstantAccount.GAP_TABLE));
        pnlMain.add(panelButtonTop, BorderLayout.NORTH);
        //pnlMain.add(resultTable, BorderLayout.CENTER);
        pnlMain.add(scrollPaneTable, BorderLayout.CENTER);

        add(pnlMain);
        //setLocationRelativeTo(null); // где будем отображать
        pack();
        setVisible(true);
    }

    private void initTable() {
        String[] columnNames = {"id", "name"};
        Object[][] data = {
                {"1", "Rub"},
                {"2", "Euro"},
                {"3", "Dollars",}
        };
        resultTable = new JTable(data, columnNames);
    }
}
