package displayScholarship;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;

public class ViewScholarshipPanel extends MyPanel{
	/**
	 * instance variables
	 */
	private final int NUM_OF_ATTRIBUTES = 8;
	
	private ActionListener globalListener;

	private boolean isAdmin;
	private ArrayList<JLabel> lblAttribute = new ArrayList<JLabel>();
	private JLabel lblTitle;
	private JButton btnBack;
	private JButton btnApply;
	private JButton btnEdit;
	private JButton btnApplied;
	private JButton btnAccepted;

	/**
	 * class constructor
	 * @param actionListener package listener
	 * @param globalListener global listener
	 * @param isAdmin whether the user has admin privileges or not
	 */
	public ViewScholarshipPanel(ActionListener actionListener,ActionListener globalListener, boolean isAdmin) {
		this.packageListener = actionListener;
		this.globalListener = globalListener;
		this.isAdmin = isAdmin;
		contentPane.setName("View Scholarship Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}

	/**
	 * displays heading of the panel
	 */
	private void displayNorth(){
		lblTitle = new MyLabel("Scholarship Panel", Size.defaultLblTitleFontSize);
		north.add(lblTitle, "cell 0 0");
	}
	
	/**
	 * displays the bottom part of the panel
	 * with a back button and:
	 * - apply button for student
	 * - edit button for admin
	 */
	private void displaySouth(){
		btnBack = new MyButton("Back", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0, left");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_ViewScholarshipPanel");
		
		btnApplied = new MyButton("Applied Students",Size.defaultBtnFontSize);
		btnApplied.setName("ViewStudentsApplied_ViewScholarshipPanel");
		btnApplied.addActionListener(packageListener);
		south.add(btnApplied,"cell 2 0");
		btnAccepted = new MyButton("Accepted Students",Size.defaultBtnFontSize);
		btnAccepted.setName("ViewStudentsAccepted_ViewScholarshipPanel");
		btnAccepted.addActionListener(packageListener);
		south.add(btnAccepted,"cell 3 0");
		
		if(!isAdmin) {
			btnApply = new MyButton("Apply",Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
			btnApply.setName("Apply_ViewScholarshipPanel");
			btnApply.addActionListener(globalListener);
			south.add(btnApply, "cell 4 0, right");
		}else {
			btnEdit = new MyButton("Edit",Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
			btnEdit.setName("EditScholarship_ViewScholarshipPanel");
			btnEdit.addActionListener(packageListener);
			south.add(btnEdit, "cell 4 0, right");
		}
		
	}
	
	/**
	 * displays center of panel
	 * with attributes of the current scholarship
	 */
	private void displayCenter(){
		String[] attributeName = {"GPA","Faculty","Year of Study", "Type of Study", "Department", "Number Available", "Description", "Amount"};
		for (int i=0; i<NUM_OF_ATTRIBUTES; i++) {
			lblAttribute.add(new MyLabel("default"));
			center.add(lblAttribute.get(i), String.format("cell 1 %d, left", i));
			JLabel name = new MyLabel(attributeName[i]+": ");
			center.add(name, String.format("cell 0 %d, right", i));
		}
	}
	
	/**
	 * displays target scholarship in center panel
	 * 
	 * @param scholarship scholarship to be displayed
	 */
	public void displayScholarship(Scholarship scholarship) {
		if(!isAdmin) {
			btnApply.setActionCommand(Integer.toString(scholarship.getId()));
			btnApplied.setVisible(false);
			btnAccepted.setVisible(false);
		}else {
			btnEdit.setActionCommand(Integer.toString(scholarship.getId()));
			btnApplied.setVisible(true);
			btnAccepted.setVisible(true);
		}
		lblTitle.setText(scholarship.getName());
		String x = scholarship.returnFull();
		x = x.substring(x.indexOf(":")+1); // remove the name
		x = x.substring(x.indexOf(":")+1); //remove the id
		String[] s = x.split(":");
		int y = 0;
		for (String string: s) {
			lblAttribute.get(y).setText(string);
			y++;
		}
	}
}