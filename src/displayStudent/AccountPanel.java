package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import myJStuff.*;
import net.miginfocom.swing.MigLayout;
import objects.*;
/**
 * 
 * @author Steve Khanna, Tran Nguyen
 * This is the students account panel 
 *
 */
public class AccountPanel extends MyPanel {
	/**
	 * instance variables
	 */
	private Student student;
	private JButton btnBack;
	private JButton btnPassword;
	private JLabel lblName;
	private JLabel[][] lblStudent = new JLabel[8][2];
	
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	
	private JPasswordField fldPassword;
	private JPasswordField fldConfirmPassword;


	/**
	 * class constructor
	 * @param packageListener listener for panel
	 */
	public AccountPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("Account Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}



	/**
	 * displayNorth displays heading of the panel
	 */
	private void displayNorth() {
		lblName = new MyLabel("Name", Size.defaultLblTitleFontSize);
		north.add(lblName, "cell 0 1,center");
	}
	
	private void displayCenter() {
		// TODO Auto-generated method stub
		//center.setLayout(new MigLayout("", "[]", "[]"));
	}
	
	/**
	 * display account details of current student
	 * with an option to update to new password
	 * @param student
	 */
	public void displayStudent(Student student) {
		center.removeAll();
		center.repaint();
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
		center.add(lblPassword,"cell 0 7, right");
		fldPassword = new MyPasswordField("",Size.defaultLblFontSize);
		center.add(fldPassword, "cell 1 7,span");
		lblConfirmPassword = new MyLabel("Confirm Password",Size.defaultLblFontSize);
		center.add(lblConfirmPassword,"cell 0 8,right");
		fldConfirmPassword = new MyPasswordField("",Size.defaultLblFontSize);
		center.add(fldConfirmPassword, "cell 1 8,span");
		
	}
	
	/**
	 * get the new password
	 * @return the new password as a string
	 */
	public String getNewPassword() {
		return new String(fldPassword.getPassword());
	}
	
	/**
	 * get the new password a second time for confirmation
	 * @return the confirmation string
	 */
	public String getConfirmPassword() {
		return new String(fldConfirmPassword.getPassword());
	}
	
	/**
	 * clear password fields
	 */
	public void resetPasswordFields() {
		fldPassword.setText("");
		fldConfirmPassword.setText("");
	}

	/**
	 * displays the bottom of the panel
	 * with back button and update password button
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AccountPanel");
		btnPassword = new MyButton("Update Password", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnPassword, "cell 1 0, right");
		btnPassword.addActionListener(packageListener);
		btnPassword.setName("UpdatePassword_AccountPanel");
	}
	
	/**
	 * setter for the name of the panel
	 * @param name label text
	 */
	public void setName(String name) {
		lblName.setText(name);
	}
	
}