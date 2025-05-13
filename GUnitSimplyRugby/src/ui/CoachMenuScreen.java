/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: CoachMenuScreen.java
 * Description:
 * JPanel that displays the main coach menu with navigation buttons.
 * Provides access to teams, coaches, settings, and personal team view.
 */

package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import models.Coach;
import models.Team;
import managers.CoachManager;
import managers.TeamManager;

/**
 * UI panel for the coach menu screen, containing main navigation options.
 */
public class CoachMenuScreen extends JPanel {

    private static final long serialVersionUID = 1L;

    private CoachManager coachManager;
    private TeamManager teamManager;
    private JButton btnMyTeams;

    /**
     * Constructs the CoachMenuScreen UI.
     *
     * @param coachManager the coach manager instance
     * @param teamManager  the team manager instance
     * @param loggedCoach  the currently logged-in coach
     */
    public CoachMenuScreen(CoachManager coachManager, TeamManager teamManager, Coach loggedCoach) {
        this.coachManager = coachManager;
        this.teamManager = teamManager;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Welcome, Coach " + loggedCoach.getFirstName(), SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 150, 30, 150));
        buttonPanel.setBackground(Color.WHITE);

        JButton btnTeamsInClub = createStyledButton("Teams in Club", "img/Teams.png");
        JButton btnActiveCoaches = createStyledButton("Active Coaches", "img/ActiveCoaches.png");
        btnMyTeams = createStyledButton("My Teams", "img/srLogo.jpg");
        JButton btnSettings = createStyledButton("Settings", "img/Settings.png");

        buttonPanel.add(btnTeamsInClub);
        buttonPanel.add(btnActiveCoaches);
        buttonPanel.add(btnMyTeams);
        buttonPanel.add(btnSettings);

        add(buttonPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(Color.RED.darker());
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Arial", Font.BOLD, 16));
        btnExit.setFocusPainted(false);
        btnExit.setPreferredSize(new Dimension(150, 40));
        btnExit.setAlignmentX(CENTER_ALIGNMENT);

        footerPanel.add(btnExit, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // Button Actions
        btnTeamsInClub.addActionListener(e -> showAllTeams());
        btnActiveCoaches.addActionListener(e -> showCoachList());
        btnMyTeams.addActionListener(e -> {
            JFrame currentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
            currentWindow.dispose();
            new MyTeam(loggedCoach);
        });
        btnExit.addActionListener(e -> System.exit(0));
    }

    private JButton createStyledButton(String text, String imagePath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));

        try {
            java.net.URL imageURL = getClass().getResource("/" + imagePath);
            if (imageURL != null) {
                ImageIcon originalIcon = new ImageIcon(imageURL);
                Image scaledImage = originalIcon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                button.setIcon(scaledIcon);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                button.setVerticalTextPosition(SwingConstants.BOTTOM);
            } else {
                System.out.println("Image not found: " + imagePath);
            }
        } catch (Exception e) {
            System.out.println("Error loading image: " + imagePath);
        }

        return button;
    }

    private void showCoachList() {
        List<Coach> coaches = coachManager.getAllCoaches();
        DefaultListModel<String> model = new DefaultListModel<>();

        for (Coach c : coaches) {
            List<String> teamNames = new ArrayList<>();
            for (Team t : c.getTeams()) {
                teamNames.add(t.toString());
            }

            String info = c.getFirstName() + " " + c.getSecondName() +
                    " (Username: " + c.getUsername() + ") - Teams: " + String.join(", ", teamNames);
            model.addElement(info);
        }

        JList<String> list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(400, 250));

        JOptionPane.showMessageDialog(this, scrollPane, "Active Coaches", JOptionPane.PLAIN_MESSAGE);
    }

    private void showAllTeams() {
        List<Team> teams = teamManager.getAllTeams();
        DefaultListModel<String> model = new DefaultListModel<>();

        for (Team t : teams) {
            model.addElement(t.toString());
        }

        JList<String> list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(400, 250));

        JOptionPane.showMessageDialog(this, scrollPane, "All Teams in Club", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Returns the "My Teams" button (can be used for testing or GUI automation).
     *
     * @return the "My Teams" button
     */
    public JButton getMyTeamsButton() {
        return btnMyTeams;
    }
}
