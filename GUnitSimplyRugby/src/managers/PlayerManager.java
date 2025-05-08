package managers;

import java.util.ArrayList;
import java.util.List;

import models.Player;
import models.Team;

public class PlayerManager {

	private List<Player> allPlayersList = new ArrayList<>();

	public PlayerManager(List<Team> teams) {
		for (Team team : teams) {
			allPlayersList.addAll(team.getPlayers());
		}
	}

	public List<Player> getAllPlayers() {
		return allPlayersList;
	}
}
