package ui;

import javax.swing.*;


import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import models.Coach;
import models.Team;
import managers.CoachManager;
import managers.TeamManager;

public class CoachMenuScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private CoachManager coachManager;
	private TeamManager teamManager;
	private JButton btnMyTeams;
	private Coach loggedCoach;

	public CoachMenuScreen(CoachManager coachManager, TeamManager teamManager, Coach loggedCoach) {
		this.coachManager = coachManager;
		this.teamManager = teamManager;
		this.loggedCoach = loggedCoach;

		setLayout(null);
		setSize(1000, 750);

		JButton btnTeamsInClub = new JButton("Teams in Club");
		btnTeamsInClub.setBounds(270, 115, 150, 45);
		add(btnTeamsInClub);

		btnTeamsInClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAllTeams();
			}
		});

		btnMyTeams = new JButton("My Teams");
		btnMyTeams.setBounds(270, 214, 150, 45);
		add(btnMyTeams);

		btnMyTeams.addActionListener(e -> {
			JFrame currentWindow = (JFrame) SwingUtilities.getWindowAncestor(this); // znajdź bieżące okno
			currentWindow.dispose(); // zamknij je
			new MyTeam(loggedCoach); // otwórz nowe
		});

		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(487, 214, 150, 45);
		add(btnSettings);

		JButton btnActiveCoaches = new JButton("Active Coaches");
		btnActiveCoaches.setBounds(487, 115, 150, 45);
		add(btnActiveCoaches);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(375, 321, 150, 45);
		add(btnExit);

		btnActiveCoaches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCoachList();
			}
		});

		JLabel title = new JLabel("Welcome in SR Menu: " + loggedCoach.getFirstName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(308, 29, 600, 40); 
		add(title);

		btnExit.addActionListener(e -> System.exit(0));
	}

	private void showCoachList() {
		List<Coach> coaches = coachManager.getAllCoaches();

		DefaultListModel<String> model = new DefaultListModel<>();
		for (Coach c : coaches) {
			List<Team> teams = c.getTeams();
			List<String> teamNames = new ArrayList<>();

			for (Team t : teams) {
				teamNames.add(t.toString()); // lub t.getName() jeśli masz metodę getName()
			}

			String info = c.getFirstName() + " " + c.getSecondName() + " (Username: " + c.getUsername() + ")"
					+ " - Teams: " + String.join(", ", teamNames);
			model.addElement(info);
		}

		JList<String> list = new JList<>(model);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new java.awt.Dimension(400, 250));

		JOptionPane.showMessageDialog(this, scrollPane, "Active Coaches", JOptionPane.PLAIN_MESSAGE);
	}

	private void showAllTeams() {
		List<models.Team> teams = teamManager.getAllTeams();

		DefaultListModel<String> model = new DefaultListModel<>();
		for (models.Team t : teams) {
			model.addElement(t.toString()); // np. "Simply Rugby (ID: 1)"
		}

		JList<String> list = new JList<>(model);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new java.awt.Dimension(400, 250));

		JOptionPane.showMessageDialog(this, scrollPane, "All Teams in Club", JOptionPane.PLAIN_MESSAGE);
	}

	public JButton getMyTeamsButton() {
		return btnMyTeams;
	}

}
