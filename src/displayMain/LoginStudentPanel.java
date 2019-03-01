package displayMain;

import myJStuff.*;

import java.awt.event.ActionListener;

import javax.swing.JTextArea;
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
	

	/**
	 * Constructor with one argument of ActionListener actionListener.
	 * This constructor will initialize the actionListener and call 
	 * other methods of this class for display.
	 * @param actionListener
	 */
	public LoginStudentPanel (ActionListener actionListener) {
		this.packageListener = actionListener;

		contentPane.setName("Login Student Panel");
		//displaying contents of each panels
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * Method to display content of north panel, which is label.
	 */
	private void displayNorth(){
		lblLogin = new MyLabel("Login", textColor, Size.defaultLblTitleFontSize);
		north.add(lblLogin, "cell 0 0,center");
		
		lblUser = new MyLabel("Student", textColor, Size.defaultLblSubTitleFontSize);
		north.add(lblUser, "cell 0 1,center");
	}
	
	/**
	 * Method to display contents of south panel. This panel contains 
	 * the back button which goes back to main menu.
	 */
	private void displaySouth(){
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		// setting an action for back button
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_LoginStudentPanel");
		
		btnLogin = new MyButton("Login", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnLogin, "cell 1 0, right");
		// setting an action for back button
		btnLogin.addActionListener(packageListener);
		btnLogin.setName("Login_LoginAdminPanel");

	}
	
	/**
	 * Method to display content of center panel. It will set up the text pane.
	 */
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
}
