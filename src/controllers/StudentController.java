package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayStudent.*;
import myJStuff.MyController;
import objects.*;

/**
 * Controller used to manage what the student can do when logged in
 * @author pierce
 *
 */
public class StudentController extends MyController {

	
	// List of all of the Panels
	private StudentPanel sp;
	private ScholarshipPanel scp;
	
	
	// The current user
	private Student currentStudent;
	
	// The Scholarships hash map
	private HashMap <Integer, Scholarship> scMap;
	
	// List of panels
	private JPanel studentPanel;
	private JPanel scholarshipPanel;
	
	/**
	 * Constructor
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public StudentController(ActionListener globalListener,JFrame frame) {
		super(globalListener, frame);
	}
	
	/**
	 * Starts the controller
	 * Switches the screen to the 
	 * @param currentUser - Student
	 * @param scMap - HashMap 
	 */
	public void start(Student currentStudent, HashMap<Integer, Scholarship> scMap) {
		this.scMap = scMap;
		this.currentStudent = currentStudent;
		sp = new StudentPanel(this, globalListener);
		scp = new ScholarshipPanel(this);
		studentPanel = sp.getContentPane();
		scholarshipPanel = scp.getContentPane();
		
		
		switchPanel(studentPanel);
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
		case "Back_ScholarshipPanel":
			switchPanel(studentPanel);
			break;
		case "":
			switchPanel(scholarshipPanel);
			break;
		default:
			break;
		}
	}
	

}
