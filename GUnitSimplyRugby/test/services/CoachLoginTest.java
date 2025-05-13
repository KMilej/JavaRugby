/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: CoachLoginTest.java
 * Description:
 * Unit tests for validating the login process of coaches
 * using the LoginValidation service and CoachManager data.
 */

package services;

import models.Coach;
import managers.CoachManager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for coach login functionality.
 */
class CoachLoginTest {

    /**
     * Tests login with correct username and password.
     */
    @Test
    void testCorrectCredentials() {
        CoachManager manager = new CoachManager();
        LoginValidation validator = new LoginValidation(manager);

        Coach coach = validator.authenticate("kmilej", "codingishard");

        assertNotNull(coach);
        assertEquals("kmilej", coach.getUsername());
    }

    /**
     * Tests login with valid username but incorrect password.
     */
    @Test
    void testWrongPassword() {
        CoachManager manager = new CoachManager();
        LoginValidation validator = new LoginValidation(manager);

        Coach coach = validator.authenticate("Kamil", "wrongpass");

        assertNull(coach);
    }

    /**
     * Tests login with empty credentials.
     */
    @Test
    void testUnknownUsername() {
        CoachManager manager = new CoachManager();
        LoginValidation validator = new LoginValidation(manager);

        Coach coach = validator.authenticate("", "");

        assertNull(coach);
    }
}
