package ru.shepico.homeacc.gui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class UserLogin extends JFrame {
    private final int WIDTH_WINDOW = 400;
    private final int HEIGHT_WINDOW = 600;
    //
    private JPanel pnlMain;
    private MaskFormatter maskEmail;
    private JFormattedTextField emailField;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JButton checkInField;

    UserLogin () {
        setTitle("Login user");
        //setIconImage();  Иконка окна входа
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        //////////////////
        //Создаем компоненты
        try {
            maskEmail = new MaskFormatter("*@*");
        }catch (ParseException e) {
            e.printStackTrace();
        }
        maskEmail.setPlaceholder("one@domenpochta.com");
        emailField = new JFormattedTextField(maskEmail);
        passwordField = new JPasswordField();
        btnLogin = new JButton("Login");
        checkInField = new JButton("check in");
        checkInField.setBackground(null);
        checkInField.setBorder(null);
        //////////////////
        pnlMain = new JPanel(new GridLayout(4,1));
        pnlMain.add(emailField);
        pnlMain.add(passwordField);
        pnlMain.add(btnLogin);
        pnlMain.add(checkInField);

        //////////////////
        add(pnlMain);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
