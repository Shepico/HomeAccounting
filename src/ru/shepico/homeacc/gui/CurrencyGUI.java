package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.directories.Currency;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CurrencyGUI extends JFrame
{
    private JTable tableCurrency;
    private JPanel panel;

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyGUI();
            }
        });
    }

    public CurrencyGUI() {
        initFrame();
    }

    private void initFrame(){
        setTitle("Валюта");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //
        panel = new JPanel();
        showCurrency();
        panel.add(tableCurrency);
        //
        add(panel, BorderLayout.CENTER);
        //
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void showCurrency(){
        tableCurrency = new JTable(0,2);
        ArrayList<Currency> list = createListCurrency();
        DefaultTableModel model = (DefaultTableModel) tableCurrency.getModel();
        Object[] row = new Object[2];
        for (int i=0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            model.addRow(row);
        }

    }

    private ArrayList<Currency> createListCurrency(){
        Connection connect;
        Statement stmt;
        ArrayList<Currency> listCurrency = new ArrayList<Currency>();
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:accDB.db");
            stmt = connect.createStatement();
            String query = "select * from currency";
            ResultSet rs = stmt.executeQuery(query);
            Currency currency;

            while(rs.next() ) {
                currency = new Currency(rs.getInt("id"), rs.getString("name"));
                listCurrency.add(currency);
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return listCurrency;


    }
}
