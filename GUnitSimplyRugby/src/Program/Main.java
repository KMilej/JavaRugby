/*
 * H48W35 Graded Unit 2 – Fife College
 * Author: Kamil Milej | Date: 13.05.2025
 * File: Main.java
 * Description:
 * Entry point of the application. Starts the Program using the Swing event dispatch thread.
 */

package Program;

/**
 * Main class that launches the application.
 */
public class Main {

	/**
	 * Application entry point. Runs the Program inside the Swing event thread.
	 *
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			new Program().start();
		});
	}
}
