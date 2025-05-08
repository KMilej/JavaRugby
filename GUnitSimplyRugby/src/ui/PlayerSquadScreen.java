package ui;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import managers.SimpleTeamFileManager;
import models.Coach;
import models.Player;
import models.Team;

import javax.swing.JList;

public class PlayerSquadScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable skillsTable;
	private DefaultTableModel skillsTableModel;

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

		JList<Player> playerList = new JList();
		DefaultListModel<Player> playerListModel = new DefaultListModel<>();

		for (Team team : coach.getTeams()) {
			for (Player player : team.getPlayers()) {
				SimpleTeamFileManager.loadSkills(player); // ⬅️ dodaj to tutaj
				playerListModel.addElement(player);
			}
		}

		playerList.setModel(playerListModel);

		String[] columnNames = { "Skill", "Level" };
		skillsTableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 1; // tylko poziomy edytowalne
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
		scrollPane.setBounds(250, 132, 300, 300); // obok listy zawodników
		add(scrollPane);

		// Dodaj nasłuchiwacz, który reaguje na wybór gracza
		playerList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Player selectedPlayer = playerList.getSelectedValue();
					if (selectedPlayer != null) {
						updateSkillsTable(selectedPlayer);
					}
				}
			}
		});

		JButton saveButton = new JButton("Zapisz skille");
		saveButton.setBounds(600, 132, 150, 40);
		saveButton.addActionListener(e -> {
			Player selectedPlayer = playerList.getSelectedValue();
			if (selectedPlayer != null) {
				SimpleTeamFileManager.saveSkills(selectedPlayer);
				JOptionPane.showMessageDialog(null, "Skille zapisane do pliku");
			}
		});
		add(saveButton);

		playerList.setBounds(28, 132, 134, 481);
		add(playerList);

	}

	private void updateSkillsTable(Player player) {
		skillsTableModel.setRowCount(0); // wyczyść starą zawartość

		for (Map.Entry<String, Integer> entry : player.getSkills().entrySet()) {
			skillsTableModel.addRow(new Object[] { entry.getKey(), entry.getValue() });
		}

		// automatyczna aktualizacja danych gracza po edycji (bez zapisu!)
		skillsTable.getModel().addTableModelListener(e -> {
			int row = e.getFirstRow();
			if (row >= 0 && row < skillsTableModel.getRowCount()) {
				String skill = (String) skillsTableModel.getValueAt(row, 0);
				Integer level = (Integer) skillsTableModel.getValueAt(row, 1);
				if (level != null && level >= 1 && level <= 5) {
					player.setSkillLevel(skill, level);
					// ❌ usuń zapis tutaj!
				}
			}
		});
	}

//	private void showPlayerInfoDialog(Player player) {
//		JDialog dialog = new JDialog();
//		dialog.setTitle("Player Info");
//		dialog.setSize(300, 200);
//		dialog.setLocationRelativeTo(null);
//		dialog.setModal(true);
//		dialog.setLayout(null);
//
//		JLabel nameLabel = new JLabel("Name: " + player.getSurname());
//		nameLabel.setBounds(20, 20, 250, 20);
//		dialog.add(nameLabel);
//
//		JLabel addressLabel = new JLabel("Address: " + player.getAddress());
//		addressLabel.setBounds(20, 80, 250, 20);
//		dialog.add(addressLabel);
//
//		dialog.setVisible(true);
//	}

//	private void showSkillsDialog(Player player) {
//		Map<String, Integer> skills = player.getSkills();
//		String[] columnNames = {"Skill", "Level"};
//		Object[][] data = new Object[skills.size()][2];
//
//		int i = 0;
//		for (Map.Entry<String, Integer> entry : skills.entrySet()) {
//			data[i][0] = entry.getKey();
//			data[i][1] = entry.getValue();
//			i++;
//		}
//
//		JTable table = new JTable(data, columnNames);
//		table.setEnabled(false); // tylko do odczytu
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setPreferredSize(new java.awt.Dimension(300, 200));
//
//		JOptionPane.showMessageDialog(null, scrollPane, player.getName() + " " + player.getSurname() + " - Skills", JOptionPane.PLAIN_MESSAGE);
//	}

}
