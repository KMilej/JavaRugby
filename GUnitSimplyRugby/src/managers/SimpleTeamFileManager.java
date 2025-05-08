package managers;

import models.Player;

import java.io.*;
import java.util.Map;

public class SimpleTeamFileManager {

    private static final String FILE_DIR = "skills/";

    public static void saveSkills(Player player) {
        try {
            File dir = new File(FILE_DIR);
            if (!dir.exists()) dir.mkdirs(); // utwórz folder jeśli nie istnieje

            String fileName = FILE_DIR + "skills_" + player.getName() + "_" + player.getSurname() + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> entry : player.getSkills().entrySet()) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
                }
                if (!player.getSkills().isEmpty()) {
                    sb.setLength(sb.length() - 1); // usuń ostatni przecinek
                }
                writer.write(sb.toString());
                System.out.println("Zapisano: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSkills(Player player) {
        String fileName = FILE_DIR + "skills_" + player.getName() + "_" + player.getSurname() + ".txt";
        File file = new File(fileName);
        if (!file.exists()) return; // jeśli brak pliku – nic nie robimy

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
                System.out.println("Wczytano skille z: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
