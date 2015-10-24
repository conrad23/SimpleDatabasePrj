/**********************************************************************
 * Creates and runs the GUI for student database.
 * 
 * @author Conner Toney
 * @version Winter 2015
 *********************************************************************/
package package1;

import javax.swing.*;

public class GUISimpleDatabase {

	/******************************************************************
	 * The main method in which the GUI is run.
	 *****************************************************************/
	public static void main(String[] args) {
		SimpleDatabasePanel dbPanel = new SimpleDatabasePanel();
		JFrame frame = new JFrame("Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(dbPanel);
		frame.pack();
		frame.setVisible(true);
	}
}