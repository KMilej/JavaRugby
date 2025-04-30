package ui;

import javax.swing.JFrame;

public class MainPage extends JFrame {
	
	private static final long serialVersionUID = 1L;

    public MainPage() {
        super("Training App"); // Ustawia tytuł okna

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamknięcie aplikacji po X
        setSize(1000, 750); // Ustawia rozmiar
        setLocationRelativeTo(null); // Ustawia na środku ekranu
        setVisible(true); // Pokazuje okno
    }
}
