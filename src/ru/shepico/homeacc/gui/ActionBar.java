package ru.shepico.homeacc.gui;

import javax.swing.*;
import java.awt.*;

public class ActionBar extends JPanel {
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnRemove;
    private JButton btnToArchive;
    private JButton btnFromArchive;

    //default
    public ActionBar(){
        btnAdd = new JButton("Добавить");
        btnUpdate = new JButton("Изменить");
        btnRemove = new JButton("Удалить");
        btnToArchive = new JButton("В архив");
        btnFromArchive = new JButton("Из архива");
        btnAdd.setVisible(true);
        btnUpdate.setVisible(true);
        btnRemove.setVisible(true);
        btnToArchive.setVisible(false);
        btnFromArchive.setVisible(false);
        initPanel();

    }
    public ActionBar(boolean visibleBtnAdd, boolean visibleBtnUpdate, boolean visibleBtnRemove, boolean visibleBtnToArchive, boolean visibleBtnFromArchive){
        btnAdd = new JButton("Добавить");
        btnUpdate = new JButton("Изменить");
        btnRemove = new JButton("Удалить");
        btnToArchive = new JButton("В архив");
        btnFromArchive = new JButton("Из архива");
        btnAdd.setVisible(visibleBtnAdd);
        btnUpdate.setVisible(visibleBtnUpdate);
        btnRemove.setVisible(visibleBtnRemove);
        btnToArchive.setVisible(visibleBtnToArchive);
        btnFromArchive.setVisible(visibleBtnFromArchive);
        initPanel();
    }

    private void initPanel(){
        setLayout(new GridLayout(1,5));
        add(btnAdd);
        add(btnUpdate);
        add(btnRemove);
        add(btnToArchive);
        add(btnFromArchive);

    }
}
