/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: Coach.java
 * Description:
 * Represents a coach with login credentials and assigned teams.
 * Used for authentication and team association in the system.
 */

package models;

import java.util.List;

/**
 * Model class representing a coach with login data and assigned teams.
 */
public class Coach {

    /* PROPERTIES */
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private List<Team> teams;

    /* METHODS */

    /**
     * Constructs a Coach object.
     *
     * @param username   login username
     * @param password   login password
     * @param firstName  coach's first name
     * @param secondName coach's last name
     * @param teams      list of teams assigned to the coach
     */
    public Coach(String username, String password, String firstName, String secondName, List<Team> teams) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.teams = teams;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<Team> getTeams() {
        return teams;
    }

    /**
     * Returns a string representation of the coach.
     *
     * @return full name with username
     */
    @Override
    public String toString() {
        return firstName + " " + secondName + " (username: " + username + ")";
    }
}
