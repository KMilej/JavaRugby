/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: MainPage.java
 * Description:
 * JFrame that serves as the starting point of the application.
 * Displays the login panel and sets it as the main content pane.
 */

package ui;

import javax.swing.JFrame;

/**
 * Main application window that displays the login screen on startup.
 */
public class MainPage extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs the main window and loads the login panel.
     */
    public MainPage() {
        super("Training App");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);

        LoginPanel loginPanel = new LoginPanel();
        setContentPane(loginPanel);
        getRootPane().setDefaultButton(loginPanel.getLoginButton());

        setVisible(true);
    }
}
