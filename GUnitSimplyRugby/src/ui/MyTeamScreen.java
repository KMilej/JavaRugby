package ui;

import javax.swing.*;
import java.awt.*;

public class MyTeamScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public MyTeamScreen() {
		setLayout(new BorderLayout());

		JLabel label = new JLabel("This is the My Teams Screen", SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 24));

		add(label, BorderLayout.CENTER);
	}
}
