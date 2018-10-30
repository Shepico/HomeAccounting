package ru.shepico.homeacc;

import ru.shepico.homeacc.gui.MainWindow;
import ru.shepico.homeacc.gui.UserLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAccMain implements ActionListener {
    JFrame loginWindow; // окно входа
    JFrame mainWindow; //основное окно
    //

    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HomeAccMain();
            }
        });
    }

    private HomeAccMain(){
        initLoginWindow();
    }

    private void initLoginWindow() {
        loginWindow = new UserLogin(this);
    }

    private void initMainWindow(){
        mainWindow = new MainWindow();
    }


    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Login")) {
            //Здесь подключится к базе и проверить пользователя
            boolean f_login = true;
            if (f_login) {
                loginWindow.setVisible(false);
                initMainWindow();
            }
            //System.out.println("connect");
        }else if (command.equals("Check in")) {
            //Здесь провести регистрацию пользователя
            System.out.println("check in");
        }



    }
}
