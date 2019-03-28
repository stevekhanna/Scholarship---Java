package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.*;

public class AccountPanel extends MyPanel {
	private JButton btnBack;
	private JButton btnEdit;
	private JLabel lblName;
	private JLabel[][] lblStudent = new JLabel[8][2];


	
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
		
	}
	
	
	public void displayStudent(Student student) {
		lblStudent[0][0] = new MyLabel("UCID:", Size.defaultLblFontSize);
		lblStudent[1][0] = new MyLabel("Name:", Size.defaultLblFontSize);
		lblStudent[2][0] = new MyLabel("Email:", Size.defaultLblFontSize);
		lblStudent[3][0] = new MyLabel("GPA:", Size.defaultLblFontSize);
		lblStudent[4][0] = new MyLabel("Faculty:", Size.defaultLblFontSize);
		lblStudent[5][0] = new MyLabel("Year of Study:", Size.defaultLblFontSize);
		lblStudent[6][0] = new MyLabel("Type of Study:", Size.defaultLblFontSize);
		lblStudent[7][0] = new MyLabel("Department:", Size.defaultLblFontSize);
		
		lblStudent[0][1] = new MyLabel(""+student.getUCID(), Size.defaultLblFontSize);
		lblStudent[1][1] = new MyLabel(student.getName(), Size.defaultLblFontSize);
		lblStudent[2][1] = new MyLabel(student.getEmail(), Size.defaultLblFontSize);
		lblStudent[3][1] = new MyLabel(""+student.getGpa(), Size.defaultLblFontSize);
		lblStudent[4][1] = new MyLabel(student.getFaculty(), Size.defaultLblFontSize);
		lblStudent[5][1] = new MyLabel(""+student.getYearOfStudy(), Size.defaultLblFontSize);
		lblStudent[6][1] = new MyLabel(student.getTypeOfStudy(), Size.defaultLblFontSize);
		lblStudent[7][1] = new MyLabel(student.getDepartment(), Size.defaultLblFontSize);
		for (int i = 0; i<8; i++) {
			center.add(lblStudent[i][0], String.format("cell %d %d, right",0,i));
			center.add(lblStudent[i][1], String.format("cell %d %d, left",1,i));
		}
	}

	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AccountPanel");
		btnEdit = new MyButton("Edit", Size.defaultBtnFontSize);
		south.add(btnEdit, "cell 1 0, right");
		btnEdit.addActionListener(packageListener);
		btnEdit.setName("EditAccount_AccountPanel");
	}
	
	public void setName(String name) {
		lblName.setText(name);
	}
	
}
