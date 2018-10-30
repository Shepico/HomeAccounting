package ru.shepico.homeacc.gui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class UserLogin extends JFrame implements ActionListener{
    /*private final int WIDTH_WINDOW = 400;
    private final int HEIGHT_WINDOW = 600;*/
    private final int GAP_TABLE = 5;
    private final String TITLE = "Login user";
    //
    private JPanel pnlMain;
    private MaskFormatter maskEmail;
    private JFormattedTextField emailField;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JButton btnCheckInField;
    private JLabel titleWindow;


    public UserLogin () {
        setTitle(TITLE);
        //setIconImage();  Иконка окна входа
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        //////////////////
        //Создаем компоненты
        titleWindow = new JLabel(TITLE);
        titleWindow.setHorizontalAlignment(JLabel.CENTER);
        /*try {
            maskEmail = new MaskFormatter("*@*");
        }catch (ParseException e) {
            e.printStackTrace();
        }
        maskEmail.setPlaceholder("one@domenpochta.com");*/
        emailField = new JFormattedTextField();
        passwordField = new JPasswordField();
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        btnCheckInField = new JButton("Check in");
        //checkInField.setBackground(false);
        btnCheckInField.setContentAreaFilled(false);
        btnCheckInField.setBorder(null);
        btnCheckInField.addActionListener(this);
        //////////////////
        pnlMain = new JPanel(new GridLayout(5,1, GAP_TABLE, GAP_TABLE));
        pnlMain.add(titleWindow);
        pnlMain.add(emailField);
        pnlMain.add(passwordField);
        pnlMain.add(btnLogin);
        pnlMain.add(btnCheckInField);

        //////////////////
        add(pnlMain);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (btnLogin.equals(e.getSource())) {
            System.out.println("connect");
        }else if (btnCheckInField.equals(e.getSource())) {
            System.out.println("check in");
        }

    }
}
