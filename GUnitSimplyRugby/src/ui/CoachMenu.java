/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: CoachMenu.java
 * Description:
 * Swing window that serves as the main menu for a logged-in coach.
 * It initializes coach and team managers and passes them to the UI screen.
 */

package ui;

import javax.swing.JFrame;

import managers.CoachManager;
import managers.TeamManager;
import models.Coach;

/**
 * Swing JFrame that displays the coach menu screen after login.
 */
public class CoachMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs the CoachMenu window for the logged-in coach.
	 *
	 * @param loggedCoach the authenticated Coach object
	 */
	public CoachMenu(Coach loggedCoach) {
		super("Coach Menu");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 750);
		setLocationRelativeTo(null);

		CoachManager coachManager = new CoachManager();
		TeamManager teamManager = new TeamManager();

		CoachMenuScreen coachScreen = new CoachMenuScreen(coachManager, teamManager, loggedCoach);
		setContentPane(coachScreen);
		setVisible(true);
	}
}
