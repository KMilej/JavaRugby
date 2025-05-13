/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: LoginPanel.java
 * Description:
 * JPanel that provides a login screen for coach users.
 * Handles input, validation, and authentication using LoginValidation.
 */

package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import managers.CoachManager;
import models.Coach;
import services.LoginValidation;

/**
 * Login screen for coach authentication.
 */
public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnLogin;

	/**
	 * Constructs the login panel with input fields and validation logic.
	 */
	public LoginPanel() {
		setLayout(null);
		setSize(1000, 750);

		ImageIcon icon;
		if (java.beans.Beans.isDesignTime()) {
			icon = new ImageIcon("src/img/Rugby SImply LOGO.jpg");
		} else {
			icon = new ImageIcon(getClass().getResource("/img/Rugby SImply LOGO.jpg"));
		}

		Image scaledImage = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel logoLabel = new JLabel(scaledIcon);
		logoLabel.setBounds(455, 104, 400, 400);
		add(logoLabel);

		setBackground(new Color(192, 192, 192));
		setOpaque(true);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(169, 139, 100, 25);
		add(lblUsername);

		JTextField txtUsername = new JTextField();
		txtUsername.setBounds(269, 139, 150, 25);
		add(txtUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(169, 188, 100, 25);
		add(lblPassword);

		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(269, 188, 150, 25);
		add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(198, 242, 221, 60);
		add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());

				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(LoginPanel.this, "Please enter both username and password.");
					return;
				}

				CoachManager coachManager = new CoachManager();
				LoginValidation validator = new LoginValidation(coachManager);
				Coach coach = validator.authenticate(username, password);

				if (coach != null) {
					JOptionPane.showMessageDialog(LoginPanel.this, "Welcome, " + coach.getFirstName() + "!");
					SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();
					new CoachMenu(coach);
				} else {
					JOptionPane.showMessageDialog(LoginPanel.this, "Incorrect username or password.");
				}
			}
		});

		JLabel titleLabel = new JLabel("Welcome to SimplyRugby");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
		titleLabel.setForeground(Color.BLUE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(169, 43, 600, 50);
		add(titleLabel);
	}

	/**
	 * Returns the login button (useful for testing or automation).
	 *
	 * @return login button
	 */
	public JButton getLoginButton() {
		return btnLogin;
	}
}
