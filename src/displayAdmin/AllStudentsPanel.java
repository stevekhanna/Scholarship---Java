package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Student;

public class AllStudentsPanel extends MyScrollPanel{
	/**
	 * instance variables
	 */
	private JLabel lblTitle;
	
	private JButton btnBack;
	
	int studentRow;
	
	/**
	 * class constructor
	 * @param packageListener listener for buttons
	 */
	public AllStudentsPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("All Students Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
		
		studentRow = 1;
	}
	
	/**
	 * displayNorth method displays heading of the panel
	 */
	private void displayNorth() {
		lblTitle = new MyLabel("All Students", Size.defaultLblSubTitleFontSize);
		north.add(lblTitle,"cell 0 0, center");
	}
	
	/**
	 * displaySouth method displays bottom of the panel (back button)
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack,"cell 0 0, left");
		btnBack.setName("Back_AllStudentsPanel");
		btnBack.addActionListener(packageListener);
	}
	
	/**
	 * empty method
	 */
	private void displayCenter() {
		JLabel lblName = new MyLabel("UCID", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 0 0,left");
		lblName = new MyLabel("Name", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 1 0");
		lblName = new MyLabel("Account", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 2 0");
	}
	
	/**
	 * addStudent method adds 1 target student to the panel (used for a loop)
	 * @param student the student to be added
	 */
	public void addStudent(Student student) {
		
		JLabel lbl = new MyLabel(Integer.toString(student.getUCID())+"           ");
		center.add(lbl,String.format("cell 0 %d, left", studentRow));
		
		lbl = new MyLabel(student.getName()+"        ");
		center.add(lbl,String.format("cell 1 %d, left", studentRow));
		
		JButton btn = new MyButton("View Account", Size.defaultLblFontSize, Size.defaultBtnEditWidth);
		center.add(btn,String.format("cell 2 %d, left", studentRow));
		btn.setName("ViewStudent_AllStudentsPanel");
		btn.addActionListener(packageListener);
		btn.setActionCommand(Integer.toString(student.getUCID()));
		
		
		studentRow++;
	}

}