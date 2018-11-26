package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.directories.Currency;
import ru.shepico.homeacc.directories.Idirectory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CurrencyGUI extends JFrame implements Idirectory
{
    private JTable table;
    private JPanel panel;
    private ActionBar aBar;

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyGUI();
            }
        });
    }

    public CurrencyGUI() {
        aBar = new ActionBar();
        initListenerActionBar();
        initFrame();
    }

    private void initFrame(){
        setTitle("Валюта");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //


        add(aBar, BorderLayout.NORTH);
        //
        panel = new JPanel();
        showCurrency();
        panel.add(table);
        //
        add(panel, BorderLayout.CENTER);
        //
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void showCurrency(){
        table = new JTable(0,2);
        ArrayList<Currency> list = createListCurrency();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
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
        Currency currency;
        ArrayList<Currency> listCurrency = new ArrayList<Currency>();
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + ConstantAccount.NAME_DB + ".db");
            stmt = connect.createStatement();
            String query = "select * from currency";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next() ) {
                currency = new Currency(rs.getInt("id"), rs.getString("name"));
                listCurrency.add(currency);
            }
            stmt.close();
            connect.close();

        } catch (Exception e ) {
            e.printStackTrace();
        }

        return listCurrency;


    }
    //
    private void initListenerActionBar(){
        aBar.getBtnAdd().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addElement();
            }
        });
    }
    //Имплиминтированные методы
    public boolean addElement() {
        DefaultTableModel model= (DefaultTableModel) table.getModel();
        model.addRow(new Object[model.getRowCount()]);
        return false;
    }

    public boolean removeElement() {
        return false;
    }

    public boolean changeElement() {
        return false;
    }

    public boolean toArchiveElement() {
        return false;
    }

    public boolean fromArchiveElement() {
        return false;
    }
}
