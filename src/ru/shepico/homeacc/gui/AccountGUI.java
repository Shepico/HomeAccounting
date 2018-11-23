package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.directories.Account;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class AccountGUI extends JFrame {
    JPanel panel;
    JTable table;

    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AccountGUI();
            }
        });
    }

    public AccountGUI(){
        setTitle("Счета");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //
        panel = new JPanel();
        showAccount();
        panel.add(table);
        add(panel, BorderLayout.CENTER);
        //
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void showAccount(){
        table = new JTable(0, 6);
        ArrayList<Account> list = createListAccount();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[6];
        for (int i=0; i<list.size(); i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).isGroup();
            row[3] = list.get(i).getCurrencyID();
            row[4] = list.get(i).getParentID();
            row[5] = list.get(i).getUserID();
            model.addRow(row);
        }

    }

    private ArrayList<Account> createListAccount() {
        Connection connect;
        Statement stmt;
        Account account;
        ArrayList<Account> listAccount = new ArrayList<Account>();
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + ConstantAccount.NAME_DB + ".db");
            stmt = connect.createStatement();
            String query = "Select * from account";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                account = new Account(rs.getInt("id"), rs.getString("name"), rs.getBoolean("group"),
                    rs.getInt("currency_id"), rs.getInt("parent_id"), rs.getInt("user_id"));
                listAccount.add(account);
            }
            stmt.close();
            connect.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return listAccount;
    }
}
