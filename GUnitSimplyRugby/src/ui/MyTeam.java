/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: MyTeam.java
 * Description:
 * JFrame that displays the "My Team" view for the logged-in coach.
 */

package ui;

import javax.swing.JFrame;
import models.Coach;

/**
 * Main window for displaying the logged-in coach's team.
 */
public class MyTeam extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs the "My Team" window for the given coach.
	 *
	 * @param coach the logged-in Coach
	 */
	public MyTeam(Coach coach) {
		super("My Team");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 750);
		setLocationRelativeTo(null);

		setContentPane(new MyTeamScreen(coach, coach));

		setVisible(true);
	}
}
