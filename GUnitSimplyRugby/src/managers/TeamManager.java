/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: TeamManager.java
 * Description:
 * Manages a list of rugby teams and their associated players.
 * Creates sample data including multiple teams and players for testing purposes.
 */

package managers;

import java.util.ArrayList;
import java.util.List;

import models.Player;
import models.Team;

/**
 * Provides logic for managing rugby teams and their players. Pre-populates a
 * sample team with a full squad of players.
 */
public class TeamManager {

	/* PROPERTIES */
	private List<Team> allTeamsList;

	/* METHODS */

	/**
	 * Constructs a TeamManager and initialises sample teams with players.
	 */
	public TeamManager() {
		allTeamsList = new ArrayList<>();

		Team team1 = new Team("1", "Simply Rugby Legends");
		Team team2 = new Team("2", "Simply Rugby");
		Team team3 = new Team("3", "SimplyTheBest");

		allTeamsList.add(team1);
		allTeamsList.add(team2);
		allTeamsList.add(team3);

		// Sample players added to team1
		team1.addPlayer(new Player("Finn", "Russell", "Fly-half", "1 Rugby Street", "EH1 1AA", 700100100, "1992-09-23",
				1001, "finn.russell@example.com"));
		team1.addPlayer(new Player("Blair", "Kinghorn", "Full-back", "2 Rugby Street", "EH2 2BB", 700200200,
				"1997-01-18", 1002, "blair.kinghorn@example.com"));
		team1.addPlayer(new Player("Darcy", "Graham", "Wing", "3 Rugby Street", "EH3 3CC", 700300300, "1997-06-21",
				1003, "darcy.graham@example.com"));
		team1.addPlayer(new Player("Duhan", "van der Merwe", "Wing", "4 Rugby Street", "EH4 4DD", 700400400,
				"1995-06-04", 1004, "duhan.vdm@example.com"));
		team1.addPlayer(new Player("Huw", "Jones", "Centre", "5 Rugby Street", "EH5 5EE", 700500500, "1993-12-17", 1005,
				"huw.jones@example.com"));
		team1.addPlayer(new Player("Sione", "Tuipulotu", "Centre", "6 Rugby Street", "EH6 6FF", 700600600, "1997-02-12",
				1006, "sione.tuipulotu@example.com"));
		team1.addPlayer(new Player("Ben", "White", "Scrum-half", "7 Rugby Street", "EH7 7GG", 700700700, "1998-05-27",
				1007, "ben.white@example.com"));
		team1.addPlayer(new Player("Pierre", "Schoeman", "Prop", "8 Rugby Street", "EH8 8HH", 700800800, "1994-05-07",
				1008, "pierre.schoeman@example.com"));
		team1.addPlayer(new Player("Zander", "Fagerson", "Prop", "9 Rugby Street", "EH9 9II", 700900900, "1996-01-19",
				1009, "zander.fagerson@example.com"));
		team1.addPlayer(new Player("Dave", "Cherry", "Hooker", "10 Rugby Street", "EH10 0JJ", 701000100, "1991-01-03",
				1010, "dave.cherry@example.com"));
		team1.addPlayer(new Player("Grant", "Gilchrist", "Lock", "11 Rugby Street", "EH11 1KK", 701100200, "1990-08-09",
				1011, "grant.gilchrist@example.com"));
		team1.addPlayer(new Player("Jonny", "Gray", "Lock", "12 Rugby Street", "EH12 2LL", 701200300, "1994-03-14",
				1012, "jonny.gray@example.com"));
		team1.addPlayer(new Player("Jamie", "Ritchie", "Flanker", "13 Rugby Street", "EH13 3MM", 701300400,
				"1996-08-16", 1013, "jamie.ritchie@example.com"));
		team1.addPlayer(new Player("Rory", "Darge", "Flanker", "14 Rugby Street", "EH14 4NN", 701400500, "2000-02-23",
				1014, "rory.darge@example.com"));
		team1.addPlayer(new Player("Matt", "Fagerson", "Number 8", "15 Rugby Street", "EH15 5OO", 701500600,
				"1998-07-16", 1015, "matt.fagerson@example.com"));
	}

	/**
	 * Returns all teams managed by this class.
	 *
	 * @return list of Team objects
	 */
	public List<Team> getAllTeams() {
		return allTeamsList;
	}

	/**
	 * Finds a team by its ID.
	 *
	 * @param id the team ID to search for
	 * @return matching Team or null if not found
	 */
	public Team getTeamById(String id) {
		for (Team team : allTeamsList) {
			if (team.getId().equals(id)) {
				return team;
			}
		}
		return null;
	}
}
