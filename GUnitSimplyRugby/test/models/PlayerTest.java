/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: PlayerTest.java
 * Description:
 * Unit tests for verifying the Player class logic, including skill management.
 */

package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Player class.
 */
class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("John", "Doe", "Wing", "123 Street", "EH1 1AA", 123456, "2000-01-01", 123456789, "john@example.com");
    }

    /**
     * Tests that default skills are initialized with level 1.
     */
    @Test
    void testDefaultSkillsInitialized() {
        Map<String, Integer> skills = player.getSkills();
        assertEquals(11, skills.size()); // 11 skills expected
        skills.forEach((skill, level) -> assertEquals(1, level));
    }

    /**
     * Tests setting a skill level within valid range.
     */
    @Test
    void testSetValidSkillLevel() {
        player.setSkillLevel("Drop", 4);
        assertEquals(4, player.getSkills().get("Drop"));
    }

    /**
     * Tests setting a skill level outside valid range (should be ignored).
     */
    @Test
    void testSetInvalidSkillLevel() {
        player.setSkillLevel("Drop", 7);
        assertEquals(1, player.getSkills().get("Drop")); // should remain unchanged
    }

    /**
     * Tests setting skill for a nonexistent skill (should not crash).
     */
    @Test
    void testSetSkillForNonexistentSkill() {
        assertDoesNotThrow(() -> player.setSkillLevel("UnrealSkill", 3));
    }
}
