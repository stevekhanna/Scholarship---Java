package displayAdmin;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Student;

public class ViewStudentPanel extends MyPanel{
	
	/**
	 * instance variables
	 */
	private final int NUM_OF_STUDENT_ATTRIBUTES = 7;
	private JLabel lblName;
	private ArrayList<JLabel> lblStudentAttribute = new ArrayList<JLabel>();
	private JButton btnBack;
	
	private JLabel lblScholarshipsTitle;
	private JLabel lblScholarships;
	int row = 0;
	
	/**
	 * class constructor
	 * @param packageListener listener for the panel
	 */
	public ViewStudentPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * displayNorth displays heading of the panel
	 */
	private void displayNorth() {
		lblName = new MyLabel("Student Name", Size.defaultLblSubTitleFontSize);
		north.add(lblName,"cell 0 0, center");
	}
	
	/**
	 * displaySouth displays the back button at the bottom
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack,"cell 0 0, left");
		btnBack.setName("Back_ViewStudentPanel");
		btnBack.addActionListener(packageListener);
	}
	
	/**
	 * displayCenter displays all available attributes of the current student
	 */
	private void displayCenter() {
		String[] studentAttributeName = {"UCID", "Email", "Faculty", "GPA", "Year of Study", "Type of Study", "Department"};
		// Here should be a bunch of labels should be created
		for (int i=0; i<NUM_OF_STUDENT_ATTRIBUTES; i++) {
			lblStudentAttribute.add(new MyLabel("default"));
			center.add(lblStudentAttribute.get(i), String.format("cell 1 %d, left", i));
			JLabel name = new MyLabel(studentAttributeName[i]+": ");
			center.add(name, String.format("cell 0 %d, right", i));
		}
		
		lblScholarshipsTitle = new MyLabel("Scholarships:");
		center.add(lblScholarshipsTitle,"cell 0 8,right");
		
		lblScholarships = new MyLabel("No Scholarships Applied To");
		center.add(lblScholarships,"cell 1 8,left");
		
	}
	
	/**
	 * method set the current student to be displayed with displayCenter
	 * @param student the student to be displayed
	 * @param scholarships the list of scholarships the student has applied to
	 */
	public void setStudent(Student student, String scholarships) {
		// The labels text should be set here.
		lblName.setText(student.getName());
		lblStudentAttribute.get(0).setText(Integer.toString(student.getUCID()));
		lblStudentAttribute.get(1).setText(student.getEmail());
		lblStudentAttribute.get(2).setText(student.getFaculty());
		lblStudentAttribute.get(3).setText(Double.toString(student.getGpa()));
		lblStudentAttribute.get(4).setText(Integer.toString(student.getYearOfStudy()));
		lblStudentAttribute.get(5).setText(student.getTypeOfStudy());
		lblStudentAttribute.get(6).setText(student.getDepartment());
		lblScholarships.setText(scholarships);
	}

}
