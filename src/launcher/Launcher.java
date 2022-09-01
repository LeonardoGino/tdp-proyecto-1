package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				Student alumno = new Student(129293, "Leonardo", "Gino", "shinoelonardo@gmail.com",
						"https://github.com/LeonardoGino", "./images/tdp.png");

				SimplePresentationScreen gui = new SimplePresentationScreen(alumno);
				gui.setVisible(true);

			}
		});
	}
}