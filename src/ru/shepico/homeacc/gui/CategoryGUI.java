package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.directories.Category;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryGUI extends JFrame {
    JPanel panel;
    JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CategoryGUI();
            }
        });
    }

    public CategoryGUI(){
        initFrame();
    }

    private void initFrame() {
        setTitle("Категория");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //
        panel = new JPanel();
        showCategory();
        panel.add(table);
        add(panel, BorderLayout.CENTER);
        //
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void showCategory() {
        table = new JTable(0,5);
        ArrayList<Category> list = createListCategory();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[5];
        for (int i=0; i<list.size(); i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).isGroup();
            row[3] = list.get(i).getParentID();
            row[4] = list.get(i).getUserID();
            model.addRow(row);
        }

    }

    private ArrayList<Category> createListCategory(){
        Connection connect;
        Statement stmt;
        Category category;
        ArrayList<Category> listCategory = new ArrayList<Category>();
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + ConstantAccount.NAME_DB + ".db");
            stmt = connect.createStatement();
            String query = "select * from category";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"), rs.getBoolean("group"),
                        rs.getInt("parent_id"), rs.getInt("user_id"));
                listCategory.add(category);
            }
            stmt.close();
            connect.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCategory;
    }
}
