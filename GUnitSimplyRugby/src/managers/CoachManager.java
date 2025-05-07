package managers;

import models.Coach;
import models.Team;

import java.util.ArrayList;
import java.util.List;

public class CoachManager {

	private List<Coach> coaches = new ArrayList<>();

	public CoachManager() {
		TeamManager teamManager = new TeamManager(); // lokalnie tworzysz listę drużyn
		populateSampleCoaches(teamManager.getAllTeams());
	}

	private void populateSampleCoaches(List<Team> teams) {
		if (teams.size() >= 3) {
			coaches.add(new Coach("kmilej", "codingishard", "Kamil", "Milej", List.of(teams.get(0))));
			coaches.add(new Coach("amymilej", "pass2", "Amy", "Milej", List.of(teams.get(1))));
			coaches.add(new Coach("Albert", "pass3", "Albert", "Einstein", List.of(teams.get(2))));
		}
	}

//	public Coach authenticate(String username, String password) {
//        for (Coach coach : coaches) {
//            if (coach.getUsername().equalsIgnoreCase(username) && coach.getPassword().equals(password)) {
//                return coach;
//            }
//        }
//        return null;
//    }

	public List<Coach> getAllCoaches() {
		return coaches;    
	}

	public void printAllCoaches() {
		System.out.println("Lista wszystkich trenerów:");

		for (Coach coach : coaches) {
			System.out.println("────────────────────────────");
			System.out.println("Username: " + coach.getUsername());
			System.out.println("Imię: " + coach.getFirstName());
			System.out.println("Nazwisko: " + coach.getSecondName());
			System.out.println("Drużyny: " + coach.getTeams());
		}

		System.out.println("────────────────────────────");
	}
}
