package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayScholarship.*;
import objects.*;
import myJStuff.MyController;

public class ScholarshipController extends MyController{
	
	/**
	 * Instance Variables
	 */
	private JPanel viewScholarshipPanel;
	private JPanel allScholarshipsPanel;
	private JPanel editScholarshipPanel;
	private JPanel viewStudentsAppliedPanel;
	
	/**
	 * This is all of the panels that are in the displaySchoalrship
	 */
	private ViewScholarshipPanel vsp;
	private AllScholarshipsPanel asp;
	private EditScholarshipPanel esp;
	private ViewStudentsAppliedPanel vsap;
	
	private List<Student> students;
	/**
	 * HashMap of all of the scholarships
	 */
	private HashMap<Integer, Scholarship> scMap;
	
	private Scholarship currentScholarship;
	
	/**
	 * If the scholarship controller is started as an admin or a student
	 */
	private boolean isAdmin = false;
	
	/**
	 * Constructor
	 * @param globalListener - ActionListener
	 * @param frame - the JFrame
	 */
	public ScholarshipController(ActionListener globalListener,JFrame frame) {
		super(globalListener, frame);
	}
	
	/**
	 * Start the scholarshipController and switch to ViewAllScholarshipsPanel
	 * @param isAdmin - boolean
	 * @param scMap - the HashMap of the scholarships
	 */
	public void start(boolean isAdmin, HashMap<Integer, Scholarship> scMap) {
		this.isAdmin = isAdmin;
		this.scMap = scMap;
		
		// Initialize all of the panels
		vsp = new ViewScholarshipPanel(this,globalListener,this.isAdmin);
		asp = new AllScholarshipsPanel(this,globalListener,this.isAdmin);
		esp = new EditScholarshipPanel(this,globalListener);
		vsap = new ViewStudentsAppliedPanel(this, globalListener);
		
		// Get the content panes
		viewScholarshipPanel = vsp.getContentPane();
		allScholarshipsPanel = asp.getContentPane();
		editScholarshipPanel = esp.getContentPane();
		viewStudentsAppliedPanel = vsap.getContentPane();
		
		// Add all the scholarships to the allScholarshipsPanel
		scholarshipLoop(scMap);
		// Switch the current JPanel
		switchPanel(allScholarshipsPanel);
	}
	
	/**
	 * Set list of students only if admin
	 * @param students
	 */
	public void setStudents(List<Student> students) {
		this.students=students;
		System.out.println(students.get(0).toString());
	}
	
	/**
	 * Loop through the list of scholarships and add them to the screen
	 * @param scMap
	 */
	public void scholarshipLoop(HashMap<Integer, Scholarship> scMap) {
		for(Integer ID: scMap.keySet()) {
			Scholarship value = scMap.get(ID);
			asp.displayScholarship(value);
		}
	}
	
	/**
	 * Find a scholarship by its name
	 * @param name - String
	 * @return - Scholarship
	 */
	private Scholarship searchForScholarship(String name) {
		
		for(Integer ID: scMap.keySet()) {
			if(scMap.get(ID).getName().equalsIgnoreCase(name)) {
				return scMap.get(ID);
			}
		}	
		return null;
	}
	/**
	 * Switch the JPaenl to the ViewScholarshipPanel
	 * @param scholarship - the scholarship to view
	 */
	private void switchToViewScholarshipPanel(Scholarship scholarship) {
		// Display the scholarship
		vsp.displayScholarship(scholarship);
		// IF the current user is an admin display all students that have applied
		switchPanel(viewScholarshipPanel);
	}
	
	private void switchToViewStudentsAppliedPanel(Scholarship scholar) {
		vsap.resetStudents();
		System.out.println(students.get(0).toString());
		for(Student s: students) {
			if(scholar.getStudentsUcids().contains(s.getUCID())) {
				vsap.addStudent(s);
				
			}
		}
		vsap.setScholarship(currentScholarship);
		switchPanel(viewStudentsAppliedPanel);
	}
	
	/**
	 * Get edit panel
	 * Used to get the info for editing a panel
	 * @return - JPanel
	 */
	public EditScholarshipPanel getEdits() {
		return esp;
	}

	/**
	 *  ALl buttons presses in the dispalyScholarship Package that have been given the packageListener actionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the name of the button that was pressed
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		
		switch(name){
		case"ViewScholarship_AllScholarshipsPanel":
			// Get the id of the scholarship to view
			int id = Integer.parseInt(source.getActionCommand());
			// Find the scholarship
			currentScholarship = scMap.get(id);
			switchToViewScholarshipPanel(currentScholarship);
			break;
		case"Back_ViewScholarshipPanel":
			switchPanel(allScholarshipsPanel);
			break;
		case"Back_EditScholarshipPanel":
			switchPanel(allScholarshipsPanel);
			break;
		case "EditScholarship_ViewScholarshipPanel":
			esp.setScholarship(currentScholarship);
			// Switch the panel
			switchPanel(editScholarshipPanel);
			break;
		case "ViewStudentsApplied_ViewScholarshipPanel":
			switchToViewStudentsAppliedPanel(currentScholarship);
			break;
		case "Back_ViewStudentsAppliedTo":
			switchPanel(viewScholarshipPanel);
			break;
		case"Search_AllScholarshipsPanel":
			// Get the text of the search bar
			String x = asp.getSearchResult();
			// Try to find the scholarship
			Scholarship sr = searchForScholarship(x);
			// If the scholarship is not null display the scholarship page
			if(sr != null) {
				switchToViewScholarshipPanel(sr);
				asp.setErrorMessage("");
				asp.setSearchResult("");
			}else {
				//Display label saying could'nt find scholarship
				if(x.equals("")) {
					asp.setErrorMessage("Error, please enter a valid name");
				}else {
					asp.setErrorMessage("Error, could not find scholarship with name " + x);
				}
			}
			break;
		default:
			break;
		}
	}
}
