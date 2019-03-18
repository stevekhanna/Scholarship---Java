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
	private JTextField fldDescription;
	
	
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
		fldName = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldName,"cell 0 0");
		
		fldGpa = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldGpa,"cell 0 1");
		
		fldDescription = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldDescription,"cell 0 2");
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
		fldDescription.setText(s.getDescription());
		btnSave.setActionCommand(Integer.toString(s.getScholarshipId()));
	}
	
	public String getName() {
		return fldName.getText();
	}
	
	public double getGpa() {
		return Double.parseDouble(fldGpa.getText());
	}
	
	public String getDescxription() {
		return fldDescription.getText();
	}

}
