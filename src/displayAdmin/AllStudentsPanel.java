package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Student;

public class AllStudentsPanel extends MyPanel{
	
	private JLabel lblTitle;
	
	private JButton btnBack;
	
	public AllStudentsPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	private void displayNorth() {
		lblTitle = new MyLabel("All Students", Size.defaultLblSubTitleFontSize);
		north.add(lblTitle,"cell 0 0, center");
	}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack,"cell 0 0, left");
		btnBack.setName("Back_AllStudentsPanel");
		btnBack.addActionListener(packageListener);
	}
	
	private void displayCenter() {
		
	}
	
	
	public void addStudent(Student student) {
		
	}

}