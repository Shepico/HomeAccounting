package ru.shepico.homeacc;

import ru.shepico.homeacc.gui.UserLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAccMain implements ActionListener {

    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initLoginWindow();
            }
        });
    }

    private static void initLoginWindow() {
        JFrame loginWindow = new UserLogin();
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Login")) {
            //Здесь подключится к базе и проверить пользователя
            System.out.println("connect");
        }else if (command.equals("Check in")) {
            //Здесь провести регистрацию пользователя
            System.out.println("check in");
        }



    }
}
