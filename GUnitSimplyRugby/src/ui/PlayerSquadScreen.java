/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: PlayerSquadScreen.java
 * Description:
 * JPanel that displays a list of players and their skills for a coach's team.
 * Allows editing skill levels, saving to file, and returning to the menu.
 */

package ui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import managers.SimpleTeamFileManager;
import models.Coach;
import models.Player;
import models.Team;

import java.awt.*;
import java.util.Map;

/**
 * UI panel for displaying and editing a coach's team and player skills.
 */
public class PlayerSquadScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable skillsTable;
	private DefaultTableModel skillsTableModel;
	private JTextField txtPassing;
	private JTextField txtTrackling;
	private JTextField txtKicking;
	private JList<Player> playerList;
	private DefaultListModel<Player> playerListModel;

	/**
	 * Constructs the player squad screen for the coach.
	 *
	 * @param coach       the coach whose team is shown
	 * @param loggedCoach the logged-in coach
	 */
	public PlayerSquadScreen(Coach coach, Coach loggedCoach) {
		setLayout(null);
		setSize(1000, 750);

		JLabel title = new JLabel("Welcome to Simply Rugby, " + loggedCoach.getFirstName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(308, 29, 600, 40);
		add(title);

		JLabel teamName = new JLabel("Your teams: " + coach.getTeams());
		teamName.setFont(new Font("Arial", Font.BOLD, 20));
		teamName.setBounds(28, 81, 600, 40);
		add(teamName);

		JButton btnBack = new JButton("Back to menu");
		btnBack.setBounds(28, 18, 150, 40);
		btnBack.addActionListener(e -> {
			JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
			parentWindow.dispose();
			new CoachMenu(coach);
		});
		add(btnBack);

		playerList = new JList<>();
		playerListModel = new DefaultListModel<>();

		for (Team team : coach.getTeams()) {
			for (Player player : team.getPlayers()) {
				SimpleTeamFileManager.loadSkills(player);
				playerListModel.addElement(player);
			}
		}

		playerList.setModel(playerListModel);
		playerList.setBounds(28, 132, 134, 481);
		add(playerList);

		String[] columnNames = { "Skill", "Level" };
		skillsTableModel = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 1;
			}

			@Override
			public Class<?> getColumnClass(int column) {
				return column == 1 ? Integer.class : String.class;
			}
		};

		skillsTable = new JTable(skillsTableModel);
		Integer[] allowedLevels = { 1, 2, 3, 4, 5 };
		JComboBox<Integer> levelComboBox = new JComboBox<>(allowedLevels);
		skillsTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(levelComboBox));

		JScrollPane scrollPane = new JScrollPane(skillsTable);
		scrollPane.setBounds(250, 132, 300, 300);
		add(scrollPane);

		skillsTableModel.addTableModelListener(e -> {
			if (e.getType() == TableModelEvent.UPDATE) {
				int row = e.getFirstRow();
				if (row >= 0 && row < skillsTableModel.getRowCount()) {
					String skill = (String) skillsTableModel.getValueAt(row, 0);
					Integer level = (Integer) skillsTableModel.getValueAt(row, 1);
					Player selectedPlayer = playerList.getSelectedValue();
					if (selectedPlayer != null && level != null && level >= 1 && level <= 5) {
						selectedPlayer.setSkillLevel(skill, level);
					}
				}
			}
		});

		playerList.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				Player selectedPlayer = playerList.getSelectedValue();
				if (selectedPlayer != null) {
					updateSkillsTable(selectedPlayer);
				}
			}
		});

		JButton saveButton = new JButton("Save Skills");
		saveButton.setBounds(600, 132, 150, 40);
		saveButton.addActionListener(e -> {
			Player selectedPlayer = playerList.getSelectedValue();
			if (selectedPlayer != null) {
				SimpleTeamFileManager.saveSkills(selectedPlayer);
				JOptionPane.showMessageDialog(null, "Skills saved to file.");
			}
		});
		add(saveButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(600, 386, 150, 40);
		btnExit.addActionListener(e -> {
			int result = JOptionPane.showConfirmDialog(null, "Do you want to save all skills before exiting?",
					"Exit Confirmation", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				for (int i = 0; i < playerListModel.getSize(); i++) {
					Player player = playerListModel.getElementAt(i);
					SimpleTeamFileManager.saveSkills(player);
				}
				JOptionPane.showMessageDialog(null, "All skills have been saved.");
			}

			System.exit(0);
		});
		add(btnExit);

		txtPassing = new JTextField("   PASSING");
		txtPassing.setEditable(false);
		txtPassing.setBounds(175, 161, 65, 51);
		add(txtPassing);

		txtTrackling = new JTextField("  TACKLING");
		txtTrackling.setEditable(false);
		txtTrackling.setBounds(175, 223, 65, 51);
		add(txtTrackling);

		txtKicking = new JTextField("   KICKING");
		txtKicking.setEditable(false);
		txtKicking.setBounds(175, 285, 65, 51);
		add(txtKicking);
	}

	/**
	 * Updates the skill table with data from the selected player.
	 *
	 * @param player the selected Player object
	 */
	private void updateSkillsTable(Player player) {
		skillsTableModel.setRowCount(0);
		for (Map.Entry<String, Integer> entry : player.getSkills().entrySet()) {
			skillsTableModel.addRow(new Object[] { entry.getKey(), entry.getValue() });
		}
	}
}
