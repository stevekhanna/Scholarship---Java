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
	private CreateScholarshipPanel csp;
	
	// Current User
	private Admin currentAdmin;
	// List of all of the scholarships
	private HashMap <Integer, Scholarship> scMap;
	
	private List<Student> students;
	
	// Create a JPanel to reference the AdminPanel class
	private JPanel adminPanel;
	private JPanel allStudentsPanel;
	private JPanel viewStudentPanel;
	private JPanel createScholarshipPanel;
	
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
		csp = new CreateScholarshipPanel(this);
		
		adminPanel = ap.getContentPane();
		allStudentsPanel = asp.getContentPane();
		viewStudentPanel = vsp.getContentPane();
		createScholarshipPanel = csp.getContentPane();
		
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
	
	private void deleteScholarship(Scholarship s) {
		util.deleteScholarship(s);
		scMap.remove(s.getScholarshipId());
		for (int i: s.getStudentsUcids()) {
			for(Student student : students) {
				if (student.getUCID() == i) {
					student.removeScholarship(s.getScholarshipId());
				}
			}
		}
	}
	
	private boolean saveScholarship(Scholarship s) {
		boolean invalid = ((sController.getEdits().getName().isEmpty())||
				(sController.getEdits().getGpa()<=0 ||sController.getEdits().getGpa()>4)||
				(sController.getEdits().getDescription().isEmpty())||
				(sController.getEdits().getFaculty().isEmpty())||
				(sController.getEdits().getDepartment().isEmpty())||
				(sController.getEdits().getYearOfStudy())<=0||
				(sController.getEdits().getTypeOfStudy().isEmpty())||
				(sController.getEdits().getNumAllowed())<=0||
				(sController.getEdits().getMoney())<=0);
		
		if(!invalid){
			s.setName(sController.getEdits().getName());
			s.setGpaRequirement(sController.getEdits().getGpa());
			s.setDescription(sController.getEdits().getDescription());
			s.setFaculty(sController.getEdits().getFaculty());
			s.setDepartment(sController.getEdits().getDepartment());
			s.setYearOfStudy(sController.getEdits().getYearOfStudy());
			s.setTypeOfStudy(sController.getEdits().getTypeOfStudy());
			s.setNumAllowed(sController.getEdits().getNumAllowed());
			s.setMoney(sController.getEdits().getMoney());
			util.saveScholarship(s);
			return true;
		}else{
			return false;
		}
		
		
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
		case "AddScholarship_AdminPanel":
			switchPanel(createScholarshipPanel);
			break;
		case "Create_CreateScholarshipPanel":
			
			// STEVE CREATE THE SCHOLARSHIP ADD IT TO THE MAP AND SAVE IT IN THE UTIL
			// IF IT WORKS START THE CONTROLLER BELOW
			// sController.start(true, scMap);
			// ELSE DO NOTHING FOR NOW AND STAY ON THE CREATE SCREEN
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
		case "DeleteScholarship_AllScholarshipsPanel":
			Scholarship x = scMap.get(Integer.parseInt(source.getActionCommand()));
			deleteScholarship(x);
			switchToAdminPanel();
			break;
		case "Back_ViewStudentPanel":
			switchPanel(allStudentsPanel);
			break;
		case "Back_CreateScholarshipPanel":
			switchToAdminPanel();
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
			if(saveScholarship(s)) {
				switchToAdminPanel();
			}
			break;
		default:
			break;
		}
	}
	

}
