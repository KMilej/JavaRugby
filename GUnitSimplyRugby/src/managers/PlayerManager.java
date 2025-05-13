/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: PlayerManager.java
 * Description:
 * Manages a list of all players by extracting them from the provided teams.
 * Used for global access to all players in the system.
 */

package managers;

import java.util.ArrayList;
import java.util.List;

import models.Player;
import models.Team;

/**
 * Collects and manages all Player objects from a list of Team instances.
 */
public class PlayerManager {

	/* PROPERTIES */
	private List<Player> allPlayersList = new ArrayList<>();

	/* METHODS */

	/**
	 * Constructs the PlayerManager by collecting players from the given teams.
	 *
	 * @param teams list of Team objects from which to extract players
	 */
	public PlayerManager(List<Team> teams) {
		for (Team team : teams) {
			allPlayersList.addAll(team.getPlayers());
		}
	}

	/**
	 * Returns the complete list of all players.
	 *
	 * @return list of Player objects
	 */
	public List<Player> getAllPlayers() {
		return allPlayersList;
	}
}
