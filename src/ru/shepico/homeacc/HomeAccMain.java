package ru.shepico.homeacc;

import ru.shepico.homeacc.gui.UserLogin;

import javax.swing.*;

public class HomeAccMain {

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
}
