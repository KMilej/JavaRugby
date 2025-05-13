/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: MyTeamScreen.java
 * Description:
 * JPanel that displays teams assigned to the logged-in coach.
 * Allows navigation back to the coach menu or to the player squad view.
 */

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import models.Coach;
import models.Team;

/**
 * UI panel showing the list of teams assigned to the coach.
 */
public class MyTeamScreen extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs the screen displaying coach-assigned teams.
     *
     * @param coach       the coach whose teams are displayed
     * @param loggedCoach the currently logged-in coach
     */
    public MyTeamScreen(Coach coach, Coach loggedCoach) {
        setLayout(null);
        setSize(1000, 750);

        JLabel title = new JLabel("Teams assigned to you: " + coach.getFirstName());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(300, 20, 400, 30);
        add(title);

        JButton btnBack = new JButton("Back to menu");
        btnBack.setBounds(28, 18, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(MyTeamScreen.this);
                parentWindow.dispose();
                new CoachMenu(coach);
            }
        });
        add(btnBack);

        List<Team> teams = coach.getTeams();
        int y = 140;

        for (Team team : teams) {
            JButton teamButton = new JButton(team.toString());
            teamButton.setBounds(350, y, 300, 40);

            teamButton.addActionListener(e -> {
                JFrame currentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
                currentWindow.dispose();
                new PlayerSquad(loggedCoach);
            });

            add(teamButton);
            y += 60;
        }
    }
}
