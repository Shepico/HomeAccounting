package ru.shepico.homeacc.gui;

import ru.shepico.sqlWork.SQLconnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class HomeAccGUI extends JFrame {
    private Panel mainPanel;
    private JTree accountTree;
    private JTabbedPane catOper;
    private JTable tableOperation;
    private JTable tableCurrency;

    private final Button btnAddAccount = new Button("Счет+");
    private final Button btnRemoveAccount = new Button("Счет-");
    private final Panel pnlAccount = new Panel();
    private final Panel pnlCategoryOperation = new Panel();


    //constructor
    private HomeAccGUI() {
        initFrame();
    }
    //end

    private void initFrame(){
        setTitle("HomeAcc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setIconImage();
        //
        mainPanel = new Panel();
        mainPanel.setLayout(new BorderLayout());
        //
        String     root  = "Счета";
        String[]   nodes = new String[]  {"Наличка", "Карты"};
        String[][] leafs = new String[][]{{"Кошелек", "Карман", "Рюкзак"},
                {"Сбер", "Сбер-кредитка", "ВТБ", "Халва"}};

        // создание дерева на основе массива
        Object[] data = new Object[] { nodes[0], nodes[1],
                new String[] { leafs[0][0], leafs[0][1], leafs[0][2] }};
    /*public TreeTest() {
            super("Пример использования JTree");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            // Данные для дерева на основе вектора
            Vector<String> vector = new Vector<String>();
            for (int i = 0; i < leafs[0].length; i++) {
                vector.add(leafs[0][i]);
            }
            // Данные для дерева  на основе таблицы
            Hashtable<String, String> table = new Hashtable<String, String>();
            for (int i = 0; i < nodes.length; i++) {
                table.put(nodes[i], String.valueOf(i));
            }*/

        accountTree = new JTree(data);
        accountTree.setRootVisible(true);
        //
        JPanel panelWestButton = new JPanel();
        panelWestButton.add(btnAddAccount);
        panelWestButton.add(btnRemoveAccount);

        JPanel panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        panelWest.add(panelWestButton);
        panelWest.add(accountTree);
        //mainPanel.add(accountTree, BorderLayout.WEST);
        mainPanel.add(panelWest, BorderLayout.WEST);
        catOper = new JTabbedPane();
        //
        Vector<String> headerVect = new Vector<String>();
        headerVect.add("Aa");
        headerVect.add("Bb");
        headerVect.add("Cc");
        headerVect.add("Dd");
        DefaultTableModel mod = new DefaultTableModel(headerVect, 0);
        tableOperation = new JTable(6,4);
        tableOperation.setModel(mod);

        Vector<String> newRow = new Vector<>();
        newRow.add("Покупка хлеба");
        newRow.add("125,53");
        newRow.add("Питание");
        newRow.add("Кошелек");
        mod.addRow(newRow);

        //
        tableCurrency = new JTable (6,2);
        //

        //
        catOper.addTab("Операции", tableOperation);
        catOper.addTab("Категории", new JTree());
        catOper.addTab("Валюты", tableCurrency);

        mainPanel.add(catOper, BorderLayout.CENTER);

        //
        add(mainPanel);
        pack(); //устанавливаем по размеру размещения
        setLocationRelativeTo(null); //разместить по центру рабочего стола
        setVisible(true);

        //
        SQLconnect db = new SQLconnect();
        db.selectData("SELECT * FROM currency;");


    }



    //
    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeAccGUI();
            }
        });
    }
}
