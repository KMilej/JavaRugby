/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: Team.java
 * Description:
 * Represents a rugby team with an ID, name, and a list of players.
 * Used to group players under specific teams in the system.
 */

package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a rugby team.
 */
public class Team {

    /* PROPERTIES */
    private String id;
    private String name;
    private List<Player> players;

    /* METHODS */

    /**
     * Constructs a Team with a given ID and name.
     *
     * @param id   unique team identifier
     * @param name team name
     */
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

    /**
     * Adds a player to the team.
     *
     * @param player the Player to add
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Returns a string representation of the team.
     *
     * @return team name with ID
     */
    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
