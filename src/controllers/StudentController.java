package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import displayScholarship.ViewReadOnlyScholarshipPanel;
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
	private AcceptedToPanel actp;
	private AccountPanel acp;
	private WonScholarshipsPanel wscp;
	private ViewReadOnlyScholarshipPanel vrop;
	
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
	private JPanel acceptedToPanel;
	private JPanel wonScholarshipsPanel;
	private JPanel readOnlyScholarshipPanel;
	
	
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
		actp = new AcceptedToPanel(this);
		wscp = new WonScholarshipsPanel(this);
		vrop = new ViewReadOnlyScholarshipPanel(this);
		atp.setTotalScholarships(currentStudent.getScholarshipsAppliedTo().size());
		
		studentPanel = sp.getContentPane();
		appliedPanel = ap.getContentPane();
		appliedToPanel = atp.getContentPane();
		accountPanel = acp.getContentPane();
		acceptedToPanel = actp.getContentPane();
		wonScholarshipsPanel = wscp.getContentPane();
		readOnlyScholarshipPanel = vrop.getContentPane();
		
		addScholarshipsToAppliedPanel();
		addScholarshipsAcceptedToPanel();
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
	private void addScholarshipsAcceptedToPanel() {
		int x = 0;
		for(int i: currentStudent.getScholarshipsAcceptedTo()) {
			actp.addScholarship(scMap.get(i),x);
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
			// Check if the student has already been accepted or won the scholarship
			if (currentStudent.getScholarshipsAcceptedTo().contains(s.getId()) || Arrays.stream(currentStudent.getScholarshipsWon()).anyMatch(i -> i == scholarshipID)) {
				Object[] canApplyOptions = {"OK"};
				int canApplySelectedOption = JOptionPane.showOptionDialog(null, "Can not apply for scholarships you have been accepted to or already won", "ERROR",
						JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
						null, canApplyOptions, canApplyOptions[0]);
				if(canApplySelectedOption == JOptionPane.YES_OPTION) {
					
				}
				return false;
			// Student has already won 2 scholarships
			}else if(!Arrays.stream(currentStudent.getScholarshipsWon()).anyMatch(i -> i <= 0)) {
				Object[] canApplyOptions = {"OK"};
				int canApplySelectedOption = JOptionPane.showOptionDialog(null, "You have already won two scholarships", "ERROR",
						JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
						null, canApplyOptions, canApplyOptions[0]);
				if(canApplySelectedOption == JOptionPane.YES_OPTION) {
					
				}
				return false;
			// Check if the Scholarship is university wide or only for a specific Faculty
			}else if(s.getFaculty().equals("University")) {
					return addScholarshipToApplied(s);
			// Check if the Scholarship is the same Faculty as the current student
			}else if(s.getFaculty().equals(currentStudent.getFaculty())) {
				if(s.getDepartment().equals("NA") || s.getDepartment().equals(currentStudent.getDepartment())) {
					return addScholarshipToApplied(s);
				}else {
					Object[] canApplyOptions = {"OK"};
					int canApplySelectedOption = JOptionPane.showOptionDialog(null, "You can not apply for scholarships outside of your department", "ERROR",
							JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
							null, canApplyOptions, canApplyOptions[0]);
					if(canApplySelectedOption == JOptionPane.YES_OPTION) {
						
					}
					return false;
				}
			// Can not apply for this scholarship outside of your faculty
			}else {
				Object[] canApplyOptions = {"OK"};
				int canApplySelectedOption = JOptionPane.showOptionDialog(null, "Can not apply for scholarships outside of your faculty", "ERROR",
						JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
						null, canApplyOptions, canApplyOptions[0]);
				if(canApplySelectedOption == JOptionPane.YES_OPTION) {
					
				}
				return false;
			}	
		}else {
			Object[] canApplyOptions = {"OK"};
			int canApplySelectedOption = JOptionPane.showOptionDialog(null, "Error: Could not apply for this scholarship", "ERROR",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
					null, canApplyOptions, canApplyOptions[0]);
			if(canApplySelectedOption == JOptionPane.YES_OPTION) {
				
			}
			return false;
		}
	}
	
	private boolean addScholarshipToApplied(Scholarship s) {
		if(s.getGpaRequirement()<=currentStudent.getGpa()) {
			if(currentStudent.addScholarshipToApplied(s.getId()) & s.addStudentToApplied(currentStudent.getUCID())) {
				// Save the Student to the util file
				util.saveStudent(currentStudent);
				// Save the scholarships to the util file
				util.saveScholarship(s);
				// Add the scholarship to the appliedToPanel
				atp.setTotalScholarships(currentStudent.getScholarshipsAppliedTo().size());
				atp.addScholarship(s, currentStudent.getScholarshipsAppliedTo().size()-1);
				System.out.println(s.getName()+" added to applied");
				Object[] canApplyOptions = {"OK"};
				int canApplySelectedOption = JOptionPane.showOptionDialog(null, "You have successfully applied for this scholarship", "SUCCESS",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, canApplyOptions, canApplyOptions[0]);
				if(canApplySelectedOption == JOptionPane.YES_OPTION) {
					
				}
				return true;
			}else {
				Object[] canApplyOptions = {"OK"};
				int canApplySelectedOption = JOptionPane.showOptionDialog(null, "You have already applied to this scholarship", "ERROR",
						JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
						null, canApplyOptions, canApplyOptions[0]);
				if(canApplySelectedOption == JOptionPane.YES_OPTION) {
					
				}
				return false;
			}
		}else {
			Object[] canApplyOptions = {"OK"};
			int canApplySelectedOption = JOptionPane.showOptionDialog(null, "Your GPA is not high enough to apply for this scholarship", "ERROR",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
					null, canApplyOptions, canApplyOptions[0]);
			if(canApplySelectedOption == JOptionPane.YES_OPTION) {
				
			}
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
		scMap.get(sId).removeStudentFromApplied(currentStudent.getUCID());
		//Save both
		util.saveScholarship(scMap.get(sId));
		util.saveStudent(currentStudent);
		// Reset the panel
		atp.resetScholarships();
		addScholarshipsToAppliedPanel();
		
	}
	private void accept(int sId) {
		if(currentStudent.addToWon(sId)) {
			scMap.get(sId).addStudentToWon(currentStudent.getUCID());
		}
		currentStudent.removeScholarship(sId);
		scMap.get(sId).removeStudentFromAccepted(currentStudent.getUCID());
		util.saveScholarship(scMap.get(sId));
		util.saveStudent(currentStudent);
		actp.resetScholarships();
		addScholarshipsAcceptedToPanel();
		
	}
	private void decline(int sId) {
		currentStudent.removeScholarshipFromAccept(sId);
		scMap.get(sId).removeStudentFromAccepted(currentStudent.getUCID());
		util.saveScholarship(scMap.get(sId));
		util.saveStudent(currentStudent);
		actp.resetScholarships();
		addScholarshipsAcceptedToPanel();
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
	 * ActionListener that does something when a button is pressed that is assigned to this action listener
	 * Any buttons that are assigned to the package listener
	 */
	public void actionPerformed(ActionEvent e) {
		String name="";
		JButton source = new JButton();
		JComboBox<Object> sourceBox = new JComboBox<Object>();
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

			
			if (applyToScholarship(id)) {
				switchPanel(appliedToPanel);
			}else {
				sController.switchToViewScholarshipPanel(scMap.get(id));
			}
			// Switch to the Applied Panel=
			
			break;
		case"AcceptedTo_StudentPanel":
			switchPanel(acceptedToPanel);
			break;
		case"Back_AcceptedToPanel":
			switchToStudentPanel();
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
			int selectedOption = JOptionPane.showOptionDialog(null, "Are you sure you want to withdraw from this scholarship?", "Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
			if(selectedOption == JOptionPane.YES_OPTION) {
				int sID = Integer.parseInt(source.getActionCommand());
				withdraw(sID);
			}
			break;
		case "Accept_AcceptedToPanel":
			Object[] acceptOptions = { "YES", "NO" };
			int accSelectedOption = JOptionPane.showOptionDialog(null, "Are you sure you want to accept this scholarship?", "Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, acceptOptions, acceptOptions[0]);
			if(accSelectedOption == JOptionPane.YES_OPTION) {
				int sID = Integer.parseInt(source.getActionCommand());
				accept(sID);
			}
			break;
		case "Decline_AcceptedToPanel":
			Object[] declineOptions = { "YES", "NO" };
			int decSelectedOption = JOptionPane.showOptionDialog(null, "Are you sure you want to decline this scholarship?", "Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, declineOptions, declineOptions[0]);
			if(decSelectedOption == JOptionPane.YES_OPTION) {
				int sID = Integer.parseInt(source.getActionCommand());
				decline(sID);
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
		case "WonScholarships_StudentPanel":
			wscp.resetScholarships();
			boolean j = false;
			for(int i = 0; i< 2; i ++) {
				if(currentStudent.getScholarshipsWon()[i]>0 ) {
					wscp.addScholarship(scMap.get(currentStudent.getScholarshipsWon()[i]));
					j = true;
				}
			}
			if (j) {
				switchPanel(wonScholarshipsPanel);
			} else {
				Object[] noScholarshipsWon = { "OK" };
				int nsw = JOptionPane.showOptionDialog(null, "No scholarships won", "Error",
						JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
						null, noScholarshipsWon, noScholarshipsWon[0]);
				if(nsw == JOptionPane.YES_OPTION) {
				}
			}
			break;
		case "Back_WonScholarshipsPanel":
			switchToStudentPanel();
			break;
		case "ViewReadOnly_WonScholarshipPanel":
			int sid = Integer.parseInt(source.getActionCommand());
			Scholarship scholarship = scMap.get(sid);
			vrop.displayScholarship(scholarship);
			switchPanel(readOnlyScholarshipPanel);
			break;
		case "Back_ViewReadOnlyScholarshipPanel":
			switchToStudentPanel();
			break;
		default:
			break;
		}
	}	
}
