package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import displayStudent.*;
import myJStuff.Colors;
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
	private AccountPanel acp;
	
	private Util util;
	
	// The current user
	private Student currentStudent;
	
	// The Scholarships hash map
	private HashMap <Integer, Scholarship> scMap;
	
	// List of panels
	private JPanel studentPanel;
	private JPanel appliedPanel;
	private JPanel appliedToPanel;
	private JPanel accountPanel;
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
		acp = new AccountPanel(this);
		atp.setTotalScholarships(currentStudent.getScholarshipsAppliedTo().size());
		
		studentPanel = sp.getContentPane();
		appliedPanel = ap.getContentPane();
		appliedToPanel = atp.getContentPane();
		accountPanel = acp.getContentPane();
		
		addScholarshipsToAppliedPanel();
		switchToStudentPanel();
	}
	
	/**
	 * Add all of the scholarships the student has applied to when logging in
	 */
	private void addScholarshipsToAppliedPanel() {
		int x = 0;
		for(int i: currentStudent.getScholarshipsAppliedTo()) {
			atp.addScholarship(scMap.get(i),x);
			x++;
		}
	}
	
	/**
	 * Update the StudentPanel with the currentStudents info
	 * Switch to the studentPanel
	 */
	private void switchToStudentPanel() {
		sp.setName(currentStudent.getName());
		sp.setEmail(currentStudent.getEmail());
		switchPanel(studentPanel);
	}
	/**
	 * Update the account panel to the current student
	 * Switch to the accountPanel
	 */
	private void switchToAccountPanel() {
		acp.setName(currentStudent.getName());
		acp.displayStudent(currentStudent);
		acp.resetPasswordFields();
		switchPanel(accountPanel);
	}
	
	/**
	 * Apply to a scholarship as a student
	 * Adds the scholarship ID to the students list of scholarship
	 * Add the students UCID to the scholarship d list of students
	 * @param scholarshipID - THE ID of the scholarship to apply to
	 * @return
	 */
	private boolean applyToScholarship(int scholarshipID) {
		Scholarship s = scMap.get(scholarshipID);
		// Make sure current student is not null
		if(currentStudent != null  && s!= null) {
			// Check the student has the correct GPA req for the scholarship
			if (currentStudent.getGpa()>= s.getGpaRequirement()) {
				// Add the scholarship to the current student
				if(currentStudent.addScholarship(scholarshipID)) {
					// Add the Students UCID to the scholarship
					s.addStudent(currentStudent.getUCID());
					// Save the Student to the util file
					util.saveStudent(currentStudent);
					// Save the scholarships to the util file
					util.saveScholarship(s);
					// Add the scholarship to the appliedToPanel
					atp.setTotalScholarships(currentStudent.getScholarshipsAppliedTo().size());
					atp.addScholarship(s, currentStudent.getScholarshipsAppliedTo().size()-1);
					System.out.println(s.getName()+" added to applied");	
					return true;
				}else {
					System.out.println(s.getName()+" failed");
					return false;
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
	 * Updated the priority of a scholarship for the current student
	 * @param sId - The scholarship ID
	 * @param prio - The position you want the scholarships (1-total scholarships)
	 */
	private void updatePriority(int sId, int prio) {
		currentStudent.changeScholarshipPriority(sId, prio-1);
		util.saveStudent(currentStudent);
		atp.resetScholarships();
		addScholarshipsToAppliedPanel();
	}
	
	/**
	 * Withdraw from a scholarship
	 * @param sId
	 */
	private void withdraw(int sId) {
		// Remove the scholarship
		currentStudent.removeScholarship(sId);
		//Remove the student
		scMap.get(sId).removeStudent(currentStudent.getUCID());
		//Save both
		util.saveScholarship(scMap.get(sId));
		util.saveStudent(currentStudent);
		// Reset the panel
		atp.resetScholarships();
		addScholarshipsToAppliedPanel();
		
	}
	
	/**
	 * Find all of the scholarships that have the same type of study as the current student
	 * @param studyType - String 
	 * @return HasMap <Integer, Scholarship>
	 */
	private HashMap <Integer, Scholarship> availableScholarships(String studyType){
		HashMap <Integer, Scholarship> map = new HashMap<Integer, Scholarship>();
		
		for(int i : scMap.keySet()) {
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
		String name="";
		JButton source = new JButton();
		JComboBox sourceBox = new JComboBox();
		try {
			source = (JButton)e.getSource();
			name = source.getName();
		}catch(Exception x){
			try {
				sourceBox = (JComboBox)e.getSource();
				name = sourceBox.getName();
			}catch(Exception c){
				
			}
		}
		switch(name) {
		// Start the scholarship panel and view all of the scholarships
		case"AllScholarships_StudentPanel":
			String study = currentStudent.getTypeOfStudy();
			
			sController.start(false,availableScholarships(study));
			break;
		// Going back from viewing all scholarships to the users main page
		case"Back_AllScholarshipsPanel":
			// Get an updated version of all of the scholarship
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
		case"Account_StudentPanel":
			switchToAccountPanel();
			break;
		case "Back_AccountPanel":
			switchToStudentPanel();
			break;
		case "UpdatePriority_AppliedToPanel":
			int sId = Integer.parseInt(sourceBox.getActionCommand());
			Integer x = (Integer) sourceBox.getSelectedItem();
			updatePriority(sId, x);
			break;
		case "Withdraw_AppliedToPanel":
			Object[] options = { "YES", "NO" };
			UIManager.put("OptionPane.background", Colors.defaultBackgroundColor);
	        UIManager.put("OptionPane.messagebackground", Colors.defaultBackgroundColor);
			int selectedOption = JOptionPane.showOptionDialog(null, "Are you sure you want to withdraw from this scholarship?", "Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
			if(selectedOption == JOptionPane.YES_OPTION) {
				int sID = Integer.parseInt(source.getActionCommand());
				withdraw(sID);
			}
			break;
		case "UpdatePassword_AccountPanel":
			String p = acp.getNewPassword();
			String cp = acp.getConfirmPassword();
			Object[] okOption = { "OK" };
			if(p.equals("") || cp.equals("")) {
				JOptionPane.showOptionDialog(null, "Password field cannot be empty", "Warning",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
						null, okOption, okOption[0]);
			}else if(!p.equals(cp)){
				JOptionPane.showOptionDialog(null, "Passwords do not match", "Warning",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
						null, okOption, okOption[0]);
			}else if(!p.matches("[a-zA-Z0-9]*")){
				JOptionPane.showOptionDialog(null, "Password can only contain letters and numbers", "Warning",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
						null, okOption, okOption[0]);
			}else {
				JOptionPane.showOptionDialog(null, "Your password has successfully been changed", "Success!",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, okOption, okOption[0]);
				currentStudent.setPassword(p);
				util.saveStudent(currentStudent);
				acp.resetPasswordFields();
			}
			break;
		default:
			break;
		}
	}	
}
