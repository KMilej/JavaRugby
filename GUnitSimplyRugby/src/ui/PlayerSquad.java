package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import managers.CoachManager;
import managers.TeamManager;
import models.Coach;

public class PlayerSquad extends JFrame {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;


	public PlayerSquad(Coach loggedCoach) {
		super("Player Squad");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);

        PlayerSquadScreen playerSquad = new PlayerSquadScreen(loggedCoach, loggedCoach);
        setContentPane(playerSquad);
        setVisible(true);
        
        
	}

}
