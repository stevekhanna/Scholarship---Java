package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import myJStuff.*;
import objects.*;

public class EditAccountPanel extends MyPanel {
	private JButton btnBack;
	private JButton btnFinish;
	private JLabel lblName;
	private JLabel[] lblStudent = new JLabel[8];
	private JTextField[] fldStudent = new JTextField[8];


	
	public EditAccountPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("Account Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}




	private void displayNorth() {
		lblName = new MyLabel("Name", Size.defaultLblFontSize);
		north.add(lblName, "cell 0 1,center");
	}
	
	private void displayCenter() {
		// TODO Auto-generated method stub
		lblStudent[0] = new MyLabel("Update UCID:", Size.defaultLblFontSize);
		lblStudent[1] = new MyLabel("Update name:", Size.defaultLblFontSize);
		lblStudent[2] = new MyLabel("Update email:", Size.defaultLblFontSize);
		lblStudent[3] = new MyLabel("Update GPA:", Size.defaultLblFontSize);
		lblStudent[4] = new MyLabel("Update faculty:", Size.defaultLblFontSize);
		lblStudent[5] = new MyLabel("Update year of Study:", Size.defaultLblFontSize);
		lblStudent[6] = new MyLabel("Update type of Study:", Size.defaultLblFontSize);
		lblStudent[7] = new MyLabel("Update department:", Size.defaultLblFontSize);
		for (int i = 0; i<8; i++) {
			center.add(lblStudent[i], String.format("cell %d %d, right",0,i));
		}
		fldStudent[0] = new JTextField("default", Size.defaultLblFontSize);
		fldStudent[1] = new JTextField("default", Size.defaultLblFontSize);
		fldStudent[2] = new JTextField("default", Size.defaultLblFontSize);
		fldStudent[3] = new JTextField("default", Size.defaultLblFontSize);
		fldStudent[4] = new JTextField("default", Size.defaultLblFontSize);
		fldStudent[5] = new JTextField("default", Size.defaultLblFontSize);
		fldStudent[6] = new JTextField("default", Size.defaultLblFontSize);
		fldStudent[7] = new JTextField("default", Size.defaultLblFontSize);
		for (int i = 0; i<8; i++) {
			center.add(fldStudent[i], String.format("cell %d %d, left",1,i));
		}
	
	}
	
	
	public void displayStudent(Student student) {
		fldStudent[0].setText(""+student.getUCID());
		fldStudent[1].setText(student.getName());
		fldStudent[2].setText(student.getEmail());
		fldStudent[3].setText(""+student.getGpa());
		fldStudent[4].setText(student.getFaculty());
		fldStudent[5].setText(""+student.getYearOfStudy());
		fldStudent[6].setText(student.getTypeOfStudy());
		fldStudent[7].setText(student.getDepartment());

	}
		
		

	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AccountPanel");
		btnFinish = new MyButton("Edit", Size.defaultBtnFontSize);
		south.add(btnFinish, "cell 1 0, right");
		btnFinish.addActionListener(packageListener);
		btnFinish.setName("Finish_AccountPanel");
	}
	
	public void setName(String name) {
		lblName.setText(name);
	}
	
}
