package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.directories.Currency;
import ru.shepico.sqlWork.SQLconnect;

import javax.swing.*;
import java.util.ArrayList;

public class CatalogGUI extends JFrame {
    private JTable tableCatalog;

    CatalogGUI(String nameCatalog) {
        setTitle(nameCatalog);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //
        tableCatalog = new JTable(3,6);
        //
        selectData(tableCatalog);
        add(tableCatalog);
        //
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void selectData(JTable tableCatalog) {
        ArrayList<Currency> arrCurrency;
        SQLconnect db = new SQLconnect();
        arrCurrency = db.selectData("SELECT * FROM currency;", "Currency");
        for (int i=0; i<arrCurrency.size(); i++) {
            Currency next = arrCurrency.get(i);
            System.out.println(next);
        }



    }
}
