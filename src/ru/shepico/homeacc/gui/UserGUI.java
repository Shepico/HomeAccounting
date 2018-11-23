package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.directories.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserGUI extends JFrame {
    JPanel panel;
    JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserGUI();
            }
        });
    }

    public UserGUI() {
        initFrame();
    }

    private void initFrame(){
        setTitle("Пользователи");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //
        panel = new JPanel();
        showUser();
        panel.add(table);
        add(panel, BorderLayout.CENTER);
        //
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

    private void showUser(){
        table = new JTable(0,3);
        ArrayList<User> list = createListUser();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[3];
        for(int i=0; i<list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getEmail();
            row[2] = list.get(i).getPassword();
            model.addRow(row);
        }
    }

    private ArrayList<User> createListUser(){
        Connection connect;
        Statement stmt;
        User user;
        ArrayList<User> listUser = new ArrayList<User>();
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + ConstantAccount.NAME_DB + ".db");
            stmt = connect.createStatement();
            String query = "select * from user";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next() ) {
                user = new User(rs.getInt("user_id"), rs.getString("email"),rs.getString("password"));
                listUser.add(user);
            }
            stmt.close();
            connect.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }
}
