package ui;

import javax.swing.*;
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

	public CoachMenuScreen(CoachManager coachManager, TeamManager teamManager) {
		this.coachManager = coachManager;
		this.teamManager = teamManager;

		setLayout(null);
		setSize(1000, 750);

		JButton btnTeamsInClub = new JButton("Teams in Club");
		btnTeamsInClub.setBounds(40, 101, 150, 45);
		add(btnTeamsInClub);

		btnTeamsInClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAllTeams();
			}
		});

		btnMyTeams = new JButton("My Teams");
		btnMyTeams.setBounds(40, 157, 150, 45);
		add(btnMyTeams);

		btnMyTeams.addActionListener(e -> {
		    new MyTeam(); // to tworzy nowe okno — NIE dodajesz go do obecnego okna!
		});

		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(40, 269, 150, 45);
		add(btnSettings);

		JButton btnActiveCoaches = new JButton("Active Coaches");
		btnActiveCoaches.setBounds(40, 213, 150, 45);
		add(btnActiveCoaches);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(40, 328, 150, 45);
		add(btnExit);

		btnActiveCoaches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCoachList();
			}
		});

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
