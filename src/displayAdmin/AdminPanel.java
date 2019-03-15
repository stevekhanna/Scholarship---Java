package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
/**
 * Admin panel displays all admin related stuff
 * @author stevekhanna
 *
 */
public class AdminPanel extends MyPanel{
	
	/**
	 * Instance Vars.
	 */
	private ActionListener globalListener;
	
	private JLabel lblLoggedin;
	
	private JLabel lblName;
	private JLabel lblEmail;
	
	private JButton btnBack;
	private JButton btnScholarship;
	
	private JButton btnStudents;
	
	/**
	 * Admin Panel constructor
	 * @param packageListener
	 * @param globalListener
	 */
	public AdminPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		contentPane.setName("Admin Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	/**
	 * displayNorth method displays button at the north end of the screen
	 */
	private void displayNorth(){
		lblLoggedin = new MyLabel("Logged in as Admin", Size.defaultLblFontSize);
		north.add(lblLoggedin, "cell 0 0,left");
		
		lblName = new MyLabel("Name", Size.defaultLblFontSize);
		north.add(lblName, "cell 0 1,center");
		
		lblEmail = new MyLabel("Email", Size.defaultLblFontSize);
		north.add(lblEmail, "cell 0 2,center");
	}
	
	private void displayCenter() {
		btnScholarship = new MyButton("View All Scholarships", Size.defaultBtnFontSize);
		center.add(btnScholarship, "cell 0 0, center");
		btnScholarship.addActionListener(packageListener);
		btnScholarship.setName("AllScholarships_AdminPanel");
		
		btnStudents = new MyButton("View All Students", Size.defaultBtnFontSize);
		center.add(btnStudents,"cell 0 1, center");
		btnStudents.addActionListener(packageListener);
		btnStudents.setName("AllStudents_AdminPanel");
	}
	
	/**
	 * displaySouth method displays button at the south end of the screen
	 */
	private void displaySouth() {
		btnBack = new MyButton("Log out", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(globalListener);
		btnBack.setName("Logout_AdminPanel");
		
	
	}
	
	public void setName(String name) {
		lblName.setText(name);
	}
	
	public void setEmail(String email) {
		lblEmail.setText(email);
	}
}
