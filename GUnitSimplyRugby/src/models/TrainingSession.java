package models;

import java.time.LocalDate;
import java.util.Map;

public class TrainingSession {
	
    private String id;
    private LocalDate date;
    private String teamId;
    Map<String, String> notesPerPlayer;
}
