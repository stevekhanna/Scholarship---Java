package displayScholarship;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import myJStuff.*;
import objects.Scholarship;

public class EditScholarshipPanel extends MyPanel{
	
	private ActionListener globalListener;
	
	private JTextField fldName;
	private JTextField fldGpa;
	private JTextField fldFaculty;
	private JTextField fldYearOfStudy;
	private JTextField fldTypeOfStudy;
	private JTextField fldDepartment;
	private JTextField fldNumAllowed;
	private JTextField fldDescription;
	private JTextField fldAmount;

	private JLabel lblEditName;
	private JLabel lblEditGpa;
	private JLabel lblEditFaculty;
	private JLabel lblEditYearOfStudy;
	private JLabel lblEditTypeOfStudy;
	private JLabel lblEditDepartment;
	private JLabel lblEditNumAllowed;
	private JLabel lblEditDescription;
	private JLabel lblEditAmount;
	
	private JButton btnBack;
	
	private JButton btnSave;
	
	public EditScholarshipPanel(ActionListener packageListener, ActionListener globalListener){
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		displayNorth();
		displayCenter();
		displaySouth();
	}
	
	private void displayNorth() {
		
	}
	
	private void displayCenter() {
		
		
		lblEditName = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditName.setText("Enter new scholarship name: ");
		center.add(lblEditName, "cell 0 0");
		
		fldName = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldName,"cell 0 1");
		
		lblEditGpa = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditGpa.setText("Enter new GPA: ");
		center.add(lblEditGpa, "cell 0 2");
		
		fldGpa = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldGpa,"cell 0 3");
		
		lblEditFaculty = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditFaculty.setText("Enter new faculty: ");
		center.add(lblEditFaculty, "cell 0 4");
		
		fldFaculty = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldFaculty, "cell 0 5");
		
		lblEditYearOfStudy = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditYearOfStudy.setText("Enter new year of study: ");
		center.add(lblEditYearOfStudy, "cell 0 6");
		
		fldYearOfStudy = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldYearOfStudy, "cell 0 7");
		
	
		
		lblEditTypeOfStudy = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditTypeOfStudy.setText("Enter new type of study: ");
		center.add(lblEditTypeOfStudy, "cell 0 8");
		
		fldTypeOfStudy = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldTypeOfStudy, "cell 0 9");
		
		lblEditDepartment = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditDepartment.setText("Enter New Department: ");
		center.add(lblEditDepartment, "cell 0 10");
		

		fldDepartment = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldDepartment, "cell 0 11");		
		
		lblEditNumAllowed = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditNumAllowed.setText("Enter new Number of Scholarships Allowed: ");
		center.add(lblEditNumAllowed, "cell 2 0");
		
		fldNumAllowed = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldNumAllowed, "cell 2 1");
		
		lblEditDescription = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditDescription.setText("Enter new Description of Scholarship: ");
		center.add(lblEditDescription, "cell 2 2");
		
		fldDescription = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldDescription,"cell 2 3");
		
		lblEditAmount = new MyLabel("Label", Size.defaultLblFontSize);
		lblEditAmount.setText("Enter new Scholarship Amount: ");
		center.add(lblEditAmount, "cell 2 4");
		
		fldAmount = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldAmount,"cell 2 5");
		
		
	}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0, left");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_EditScholarshipPanel");
		
		btnSave = new MyButton("Save Edits", Size.defaultBtnFontSize);
		south.add(btnSave, "cell 1 0, right");
		btnSave.addActionListener(globalListener);
		btnSave.setName("SaveEdits_EditScholarshipPanel");
	}
	
	public void setScholarship(Scholarship s) {
		fldName.setText(s.getName());
		fldGpa.setText(s.getGpaRequirement()+"");
		fldFaculty.setText(s.getFaculty());
		fldYearOfStudy.setText(s.getYearOfStudy()+"");
		fldTypeOfStudy.setText(s.getTypeOfStudy());
		fldDepartment.setText(s.getDepartment());
		fldNumAllowed.setText(s.getNumAllowed()+"");
		fldDescription.setText(s.getDescription());
		fldAmount.setText(s.getMoney()+"");
		btnSave.setActionCommand(Integer.toString(s.getScholarshipId()));
	}
	
	public String getName() {
		return fldName.getText();
	}
	
	public double getGpa() {
		return Double.parseDouble(fldGpa.getText());
	}
	
	
	public String getFaculty() {
		return fldFaculty.getText();
	}
	
	public int getYearOfStudy() {
		try {
			return Integer.parseInt(fldYearOfStudy.getText());
		}catch(Exception e) {
			return -1;
		}
		
	}
	public String getTypeOfStudy() {
		return fldTypeOfStudy.getText();
	}
	public String getDepartment() {
		return fldDepartment.getText();
	}
	public int getNumAllowed() {
		return Integer.parseInt(fldNumAllowed.getText());
	}

	public String getDescription() {
		return fldDescription.getText();
	}
	
	public double getMoney() {
		return Double.parseDouble(fldAmount.getText());
	}
	
}