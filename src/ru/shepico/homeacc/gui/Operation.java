package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.HomeAccMain;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Operation extends JFrame {
    private final String TITLE = "Operations";
    //
    private JPanel pnlMain;
    private JTable operationResultTable;

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
        operationResultTable = new JTable(5,8);
        //
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout(ConstantAccount.GAP_TABLE, ConstantAccount.GAP_TABLE));
        pnlMain.add(panelButtonTop, BorderLayout.NORTH);
        pnlMain.add(operationResultTable, BorderLayout.CENTER);

        add(pnlMain);
        //setLocationRelativeTo(null); // где будем отображать
        pack();
        setVisible(true);
    }
}
