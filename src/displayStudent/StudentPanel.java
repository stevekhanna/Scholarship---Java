package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

/**
 * Student Panel class displays a list of scholarships and 
 * ther person who is currently logged in 
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
	JButton btnScholarship;
	
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
		lblLoggedin = new MyLabel("Logged in as Student", textColor, Size.defaultLblFontSize);
		north.add(lblLoggedin, "cell 0 0,left");
	}
	
	private void displayCenter() {
		lblName = new MyLabel("Name", textColor, Size.defaultLblFontSize);
		center.add(lblName, "cell 0 0,center");
		
		lblEmail = new MyLabel("Email", textColor, Size.defaultLblFontSize);
		center.add(lblName, "cell 0 0,center");
	}
	/**
	 * Method to display button button at the south of the screen
	 */
	private void displaySouth() {
		btnBack = new MyButton("Log out", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(globalListener);
		btnBack.setName("Logout_StudentPanel");
		
		btnScholarship = new MyButton("View All Scholarships", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnScholarship, "cell 1 0");
		btnScholarship.addActionListener(packageListener);
		btnScholarship.setName("ViewAllScholarships_StudentPanel");
	}
	
	public void setName(String name) {
		lblName.setText(name);
	}
	
	public void setEmail(String email) {
		lblEmail.setText(email);
	}
}
