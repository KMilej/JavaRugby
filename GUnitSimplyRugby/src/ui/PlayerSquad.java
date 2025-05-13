/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: PlayerSquad.java
 * Description:
 * JFrame that displays the player squad view for the logged-in coach.
 */

package ui;

import javax.swing.JFrame;
import models.Coach;

/**
 * Main window for displaying the squad of players assigned to a coach.
 */
public class PlayerSquad extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs the PlayerSquad window for the given coach.
     *
     * @param loggedCoach the currently logged-in Coach
     */
    public PlayerSquad(Coach loggedCoach) {
        super("Player Squad");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);

        PlayerSquadScreen playerSquad = new PlayerSquadScreen(loggedCoach, loggedCoach);
        setContentPane(playerSquad);
        setVisible(true);
    }
}
