package ru.shepico.homeacc.gui;

import javax.swing.*;
import java.awt.*;

public class HomeAccGUI extends JFrame {
    private Panel mainPanel;
    private JTree accountTree;
    private JTabbedPane catOper;
    private JTable tableOperation;
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
        accountTree = new JTree();

        mainPanel.add(accountTree, BorderLayout.WEST);
        catOper = new JTabbedPane();
        tableOperation = new JTable(6,4);
        catOper.addTab("Операции", tableOperation);
        catOper.addTab("Категории", new JTree());

        mainPanel.add(catOper, BorderLayout.CENTER);

        //
        add(mainPanel);
        pack(); //устанавливаем по размеру размещения
        setLocationRelativeTo(null); //разместить по центру рабочего стола
        setVisible(true);
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
