package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayStudent.*;
import objects.*;

/**
 * Controller used to manage what the student can do when logged in
 * @author pierce
 *
 */
public class StudentController implements ActionListener {
	
	
	// Used as a call back to the Controller class to switch between controllers
	private ActionListener globalListener;
	
	//The program frame
	private JFrame frame;
	
	// List of all of the Panels
	private StudentPanel sp;
	
	
	// The current user
	private Student currentStudent;
	
	// The Scholarships hash map
	private HashMap <Integer, Scholarship> scMap;
	
	// List of panels
	private JPanel studentPanel;
	
	/**
	 * Constructor
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public StudentController(JFrame frame, ActionListener globalListener) {
		this.globalListener = globalListener;
		this.frame = frame;
	}
	
	/**
	 * Starts the controller
	 * Switches the screen to the 
	 * @param currentUser - Student
	 * @param scMap - HashMap 
	 */
	public void start(Student currentUser, HashMap<Integer, Scholarship> scMap) {
		this.scMap = scMap;
		this.currentStudent = currentStudent;
		sp = new StudentPanel(this, globalListener);
		studentPanel = sp.getContentPane();
		
		
		switchPanel(studentPanel);
		scholarshipLoop(scMap);
	}
	/**
	 * Loop through the list of scholarships and add them to the screen
	 * @param scMap
	 */
	public void scholarshipLoop(HashMap<Integer, Scholarship> scMap) {
		for(Integer ID: scMap.keySet()) {
			Scholarship value = scMap.get(ID);
			sp.displayScholarship(value);
			
		}
	}

	/**
	 * Switch the current panel
	 * @param panel - JPanel
	 */
	private void switchPanel(JPanel panel){
		System.out.println("SWITCHING: "+panel.getName());
		frame.getContentPane().setVisible(false);
		frame.setContentPane(panel);
		frame.getContentPane().setVisible(true);
	}
	@Override
	/**
	 * ActionListener that does something when a button is pressed that is assigned top this action listener
	 * Any buttons that are assigned to the package listener
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
