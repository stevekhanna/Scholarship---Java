package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Student;

public class ViewStudentPanel extends MyPanel{
	
	private JLabel lblName;
	
	private JButton btnBack;
	
	int row = 0;
	
	public ViewStudentPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	private void displayNorth() {
		lblName = new MyLabel("Student Name", Size.defaultLblSubTitleFontSize);
		north.add(lblName,"cell 0 0, center");
	}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack,"cell 0 0, left");
		btnBack.setName("Back_ViewStudentPanel");
		btnBack.addActionListener(packageListener);
	}
	
	private void displayCenter() {
		// Here should be a bunch of labels should be created
	}
	
	
	public void setStudent(Student student) {
		// The labels text should be set here.
		lblName.setText(student.getName());
	}

}
