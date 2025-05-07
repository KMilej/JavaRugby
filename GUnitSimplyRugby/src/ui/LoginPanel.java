package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import managers.CoachManager;
import models.Coach;
import services.LoginValidation;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	/* CONSTRUCTOR */

	public LoginPanel() {
		setLayout(null); // ← pozwala przeciągać elementy w Design
		setSize(1000, 750); // Ustawia rozmiar okna

		ImageIcon icon;

		if (java.beans.Beans.isDesignTime()) {
			// Działa w Eclipse Design view
			icon = new ImageIcon("src/img/Rugby SImply LOGO.jpg");
		} else {
			// Działa po uruchomieniu aplikacji
			icon = new ImageIcon(getClass().getResource("/img/Rugby SImply LOGO.jpg"));
		}

		Image scaledImage = icon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel logoLabel = new JLabel(scaledIcon);
		logoLabel.setBounds(561, 139, 500, 200);
		add(logoLabel);

		setBackground(new Color(192, 192, 192));
		setOpaque(true);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(302, 177, 100, 25);
		add(lblUsername);

		JTextField txtUsername = new JTextField();
		txtUsername.setBounds(401, 177, 150, 25);
		add(txtUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(302, 228, 100, 25);
		add(lblPassword);

		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(401, 228, 150, 25);
		add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(330, 296, 221, 60);
		add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());

				// validate if empty
				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(LoginPanel.this, "Provide a login and password");
					return;
				}

				CoachManager coachManager = new CoachManager();
				LoginValidation coachValidate = new LoginValidation(coachManager);

				Coach coach = coachValidate.authenticate(username, password);

//				// test
//				CoachManager coachManager = new CoachManager(); 
//				Coach coach = coachManager.authenticate(username, password);

				if (coach != null) {
					JOptionPane.showMessageDialog(LoginPanel.this, "Welcome, " + coach.getFirstName() + "!");

					SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();

					new CoachMenu();

				} else {
					JOptionPane.showMessageDialog(LoginPanel.this, "Wrong login or hasło.");
				}
			}
		});

		JLabel titleLabel = new JLabel("Welcome to SimplyRugby");

		// how main big name will look like
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Nazwa czcionki, styl, rozmiar
		titleLabel.setForeground(Color.BLUE); // Kolor tekstu (opcjonalnie)
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Wyśrodkowanie (w poziomie)
		titleLabel.setBounds(157, 78, 600, 50); // Pozycja i rozmiar

		add(titleLabel); // Dodanie etykiety do panelu lub okna

	}

	public JButton getLoginButton() {
		return btnLogin;
	}

}
