package models;

import java.util.List;

public class Coach {
	
	private String username;
	private String password;
	private String firstName;
	private String secondName;
	private List<Team> teams;
	
	public Coach (String username, String password, String firstName, String secondName, List<Team> teams) {
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
	
	@Override
	public String toString() {
	    return firstName + " " + secondName + " (username: " + username + ")";
	}

	
}
