package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import models.Coach;

public class PlayerSquadScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public PlayerSquadScreen(Coach coach, Coach loggedCoach) {
		setLayout(null);
		setSize(1000, 750);
		
		JLabel title = new JLabel("Welcome in SR Menu: " + loggedCoach.getFirstName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(308, 29, 600, 40); // ustaw pozycję i szerokość
		add(title);
		
		JLabel teamName = new JLabel(" Team menu: " + coach.getTeams());
		teamName.setFont(new Font("Arial", Font.BOLD, 20));
		teamName.setBounds(28, 81, 600, 40); // ustaw pozycję i szerokość
		add(teamName);

		JButton btngetback = new JButton("Back to menu");
		btngetback.setBounds(28, 18, 150, 40);
		btngetback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// znajdź okno, w którym znajduje się ten panel
				JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(PlayerSquadScreen.this);
				parentWindow.dispose(); // zamknij bieżące okno

				new CoachMenu(coach); // otwórz menu główne ponownie dla tego samego trenera
			}
		});
		add(btngetback);
	}
	

}
