package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import models.Coach;
import models.Team;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyTeamScreen extends JPanel {
	
	
	private Coach loggedCoach;
	

	public MyTeamScreen(Coach coach, Coach loggedCoach) {
		
		this.loggedCoach = loggedCoach;
		
		setLayout(null);
		setSize(1000, 750);

		JLabel title = new JLabel("Teams assigned to you : " + coach.getFirstName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(300, 20, 400, 30); // x, y, szer, wys
		add(title);

		JButton btngetback = new JButton("Back to menu");
		btngetback.setBounds(28, 18, 150, 40);
		btngetback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// znajdź okno, w którym znajduje się ten panel
				JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(MyTeamScreen.this);
				parentWindow.dispose(); // zamknij bieżące okno

				new CoachMenu(coach); // otwórz menu główne ponownie dla tego samego trenera
			}
		});
		add(btngetback);

		List<Team> teams = coach.getTeams();

		int y = 140; // Startowy Y dla przycisków drużyn
		for (Team team : teams) {
			JButton teamButton = new JButton(team.toString());
			teamButton.setBounds(350, y, 300, 40); // x, y, szer, wys

			teamButton.addActionListener(e -> {
				JOptionPane.showMessageDialog(this, "You selected: " + team);

			});

			add(teamButton);
			y += 60; // odstęp między przyciskami
			
			teamButton.addActionListener(e -> {
				JFrame currentWindow = (JFrame) SwingUtilities.getWindowAncestor(this); // znajdź bieżące okno
				currentWindow.dispose(); // zamknij je
				new PlayerSquad(loggedCoach); // otwórz nowe
			});
		}
	}
}
