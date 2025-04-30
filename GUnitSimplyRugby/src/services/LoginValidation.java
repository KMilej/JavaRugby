package services;

import models.Coach;
import managers.CoachManager;

public class LoginValidation {

	private CoachManager coachManager;

	public LoginValidation(CoachManager coachManager) {
		this.coachManager = coachManager;
	}

	public Coach authenticate(String username, String password) {
		for (Coach coach : coachManager.getAllCoaches()) {
			if (coach.getUsername().equalsIgnoreCase(username) && coach.getPassword().equals(password)) {
				return coach;
			}
		}
		return null;
	}

}
