package managers;

import java.util.ArrayList;
import java.util.List;

import models.Player;
import models.Team;

public class TeamManager {

	private List<Team> allTeamsList;

    public TeamManager() {
        allTeamsList = new ArrayList<>();

        Team team1 = new Team("1", "Simply Rugby Legends");
        Team team2 = new Team("2", "Simply Rugby");
        Team team3 = new Team("3", "SimplyTheBest");

        allTeamsList.add(team1);
        allTeamsList.add(team2);
        allTeamsList.add(team3);
        
        
        Player johnsmith = new Player("John", "Smith", "Wing", "123 Street", "AB12 3cd", 123456, "2001-02-03", 123456789, "john@example.com");
        team1.addPlayer(johnsmith);
    }

    public List<Team> getAllTeams() {
        return allTeamsList;
    }
    
    public Team getTeamById(String id) {
        for (Team team : allTeamsList) {
            if (team.getId().equals(id)) {
                return team;
            }
        }
        return null;
    }

    
    

}
