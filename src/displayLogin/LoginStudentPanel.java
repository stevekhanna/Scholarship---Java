package displayLogin;

import myJStuff.*;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginStudentPanel extends MyPanel{
	/**
	 * Instance variables.
	 */	
	//north panel labels
	private JLabel lblLogin;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblUser;
	
	//south panel back button
	private JButton btnBack;
	private JButton btnLogin;

	private JTextField fldUsername;
	private JPasswordField fldPassword;
	
	private ActionListener globalListener;
	

	/**
	 * Constructor with one argument of ActionListener actionListener.
	 * This constructor will initialize the actionListener and call 
	 * other methods of this class for display.
	 * @param actionListener
	 */
	public LoginStudentPanel (ActionListener actionListener, ActionListener globalListener) {
		this.packageListener = actionListener;
		this.globalListener = globalListener;

		contentPane.setName("Login Student Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * displays top part of student log in panel with 2 labels
	 */
	private void displayNorth(){
		lblLogin = new MyLabel("Login", Size.defaultLblTitleFontSize);
		north.add(lblLogin, "cell 0 0,center");
		
		lblUser = new MyLabel("Student", Size.defaultLblSubTitleFontSize);
		north.add(lblUser, "cell 0 1,center");
	}
	/**
	 * displays bottom part of student log in panel with back and login buttons
	 */
	private void displaySouth(){
		btnBack = new MyButton("Back", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_LoginStudentPanel");
		
		btnLogin = new MyButton("Login", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnLogin, "cell 1 0, right");
		btnLogin.addActionListener(globalListener);
		btnLogin.setName("Login_LoginStudentPanel");

	}
	
	/**
	 * displays center part of student log in panel, with textfields for email and password
	 */
	private void displayCenter(){
		
		lblEmail = new MyLabel("Your UofC Email", Size.defaultBtnFontSize);
		center.add(lblEmail, "cell 0 0,center");
		
		fldUsername = new MyTextField("", Size.defaultBtnFontSize);
		center.add(fldUsername, "cell 0 1, center");
		
		lblPassword = new MyLabel("Your Password", Size.defaultBtnFontSize);
		center.add(lblPassword, "cell 0 2,center");
		
		fldPassword = new MyPasswordField("", Size.defaultBtnFontSize);
		center.add(fldPassword, "cell 0 3, center");
	}
	
	public void resetFields() {
		fldUsername.setText("");
		fldPassword.setText("");
	}
	
	/**
	 * get the email from the text field
	 * @return the email string
	 */
	public String getEmail() {
		return fldUsername.getText();
	}
	
	/**
	 * get the password from the text field
	 * @return the password string
	 */
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return fldPassword.getText();
	}
}
