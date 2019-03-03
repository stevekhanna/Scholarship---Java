package displayMain;

import myJStuff.*;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginAdminPanel extends MyPanel{

	private JLabel lblLogin;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblUser;
	
	private JButton btnBack;
	private JButton btnLogin;

	private JTextField fldUsername;
	private JPasswordField fldPassword;
	
	private ActionListener globalListener;
	
	public LoginAdminPanel (ActionListener actionListener, ActionListener globalListener) {
		this.packageListener = actionListener;
		this.globalListener = globalListener;

		contentPane.setName("Login Admin Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	private void displayNorth(){
		lblLogin = new MyLabel("Login", textColor, Size.defaultLblTitleFontSize);
		north.add(lblLogin, "cell 0 0, center");
		
		lblUser = new MyLabel("Admin", textColor, Size.defaultLblSubTitleFontSize);
		north.add(lblUser, "cell 0 1, center");
	}
	
	private void displaySouth(){
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_LoginAdminPanel");
		
		btnLogin = new MyButton("Login", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnLogin, "cell 1 0, right");
		btnLogin.addActionListener(globalListener);
		btnLogin.setName("Login_LoginAdminPanel");

	}
	
	private void displayCenter(){
		
		lblEmail = new MyLabel("Your UofC Email", textColor, Size.defaultBtnFontSize);
		center.add(lblEmail, "cell 0 0, center");
		
		fldUsername = new MyTextField("", Size.defaultBtnFontSize);
		center.add(fldUsername, "cell 0 1, center");
		
		lblPassword = new MyLabel("Your Password", textColor, Size.defaultBtnFontSize);
		center.add(lblPassword, "cell 0 2, center");
		
		fldPassword = new MyPasswordField("", Size.defaultBtnFontSize);
		center.add(fldPassword, "cell 0 3, center");
		
	}
	
	public String getEmail() {
		return fldUsername.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return fldPassword.getText();
	}
}
