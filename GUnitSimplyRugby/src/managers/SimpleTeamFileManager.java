/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: SimpleTeamFileManager.java
 * Description:
 * Provides basic file operations to save and load a Player's skill data
 * using plain text files. Used for persisting player skills between sessions.
 */

package managers;

import models.Player;

import java.io.*;
import java.util.Map;

/**
 * Handles saving and loading player skills to and from text files.
 */
public class SimpleTeamFileManager {

	private static final String FILE_DIR = "skills/";

	/**
	 * Saves the player's skills to a text file. Each skill is stored in key=value
	 * format.
	 *
	 * @param player the Player whose skills should be saved
	 */
	public static void saveSkills(Player player) {
		try {
			File dir = new File(FILE_DIR);
			if (!dir.exists())
				dir.mkdirs(); // create directory if it doesn't exist

			String fileName = FILE_DIR + "skills_" + player.getName() + "_" + player.getSurname() + ".txt";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
				StringBuilder sb = new StringBuilder();
				for (Map.Entry<String, Integer> entry : player.getSkills().entrySet()) {
					sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
				}
				if (!player.getSkills().isEmpty()) {
					sb.setLength(sb.length() - 1); // remove the trailing comma
				}
				writer.write(sb.toString());
				System.out.println("Saved: " + fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the player's skills from a corresponding text file and populates their
	 * skill map.
	 *
	 * @param player the Player whose skills should be loaded
	 */
	public static void loadSkills(Player player) {
		String fileName = FILE_DIR + "skills_" + player.getName() + "_" + player.getSurname() + ".txt";
		File file = new File(fileName);
		if (!file.exists())
			return; // no file to load

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			if (line != null) {
				String[] skillPairs = line.split(",");
				for (String pair : skillPairs) {
					String[] parts = pair.split("=");
					String skill = parts[0];
					int level = Integer.parseInt(parts[1]);
					player.setSkillLevel(skill, level);
				}
				System.out.println("Loaded skills from: " + fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
