package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MyTeam extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyTeam() {
		super("My Team"); // Ustawia tytuł okna

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamknięcie aplikacji po X
		setSize(1000, 750); // Ustawia rozmiar
		setLocationRelativeTo(null); // Ustawia na środku ekranu

		setContentPane(new MyTeamScreen());

		setVisible(true); // Pokaż okno
	}

}
