package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import myJStuff.*;
import net.miginfocom.swing.MigLayout;
import objects.*;

public class AccountPanel extends MyPanel {
	private Student student;
	private JButton btnBack;
	private JButton btnPassword;
	private JLabel lblName;
	private JLabel[][] lblStudent = new JLabel[8][2];
	
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	
	private JPasswordField fldPassword;
	private JPasswordField fldConfirmPassword;


	
	public AccountPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("Account Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}




	private void displayNorth() {
		lblName = new MyLabel("Name", Size.defaultLblTitleFontSize);
		north.add(lblName, "cell 0 1,center");
	}
	
	private void displayCenter() {
		// TODO Auto-generated method stub
		center.setLayout(new MigLayout("", "[]", "[]"));
	}
	
	
	public void displayStudent(Student student) {
		lblStudent[0][0] = new MyLabel("UCID:", Size.defaultLblFontSize);
		lblStudent[1][0] = new MyLabel("Email:", Size.defaultLblFontSize);
		lblStudent[2][0] = new MyLabel("GPA:", Size.defaultLblFontSize);
		lblStudent[3][0] = new MyLabel("Faculty:", Size.defaultLblFontSize);
		lblStudent[4][0] = new MyLabel("Year of Study:", Size.defaultLblFontSize);
		lblStudent[5][0] = new MyLabel("Type of Study:", Size.defaultLblFontSize);
		lblStudent[6][0] = new MyLabel("Department:", Size.defaultLblFontSize);
		lblStudent[0][1] = new MyLabel(""+student.getUCID(), Size.defaultLblFontSize);
		lblStudent[1][1] = new MyLabel(student.getEmail(), Size.defaultLblFontSize);
		lblStudent[2][1] = new MyLabel(""+student.getGpa(), Size.defaultLblFontSize);
		lblStudent[3][1] = new MyLabel(student.getFaculty(), Size.defaultLblFontSize);
		lblStudent[4][1] = new MyLabel(""+student.getYearOfStudy(), Size.defaultLblFontSize);
		lblStudent[5][1] = new MyLabel(student.getTypeOfStudy(), Size.defaultLblFontSize);
		lblStudent[6][1] = new MyLabel(student.getDepartment(), Size.defaultLblFontSize);
		for (int i = 0; i<7; i++) {
			center.add(lblStudent[i][0], String.format("cell %d %d, right",0,i));
			center.add(lblStudent[i][1], String.format("cell %d %d, left",1,i));
		}
		
		lblPassword = new MyLabel("New Password",Size.defaultLblFontSize);
		center.add(lblPassword,"cell 0 7");
		fldPassword = new MyPasswordField("",Size.defaultLblFontSize);
		center.add(fldPassword, "cell 1 7,span");
		lblConfirmPassword = new MyLabel("Confirm Password",Size.defaultLblFontSize);
		center.add(lblConfirmPassword,"cell 0 8");
		fldConfirmPassword = new MyPasswordField("",Size.defaultLblFontSize);
		center.add(fldConfirmPassword, "cell 1 8,span");
		
	}
	
	public String getNewPassword() {
		return fldPassword.getText();
	}
	
	public String getConfirmPassword() {
		return fldConfirmPassword.getText();
	}
	
	public void resetPasswordFileds() {
		fldPassword.setText("");
		fldConfirmPassword.setText("");
	}

	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AccountPanel");
		btnPassword = new MyButton("Update Password", Size.defaultBtnFontSize);
		south.add(btnPassword, "cell 1 0, right");
		btnPassword.addActionListener(packageListener);
		btnPassword.setName("UpdatePassword_AccountPanel");
	}
	
	public void setName(String name) {
		lblName.setText(name);
	}
	
}
