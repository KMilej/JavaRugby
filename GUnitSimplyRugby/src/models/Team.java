package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Team {

	private String id;
	private String name;
	private List<Player> players = new ArrayList<>();

	public Team(String id, String name) {
		this.id = id;
		this.name = name;
		this.players = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public String toString() {
		return name + " (ID: " + id + ")";
	}

}
