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
        
        
     // Zakładamy, że klasa Player ma konstruktor:
     // Player(String firstName, String lastName, String position, String address, String postcode, int phoneNumber, String dateOfBirth, int playerID, String email)

     Player player1 = new Player("Finn", "Russell", "Fly-half", "1 Rugby Street", "EH1 1AA", 700100100, "1992-09-23", 1001, "finn.russell@example.com");
     team1.addPlayer(player1);

     Player player2 = new Player("Blair", "Kinghorn", "Full-back", "2 Rugby Street", "EH2 2BB", 700200200, "1997-01-18", 1002, "blair.kinghorn@example.com");
     team1.addPlayer(player2);

     Player player3 = new Player("Darcy", "Graham", "Wing", "3 Rugby Street", "EH3 3CC", 700300300, "1997-06-21", 1003, "darcy.graham@example.com");
     team1.addPlayer(player3);

     Player player4 = new Player("Duhan", "van der Merwe", "Wing", "4 Rugby Street", "EH4 4DD", 700400400, "1995-06-04", 1004, "duhan.vdm@example.com");
     team1.addPlayer(player4);

     Player player5 = new Player("Huw", "Jones", "Centre", "5 Rugby Street", "EH5 5EE", 700500500, "1993-12-17", 1005, "huw.jones@example.com");
     team1.addPlayer(player5);

     Player player6 = new Player("Sione", "Tuipulotu", "Centre", "6 Rugby Street", "EH6 6FF", 700600600, "1997-02-12", 1006, "sione.tuipulotu@example.com");
     team1.addPlayer(player6);

     Player player7 = new Player("Ben", "White", "Scrum-half", "7 Rugby Street", "EH7 7GG", 700700700, "1998-05-27", 1007, "ben.white@example.com");
     team1.addPlayer(player7);

     Player player8 = new Player("Pierre", "Schoeman", "Prop", "8 Rugby Street", "EH8 8HH", 700800800, "1994-05-07", 1008, "pierre.schoeman@example.com");
     team1.addPlayer(player8);

     Player player9 = new Player("Zander", "Fagerson", "Prop", "9 Rugby Street", "EH9 9II", 700900900, "1996-01-19", 1009, "zander.fagerson@example.com");
     team1.addPlayer(player9);

     Player player10 = new Player("Dave", "Cherry", "Hooker", "10 Rugby Street", "EH10 0JJ", 701000100, "1991-01-03", 1010, "dave.cherry@example.com");
     team1.addPlayer(player10);

     Player player11 = new Player("Grant", "Gilchrist", "Lock", "11 Rugby Street", "EH11 1KK", 701100200, "1990-08-09", 1011, "grant.gilchrist@example.com");
     team1.addPlayer(player11);

     Player player12 = new Player("Jonny", "Gray", "Lock", "12 Rugby Street", "EH12 2LL", 701200300, "1994-03-14", 1012, "jonny.gray@example.com");
     team1.addPlayer(player12);

     Player player13 = new Player("Jamie", "Ritchie", "Flanker", "13 Rugby Street", "EH13 3MM", 701300400, "1996-08-16", 1013, "jamie.ritchie@example.com");
     team1.addPlayer(player13);

     Player player14 = new Player("Rory", "Darge", "Flanker", "14 Rugby Street", "EH14 4NN", 701400500, "2000-02-23", 1014, "rory.darge@example.com");
     team1.addPlayer(player14);

     Player player15 = new Player("Matt", "Fagerson", "Number 8", "15 Rugby Street", "EH15 5OO", 701500600, "1998-07-16", 1015, "matt.fagerson@example.com");
     team1.addPlayer(player15);

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
