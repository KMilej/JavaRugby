/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: Player.java
 * Description:
 * Represents a rugby player, including personal details, medical info, and skill levels.
 * Used to track and manage individual player data in the system.
 */

package models;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Model class representing a rugby player with personal info and skill ratings.
 */
public class Player {

    /* PROPERTIES */
    private String name;
    private String surname;
    private String fieldPosition;
    private String address;
    private String postcode;
    private int sruNumber;
    private String dateOfBirth;
    private int phoneNumber;
    private String email;
    private String doctor;
    private String doctorPhoneNumber;

    private Map<String, Integer> skills = new LinkedHashMap<>();

    /* METHODS */

    /**
     * Constructs a Player without medical info.
     */
    public Player(String name, String surname, String fieldPosition, String address, String postcode, int sruNumber,
                  String dateOfBirth, int phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.fieldPosition = fieldPosition;
        this.address = address;
        this.postcode = postcode;
        this.sruNumber = sruNumber;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        initializeSkills();
    }

    /**
     * Constructs a Player with medical info.
     */
    public Player(String name, String surname, String fieldPosition, String address, String postcode, int sruNumber,
                  String dateOfBirth, int phoneNumber, String email, String doctor, String doctorPhoneNumber) {
        this.name = name;
        this.surname = surname;
        this.fieldPosition = fieldPosition;
        this.address = address;
        this.postcode = postcode;
        this.sruNumber = sruNumber;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.doctor = doctor;
        this.doctorPhoneNumber = doctorPhoneNumber;
        initializeSkills();
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSruNumber() {
        return sruNumber;
    }

    public void setSruNumber(int sruNumber) {
        this.sruNumber = sruNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a map of the player's skill ratings.
     *
     * @return map of skill name to skill level
     */
    public Map<String, Integer> getSkills() {
        return skills;
    }

    /**
     * Sets a skill level if skill exists and level is between 1 and 5.
     *
     * @param skill skill name
     * @param level level from 1 to 5
     */
    public void setSkillLevel(String skill, int level) {
        if (skills.containsKey(skill) && level >= 1 && level <= 5) {
            skills.put(skill, level);
        }
    }

    /**
     * Returns the player's full name and position.
     */
    @Override
    public String toString() {
        return name + " " + surname + " - " + fieldPosition;
    }

    /**
     * Initialises the player's skills with default level 1.
     */
    private void initializeSkills() {
        skills.put("Standard", 1);
        skills.put("Spin", 1);
        skills.put("Pop", 1);
        skills.put("Front", 1);
        skills.put("Rear", 1);
        skills.put("Side", 1);
        skills.put("Scrabble", 1);
        skills.put("Drop", 1);
        skills.put("Punt", 1);
        skills.put("Grubber", 1);
        skills.put("Goal", 1);
    }
}
