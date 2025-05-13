/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: CoachManager.java
 * Description:
 * Manages a list of Coach objects: creates sample data, retrieves, and displays coaches.
 * Used in sports team management logic.
 */

package managers;

import models.Coach;
import models.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages Coach objects including sample data creation, retrieval, and display.
 */
public class CoachManager {

	/* PROPERTIES */
	private List<Coach> coaches = new ArrayList<>();

	/* METHODS */

	/**
	 * Constructor that initialises the list with sample coaches using sample teams.
	 */
	public CoachManager() {
		TeamManager teamManager = new TeamManager(); // Get sample teams
		populateSampleCoaches(teamManager.getAllTeams());
	}

	/**
	 * Populates the coach list with sample data linked to the provided teams.
	 *
	 * @param teams list of Team objects to assign to each coach
	 */
	private void populateSampleCoaches(List<Team> teams) {
		if (teams.size() >= 3) {
			coaches.add(new Coach("kmilej", "codingishard", "Kamil", "Milej", List.of(teams.get(0))));
			coaches.add(new Coach("amymilej", "pass2", "Amy", "Milej", List.of(teams.get(1))));
			coaches.add(new Coach("Albert", "pass3", "Albert", "Einstein", List.of(teams.get(2))));
		}
	}

	/**
	 * Returns all coaches.
	 *
	 * @return list of Coach objects
	 */
	public List<Coach> getAllCoaches() {
		return coaches;
	}

}
