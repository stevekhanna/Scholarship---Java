package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayAdmin.*;
import objects.*;
import util.*;
import myJStuff.MyController;

/**
 * Controller used to manage what the admin can do when logged in
 * @author pierce
 *
 */
public class AdminController extends MyController {
	
	// All of the panels that the controller 
	private AdminPanel ap;
	private AllStudentsPanel asp;
	private ViewStudentPanel vsp;
	
	// Current User
	private Admin currentAdmin;
	// List of all of the scholarships
	private HashMap <Integer, Scholarship> scMap;
	
	private List<Student> students;
	
	// Create a JPanel to reference the AdminPanel class
	private JPanel adminPanel;
	private JPanel allStudentsPanel;
	private JPanel viewStudentPanel;
	
	private ScholarshipController sController;
	
	private Util util;
	
	
	/**
	 * Constructor
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public AdminController(ActionListener globalListener, JFrame frame) {
		super(globalListener, frame);
		
		sController = new ScholarshipController(this,frame);
	}
	
	/**
	 * Method used to switch to this controller
	 * @param currentAdmin - Admin - current user
	 * @param scMap - HashMap<Integer, Scholarship> - list of scholarships
	 */
	public void start(Admin currentAdmin, HashMap<Integer, Scholarship> scMap, List<Student> students, Util util) {
		this.scMap = scMap;
		this.currentAdmin = currentAdmin;
		this.students = students;
		this.util = util;
		ap = new AdminPanel(this, globalListener);
		asp = new AllStudentsPanel(this);
		vsp = new ViewStudentPanel(this);
		
		adminPanel = ap.getContentPane();
		allStudentsPanel = asp.getContentPane();
		viewStudentPanel = vsp.getContentPane();
		
		// Add all of the students to the AllStudentsPanel
		addAllStudents();
		
		switchToAdminPanel();
	}
	
	/**
	 * Set the correct email and name for the current admin
	 * Switch to AdminPanel
	 */
	private void switchToAdminPanel() {
		ap.setName(currentAdmin.getName());
		ap.setEmail(currentAdmin.getEmail());
		switchPanel(adminPanel);
	}
	
	private void switchToViewStudent(int ucid) {
		Student s = findStudentByUcid(ucid);
		String x = scholarshipsAppliedTo(s);
		vsp.setStudent(s,x);
		switchPanel(viewStudentPanel);
	}
	
	/**
	 * Loop through the students and add each one as a row to the AllStudentsPanel
	 * Create a button to view the student and all of the scholarships that student has applied for
	 * 
	 * 	**This should only be called ONCE during the start method and never again**
	 */
	private void addAllStudents() {
		for(Student s: students) {
			asp.addStudent(s);
		}
	}
	
	private String scholarshipsAppliedTo(Student s) {
		String scholarships="";
		
		for(Integer ID: scMap.keySet()) {
			if(scMap.get(ID).getStudentsUcids().contains(s.getUCID())) {
				scholarships+=scMap.get(ID).getName()+", ";
			}
		}
		return scholarships;
	}
	
	private Student findStudentByUcid(int ucid) {
		for(Student s: students) {
			if(s.getUCID() == ucid) {
				return s;
			}
		}
		return null;
	}
	
	private void saveScholarship() {
		
	}
	
	@Override
	/**
	 * ActionListener for when a button is pressed that is assigned to the packageController
	 */
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		
		// Button Name naming convention. Metod/Panel going to_the panel the button is on
		// E.g. TestPanel_HomePanel
		// switch to the TestPanel and the button was pressed on the HomePanel
		switch(name) {
		case "AllStudents_AdminPanel":
			switchPanel(allStudentsPanel);
			break;
		case"ViewStudent_AllStudentsPanel":
			// Get the ucid of the student from the button that was pressed
			int ucid = Integer.parseInt(source.getActionCommand());
			// Find the student and switch to the ViewStudentPanel
			switchToViewStudent(ucid);
			break;
		case "Back_AllStudentsPanel":
			switchPanel(adminPanel);
			break;
		case "Back_ViewStudentPanel":
			switchPanel(allStudentsPanel);
			break;
		case"Back_AllScholarshipsPanel":
			// Get an updated version of all of the scholarship
			scMap = sController.getScMap();
			// If the current user is a student go to the student controller
			switchToAdminPanel();
			break;
		case "AllScholarships_AdminPanel":
			sController.start(true, scMap);
			break;
		case "SaveEdits_EditScholarshipPanel":
			Scholarship s = scMap.get(Integer.parseInt(source.getActionCommand()));
			s.setName(sController.getEdits().getName());
			s.setGpaRequirement(sController.getEdits().getGpa());
			s.setDescription(sController.getEdits().getDescxription());
			util.saveScholarship(s);
			switchToAdminPanel();
			break;
		default:
			break;
		}
	}
	

}
