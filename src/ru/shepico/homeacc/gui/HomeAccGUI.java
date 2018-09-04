package ru.shepico.homeacc.gui;

import ru.shepico.sqlWork.SQLconnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class HomeAccGUI extends JFrame {
    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel leftPanel;
    private JPanel rightTrnPanel;
    private JPanel rightCatPanel;
    //
    private JPanel leftBtnPanel;
    private JPanel rightBtnTrnPanel;
    private JPanel rightBtnCatPanel;
    //
    private final Button btnAddAccount = new Button("Add");
    private final Button btnRemoveAccount = new Button("Remove");
    private final Button btnAddTransaction = new Button("Add");
    private final Button btnRemoveTransaction = new Button("Remove");
    private final Button btnChangeTransaction  = new Button("Change");
    private final Button btnAddCategory = new Button("Add");;
    private final Button btnRemoveCategory = new Button("Remove");
    //
    private JTabbedPane paneTrsCat;
    private JTable transactions;
    //
    private JTree accountTree;
    private JTree categoryTree;
    private JMenuBar mainMenu;

    //private JTable tableCurrency;


    //private final Panel pnlAccount = new Panel();
    //private final Panel pnlCategoryOperation = new Panel();


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
       /* mainPanel = new Panel();
        mainPanel.setLayout(new BorderLayout());*/
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


        //accountTree.setRootVisible(true);
        //


        /*JPanel panelWest = new JPanel();*/
        initMenu();
        setJMenuBar(mainMenu);

        /*mainPanel.add(accountTree, BorderLayout.WEST);*/
        initPaneLeft();
        mainPanel.add(leftPanel, BorderLayout.WEST);
        /*mainPanel.add(leftBtnPanel, BorderLayout.WEST);
        mainPanel.add(accountTree, BorderLayout.WEST);

        //
        /*Vector<String> headerVect = new Vector<String>();
        headerVect.add("Aa");
        headerVect.add("Bb");
        headerVect.add("Cc");
        headerVect.add("Dd");
        DefaultTableModel mod = new DefaultTableModel(headerVect, 0);

        tableOperation.setModel(mod);

        Vector<String> newRow = new Vector<>();
        newRow.add("Покупка хлеба");
        newRow.add("125,53");
        newRow.add("Питание");
        newRow.add("Кошелек");
        mod.addRow(newRow);

        //*/
        //tableCurrency = new JTable (6,2);
        //

        //
        initPaneRight();
        mainPanel.add(paneTrsCat, BorderLayout.CENTER);

        //
        add(mainPanel);
        pack(); //устанавливаем по размеру размещения
        setLocationRelativeTo(null); //разместить по центру рабочего стола
        setVisible(true);

        //
        //SQLconnect db = new SQLconnect();
        //db.selectData("SELECT * FROM currency;");


    }

    private void initPaneLeft() {
        leftBtnPanel = new JPanel();
        leftBtnPanel.add(btnAddAccount);
        leftBtnPanel.add(btnRemoveAccount);
        //
        accountTree = new JTree();
        //
        leftPanel = new JPanel();
        //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setLayout(new BorderLayout());

        leftPanel.add(leftBtnPanel,BorderLayout.NORTH);
        leftPanel.add(accountTree,BorderLayout.CENTER);
    }

    private void initPaneRight() {
        transactions = new JTable(6,5);
        categoryTree = new JTree();
        //
        rightBtnTrnPanel = new JPanel();

        rightBtnTrnPanel.add(btnAddTransaction);
        rightBtnTrnPanel.add(btnRemoveTransaction);
        rightBtnTrnPanel.add(btnChangeTransaction);
        //
        rightBtnCatPanel = new JPanel();
        rightBtnCatPanel.add(btnAddCategory);
        rightBtnCatPanel.add(btnRemoveCategory);
        //
        rightTrnPanel = new JPanel();
        //rightTrnPanel.setLayout(new BoxLayout(rightTrnPanel, BoxLayout.Y_AXIS));
        rightTrnPanel.setLayout(new BorderLayout());
        rightTrnPanel.add(rightBtnTrnPanel, BorderLayout.NORTH);
        rightTrnPanel.add(transactions, BorderLayout.CENTER);
        //
        rightCatPanel = new JPanel();
        //rightCatPanel.setLayout(new BoxLayout(rightCatPanel, BoxLayout.Y_AXIS));;
        rightCatPanel.setLayout(new BorderLayout());;
        rightCatPanel.add(rightBtnCatPanel, BorderLayout.NORTH);
        rightCatPanel.add(categoryTree, BorderLayout.CENTER);
        //
        paneTrsCat = new JTabbedPane();
        paneTrsCat.addTab("Transaction", rightTrnPanel);
        paneTrsCat.addTab("Category", rightCatPanel);

    }

    private void initMenu() {
        mainMenu = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu catalogMenu = new JMenu("Catalog");
        JMenu aboutMenu = new JMenu("About");

        JMenuItem menuItem = new JMenuItem("Currency");
        catalogMenu.add(menuItem);

        mainMenu.add(fileMenu);
        mainMenu.add(catalogMenu);
        mainMenu.add(aboutMenu);

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
