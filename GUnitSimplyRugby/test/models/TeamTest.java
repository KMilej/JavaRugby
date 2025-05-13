/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: TeamTest.java
 * Description:
 * Unit tests for verifying Team class logic, including player management.
 */

package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Team class.
 */
class TeamTest {

    /**
     * Tests that players can be added and retrieved from the team.
     */
    @Test
    void testAddAndGetPlayers() {
        Team team = new Team("1", "Test Team");
        Player player = new Player("John", "Doe", "Centre", "123 Street", "EH1 1AA", 123456, "2000-01-01", 123456789, "john@example.com");

        team.addPlayer(player);

        List<Player> players = team.getPlayers();
        assertEquals(1, players.size());
        assertEquals(player, players.get(0));
    }

    /**
     * Tests team ID and name getters.
     */
    @Test
    void testTeamIdAndName() {
        Team team = new Team("99", "Winners United");

        assertEquals("99", team.getId());
        assertEquals("Winners United", team.getName());
    }
}
