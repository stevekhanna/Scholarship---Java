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
import util.*;

/**
 * Controller used to manage what the student can do when logged in
 * @author pierce
 *
 */
public class StudentController extends MyController {


	private ScholarshipController sController;
	
	
	// List of all of the Panels
	private StudentPanel sp;
	private AppliedPanel ap;
	private AppliedToPanel atp;
	
	private Util util;
	
	// The current user
	private Student currentStudent;
	
	// The Scholarships hash map
	private HashMap <Integer, Scholarship> scMap;
	
	// List of panels
	private JPanel studentPanel;
	private JPanel appliedPanel;
	private JPanel appliedToPanel;
	/**
	 * Constructor
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public StudentController(ActionListener globalListener,JFrame frame) {
		super(globalListener, frame);
		sController = new ScholarshipController(this,frame);

	}
	
	/**
	 * Starts the controller
	 * Switches the screen to the 
	 * @param currentUser - Student
	 * @param scMap - HashMap 
	 */
	public void start(Student currentStudent, HashMap<Integer, Scholarship> scMap, Util util) {
		this.scMap = scMap;
		this.currentStudent = currentStudent;
		this.util = util;
		sp = new StudentPanel(this, globalListener);
		ap = new AppliedPanel(this);
		atp = new AppliedToPanel(this);
		
		studentPanel = sp.getContentPane();
		appliedPanel = ap.getContentPane();
		appliedToPanel = atp.getContentPane();
		
		switchToStudentPanel();
	}
	
	public void switchToStudentPanel() {
		sp.setName(currentStudent.getName());
		sp.setEmail(currentStudent.getEmail());
		switchPanel(studentPanel);
	}
	
	private boolean applyToScholarship(int scholarshipID) {
		Scholarship s = scMap.get(scholarshipID);
		if(currentStudent != null) {
			if(currentStudent.addScholarship(scholarshipID)) { 
				// Should add ucid to the scholarship list of students that have applied	
				if(currentStudent.getGpa()< scMap.get(scholarshipID).getGpaRequirement()) {
					System.out.println(s.getName()+" failed");
					return false;
				}else {
					s.addStudent(currentStudent.getUCID());;
					util.saveStudent(currentStudent);
					util.saveScholarship(s);
					System.out.println(s.getName()+" added to applied");	
					return true;
				}
			}else {
				System.out.println(s.getName()+" failed");
				return false;
			}
		}else {
			return false;
		}
	}
	
	/**
	 * Find all of the scholarships that have the same type of study as the current student
	 * @param studyType - String 
	 * @return HasMap <Integer, Scholarship>
	 */
	private HashMap <Integer, Scholarship> availableScholarships(String studyType){
		HashMap <Integer, Scholarship> map = new HashMap<Integer, Scholarship>();
		
		for(int i=1; i<=scMap.size();i++) {
			if(scMap.get(i).getTypeOfStudy().equals(studyType)) {
				map.put(i, scMap.get(i));
			}
		}
		
		return map;
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
		// Start the scholarship panel and view all of the scholarships
		case"AllScholarships_StudentPanel":
			String study = currentStudent.getTypeOfStudy();
			
			sController.start(false,availableScholarships(study));
			break;
		// Going back from viewing all scholarships to the users main page
		case"Back_AllScholarshipsPanel":
			// Get an updated version of all of the scholarship
			scMap = sController.getScMap();
			// If the current user is a student go to the student controller
			switchToStudentPanel();
			break;
		// When a student hits the apply button in the scholarship controller - ViewScholarshipPanel
		case"Apply_ViewScholarshipPanel":
			// Get the id of the scholarship from the button
			int id = Integer.parseInt(source.getActionCommand());
			// Try to apply the scholarship and display the result to the AppliedPanel
			ap.success(applyToScholarship(id));
			// Switch to the Applied Panel=
			switchPanel(appliedPanel);
			break;
		case"AppliedTo_StudentPanel":
			switchPanel(appliedToPanel);
			break;
		case"Back_AppliedPanel":
			switchToStudentPanel();
			break;
			
		case"Back_AppliedToPanel":
			switchToStudentPanel();
			break;
		default:
			break;
		}
		
	}
	

}
