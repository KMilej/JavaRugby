package managers;

import models.Coach;
import java.util.ArrayList;
import java.util.List;

public class CoachManager {
	
	private List<Coach> coaches = new ArrayList<>();
	
	
	public CoachManager() {
	coaches.add(new Coach("Kamil", "codingishard", "Kamil", "Milej", List.of("T01", "T02")));
	coaches.add(new Coach("Amy", "password1", "Amy", "Milej", List.of("T01")));
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
