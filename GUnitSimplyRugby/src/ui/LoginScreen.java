package ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginScreen {

	/* PROPERTIES */
	private JFrame frame; // aplication window
	private JTextField usernameField;
	private JPasswordField passwordField;

	/* METHODS */
	// method which show first window in SimplyRugby Applicaiton
	public void show() {
		frame = new JFrame("Coach Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("Username:"));
		usernameField = new JTextField();
		panel.add(usernameField);

		panel.add(new JLabel("Password:"));
		passwordField = new JPasswordField();
		panel.add(passwordField);

		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(e -> login());
		panel.add(loginBtn);

		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void login() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		
		IAuthService authService = new AuthService();
	}

}
