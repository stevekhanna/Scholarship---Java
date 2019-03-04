package displayMain;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

public class MainPanel extends MyPanel{
	/**
	 * Instance variables.
	 */	
	//buttons for center panel
	private JButton btnLoginAdmin;
	private JButton btnLoginStudent;
	private JButton btnSignup;
	private JButton btnAbout;
	
	//JLabel that contains background image
	private JLabel lblTitle;
	
	//button for south panel
	private JButton btnTest;
	
	/**
	 * constructor for the main panel, with 1 argument
	 * @param packageListener listener for all buttons
	 */
	public MainPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		
		contentPane.setName("Main Panel");
		//displaying contents of each panels
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * displays top part of main panel, with title
	 */
	private void displayNorth(){
		String title = "U of C Scholarship Program";
		lblTitle = new MyLabel(title, textColor, Size.defaultLblTitleFontSize);
		north.add(lblTitle, "cell 0 0, center");
	}

	/**
	 * empty method
	 */
	private void displaySouth(){
		
	}
	
	
	/**
	 * displays center part of main panel, containing 4 buttons for Admin/Student login, sign up or about
	 */
	private void displayCenter(){
		btnLoginAdmin = new MyButton("Admin Login");
		center.add(btnLoginAdmin, "cell 0 0, center");
		btnLoginAdmin.addActionListener(packageListener);
		btnLoginAdmin.setName("LoginAdmin_MainPanel");
		
		btnLoginStudent = new MyButton("Student Login");
		center.add(btnLoginStudent, "cell 0 1, center");
		btnLoginStudent.addActionListener(packageListener);
		btnLoginStudent.setName("LoginStudent_MainPanel");
		
		btnSignup = new MyButton("Sign up");
		center.add(btnSignup, "cell 0 2, center");
		btnSignup.addActionListener(packageListener);
		btnSignup.setName("Signup_MainPanel");

		btnAbout = new MyButton("About");
		center.add(btnAbout, "cell 0 3, center");
		btnAbout.addActionListener(packageListener);
		btnAbout.setName("About_MainPanel");
		
	}
	/**
	 * Hides the test button
	 */
	public void hideTestButton(){
		btnTest.setVisible(false);
	}
}
