/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: LoginValidation.java
 * Description:
 * Implements the ILoginValidation interface to authenticate coaches
 * using data from CoachManager.
 */

package services;

import models.Coach;
import interfaces.ILoginValidation;
import managers.CoachManager;

/**
 * Service class for validating coach login credentials.
 */
public class LoginValidation implements ILoginValidation {

	private CoachManager coachManager;

	/**
	 * Constructs a LoginValidation with access to a CoachManager.
	 *
	 * @param coachManager the source of coach data
	 */
	public LoginValidation(CoachManager coachManager) {
		this.coachManager = coachManager;
	}

	/**
	 * Authenticates a coach using a username and password.
	 *
	 * @param username coach's username
	 * @param password coach's password
	 * @return the matching Coach if found, otherwise null
	 */
	@Override
	public Coach authenticate(String username, String password) {
		for (Coach coach : coachManager.getAllCoaches()) {
			if (coach.getUsername().equalsIgnoreCase(username) && coach.getPassword().equals(password)) {
				return coach;
			}
		}
		return null;
	}
}
