package ru.shepico.homeacc.gui;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.HomeAccMain;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class UserLogin extends JFrame{
    //private final int GAP_TABLE = 5;
    private final String TITLE = "Login user";
    //
    private JPanel pnlMain;
    private MaskFormatter maskEmail;
    private JFormattedTextField emailField;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JButton btnCheckInField;
    private JLabel titleWindow;
    //private HomeAccMain listener;


    public UserLogin (HomeAccMain listener) {
        //
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
        btnLogin.addActionListener(listener);
        btnCheckInField = new JButton("Check in");
        btnCheckInField.setContentAreaFilled(false);
        btnCheckInField.setBorder(null);
        btnCheckInField.addActionListener(listener);
        //////////////////
        pnlMain = new JPanel(new GridLayout(5,1, ConstantAccount.GAP_TABLE, ConstantAccount.GAP_TABLE));
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

    public void changeVisible() {
        setVisible(!isVisible());
    }

    /*public void actionPerformed(ActionEvent e) {
        if (btnLogin.equals(e.getSource())) {
            //Здесь подключится к базе и проверить пользователя
            System.out.println("connect");
        }else if (btnCheckInField.equals(e.getSource())) {
            //Здесь провести регистрацию пользователя
            System.out.println("check in");
        }

    }*/
}
