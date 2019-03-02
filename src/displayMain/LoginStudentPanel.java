package displayMain;

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
	//north panel label
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
	
	private void displayNorth(){
		lblLogin = new MyLabel("Login", textColor, Size.defaultLblTitleFontSize);
		north.add(lblLogin, "cell 0 0,center");
		
		lblUser = new MyLabel("Student", textColor, Size.defaultLblSubTitleFontSize);
		north.add(lblUser, "cell 0 1,center");
	}
	
	private void displaySouth(){
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_LoginStudentPanel");
		
		btnLogin = new MyButton("Login", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnLogin, "cell 1 0, right");
		btnLogin.addActionListener(globalListener);
		btnLogin.setName("Login_LoginStudentPanel");

	}
	
	private void displayCenter(){
		
		lblEmail = new MyLabel("Your UofC Email", textColor, Size.defaultBtnFontSize);
		center.add(lblEmail, "cell 0 0");
		
		fldUsername = new MyTextField("", Size.defaultBtnFontSize);
		center.add(fldUsername, "cell 0 1, center");
		
		lblPassword = new MyLabel("Your Password", textColor, Size.defaultBtnFontSize);
		center.add(lblPassword, "cell 0 2");
		
		fldPassword = new MyPasswordField("", Size.defaultBtnFontSize);
		center.add(fldPassword, "cell 0 3, center");
	}
	
	
	public String getEmail() {
		return fldUsername.getText();
	}
	
	public String getPassword() {
		return fldPassword.getText();
	}
}
