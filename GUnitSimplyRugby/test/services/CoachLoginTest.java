package services;

import models.Coach;
import managers.CoachManager;
import services.LoginValidation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoachLoginTest {

	@Test
	void testCorrectCredentials() {
		CoachManager manager = new CoachManager();
		LoginValidation validator = new LoginValidation(manager);

		Coach coach = validator.authenticate("kmilej", "codingishard");

		assertNotNull(coach);
		assertEquals("kmilej", coach.getUsername());
	}

	@Test
    void testWrongPassword() {
        CoachManager manager = new CoachManager();
        LoginValidation validator = new LoginValidation(manager);

        Coach coach = validator.authenticate("Kamil", "wrongpass");

        assertNull(coach);
	}
	
	@Test
	void testUnknownUsername() {
		CoachManager manager = new CoachManager();
		LoginValidation validator = new LoginValidation(manager);

		Coach coach = validator.authenticate("", "");

		assertNull(coach);

	}

}
