package displayScholarship;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.Colors;
import myJStuff.MyButton;
import myJStuff.MyLabel;
import myJStuff.MyPanel;
import myJStuff.Size;
import objects.*;

public class ViewStudentsAcceptedPanel extends MyPanel{
	/**
	 * instance variables
	 */
	private JLabel lblTitle;
	private JLabel lblSubTitle;
	
	private JButton btnBack;
	
	private ActionListener globalListener;
	
	private Scholarship scholarship;
	
	int studentRow;
	
	/**
	 * class constructor
	 * @param packageListener listener for buttons
	 */
	public ViewStudentsAcceptedPanel(ActionListener packageListener, ActionListener globalListener) {
		contentPane.setName("View Students Accepted Panel");
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		
		displayNorth();
		displaySouth();
		displayCenter();
		
		studentRow = 1;
	}
	
	/**
	 * displayNorth method displays heading of the panel
	 */
	private void displayNorth() {
		lblTitle = new MyLabel("Scholarship Name", Size.defaultLblSubTitleFontSize);
		north.add(lblTitle,"cell 0 0, center");
		
		lblSubTitle = new MyLabel("Students that have been accepted", Size.defaultLblFontSize);
		north.add(lblSubTitle,"cell 0 1, center");
	}
	
	/**
	 * displaySouth method displays bottom of the panel (back button)
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnBack,"cell 0 0, left");
		btnBack.setName("Back_ViewStudentsAppliedPanel");
		btnBack.addActionListener(packageListener);
	}
	
	/**
	 * empty method
	 */
	private void displayCenter() {
		JLabel lblName = new MyLabel("Name", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 0 0");
		lblName = new MyLabel("GPA ", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 1 0");
		lblName = new MyLabel("Faculty", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 2 0");
		lblName = new MyLabel("Department", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 3 0");
		lblName = new MyLabel("Priority", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 4 0");
		lblName = new MyLabel("Accept Student", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 5 0");
	}
	
	/**
	 * addStudent method adds 1 target student to the panel (used for a loop)
	 * @param student the student to be added
	 */
	public void addStudent(Student student) {
		JLabel lbl = new MyLabel(student.getName());
		center.add(lbl,String.format("cell 0 %d, left", studentRow));
		
		lbl = new MyLabel(Integer.toString(student.getUCID()));
		center.add(lbl,String.format("cell 1 %d, left", studentRow));
		
		lbl = new MyLabel(student.getFaculty());
		center.add(lbl,String.format("cell 2 %d, left", studentRow));
		
		lbl = new MyLabel(student.getDepartment());
		center.add(lbl,String.format("cell 3 %d, left", studentRow));

		lbl = new MyLabel("420");
		center.add(lbl,String.format("cell 4 %d, left", studentRow));
		
		JButton btn = new MyButton("Accept Student", Size.defaultLblFontSize, Size.defaultBtnEditWidth);
		btn.setName("Accept_ViewStudentsAppliedPanel");
		btn.addActionListener(globalListener);
		btn.setActionCommand(student.getUCID()+":"+scholarship.getId());
		center.add(btn,String.format("cell 5 %d, left", studentRow));
		studentRow++;
	}
	
	public void setScholarship(Scholarship s) {
		scholarship = s;
		lblTitle.setText(s.getName());
	}
	
	/**
	 * remove all students from the panel
	 */
	public void resetStudents() {
		center.removeAll();
		center.repaint();
		displayCenter();
	}
}