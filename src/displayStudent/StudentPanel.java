package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

/**
 * Student Panel class displays a list of scholarships and 
 * the person who is currently logged in 
 * @author Pierce de Jong, Steve Khanna
 *
 */
public class StudentPanel extends MyPanel{
	
	/**
	 * Instance Variables
	 */
	private ActionListener globalListener;
	JLabel lblLoggedin;
	JLabel lblName;
	JLabel lblEmail;
	
	JButton btnBack;
	JButton btnAllScholarships;
	JButton btnAppliedTo;
	JButton btnAccount;
	JButton btnAcceptedTo;
	JButton btnWonScholarships;
	
	/**
	 * Constructor with arguement of ActionListener packageListener
	 * This constructor will initialize the packageListener as well as call upon
	 * the other methods of the class to be displayed
	 * @param packageListener
	 * @param globalListener
	 */
	public StudentPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		contentPane.setName("Student Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	
	/**
	 * Method to display button at the north end of the screen
	 */
	private void displayNorth(){
		lblLoggedin = new MyLabel("Logged in as Student", Size.defaultLblFontSize);
		north.add(lblLoggedin, "cell 0 0,left");
		
		lblName = new MyLabel("Name", Size.defaultLblFontSize);
		north.add(lblName, "cell 0 1,center");
		
		lblEmail = new MyLabel("Email", Size.defaultLblFontSize);
		north.add(lblEmail, "cell 0 2,center");
	}
	
	/**
	 * method displays the options the student can access
	 */
	private void displayCenter() {
		btnAllScholarships = new MyButton("Apply to a  Scholarship", Size.defaultBtnFontSize);
		center.add(btnAllScholarships, "cell 0 0, center");
		btnAllScholarships.addActionListener(packageListener);
		btnAllScholarships.setName("AllScholarships_StudentPanel");
		
		btnAppliedTo = new MyButton("Applied To Scholarships", Size.defaultBtnFontSize, Size.defaultBtnWidth);
		center.add(btnAppliedTo, "cell  0 1, center");
		btnAppliedTo.addActionListener(packageListener);
		btnAppliedTo.setName("AppliedTo_StudentPanel");
		
		btnAcceptedTo = new MyButton("Accepted To Scholarships", Size.defaultBtnFontSize, Size.defaultBtnWidth);
		center.add(btnAcceptedTo, "cell  0 2, center");
		btnAcceptedTo.addActionListener(packageListener);
		btnAcceptedTo.setName("AcceptedTo_StudentPanel");
		
		btnWonScholarships = new MyButton("Won Scholarships", Size.defaultBtnFontSize);
		center.add(btnWonScholarships, "cell 0 3, center");
		btnWonScholarships.addActionListener(packageListener);
		btnWonScholarships.setName("WonScholarships_StudentPanel");
		
		btnAccount = new MyButton("My Account", Size.defaultBtnFontSize);
		center.add(btnAccount, "cell 0 4, center");
		btnAccount.addActionListener(packageListener);
		btnAccount.setName("Account_StudentPanel");
	}
	/**
	 * Method to display button button at the south of the screen
	 */
	private void displaySouth() {
		btnBack = new MyButton("Log out", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(globalListener);
		btnBack.setName("Logout_StudentPanel");
		

	}
	
	public void setName(String name) {
		lblName.setText(name);
	}
	
	public void setEmail(String email) {
		lblEmail.setText(email);
	}
}
