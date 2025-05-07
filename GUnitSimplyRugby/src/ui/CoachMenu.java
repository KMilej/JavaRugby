package ui;


import javax.swing.JFrame;

import managers.CoachManager;
import managers.TeamManager;

public class CoachMenu extends JFrame {

    private static final long serialVersionUID = 1l;

    public CoachMenu() {
        super("Coach Menu");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);

        // ✅ Tworzymy obiekt zarządzający trenerami
        
        CoachManager coachManager = new CoachManager();
        TeamManager teamManager = new TeamManager();

        // ✅ Przekazujemy oba do ekranu
        CoachMenuScreen coachScreen = new CoachMenuScreen(coachManager, teamManager);

        setContentPane(coachScreen);
        setVisible(true);
    }
}
