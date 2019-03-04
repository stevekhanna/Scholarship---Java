package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayAdmin.*;
import objects.*;

/**
 * Controller used to manage what the admin can do when logged in
 * @author pierce
 *
 */
public class AdminController implements ActionListener {
	
	// Used as a call back to the Controller class to switch between controllers
	private ActionListener globalListener;
	
	//The program frame
	private JFrame frame;
	
	// All of the panels that the controller 
	private AdminPanel ap;
	
	// Current User
	private Admin currentAdmin;
	// List of all of the scholarships
	private HashMap <Integer, Scholarship> scMap;
	
	// Create a JPanel to reference the AdminPanel class
	private JPanel adminPanel;
	
	
	/**
	 * Constructor
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public AdminController(JFrame frame, ActionListener globalListener) {
		this.globalListener = globalListener;
		this.frame = frame;
	}
	
	/**
	 * Method used to switch to this controller
	 * @param currentAdmin - Admin - current user
	 * @param scMap - HashMap<Integer, Scholarship> - list of scholarships
	 */
	public void start(Admin currentAdmin, HashMap<Integer, Scholarship> scMap) {
		this.scMap = scMap;
		this.currentAdmin = currentAdmin;
		ap = new AdminPanel(this, globalListener);
		adminPanel = ap.getContentPane();
		
		switchPanel(adminPanel);

	}
	
	/**
	 * Loop through all of the scholarships and add them to the page
	 * @param scMap
	 */
	public void scholarshipLoop(HashMap<Integer, Scholarship> scMap) {
		for(Integer ID: scMap.keySet()) {
			Scholarship value = scMap.get(ID);
		}
	}

	/**
	 * Switches the current panel
	 * @param panel - JPanel - panel to go to
	 */
	private void switchPanel(JPanel panel){
		System.out.println("SWITCHING: "+panel.getName());
		frame.getContentPane().setVisible(false);
		frame.setContentPane(panel);
		frame.getContentPane().setVisible(true);
	}
	
	@Override
	/**
	 * ActionListener for when a button is pressed that is assigned to the packageController
	 */
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		switch(name) {
		case "":
			break;
		default:
			break;
		}
	}
	

}
