package ui;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;

public class MainPage extends JFrame {
	
	private static final long serialVersionUID = 1L;

    public MainPage() {
        super("Training App"); // Ustawia tytuł okna

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamknięcie aplikacji po X
        setSize(1000, 750); // Ustawia rozmiar
        setLocationRelativeTo(null); // Ustawia na środku ekranu
        
       
        
        
        LoginPanel loginPanel = new LoginPanel();
        setContentPane(loginPanel);
        getRootPane().setDefaultButton(loginPanel.getLoginButton());
        
        
        setVisible(true); // Pokazuje okno
    }
}
