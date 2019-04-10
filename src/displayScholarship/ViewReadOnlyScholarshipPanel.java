package displayScholarship;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;

public class ViewReadOnlyScholarshipPanel extends MyPanel{
	/**
	 * instance variables
	 */
	private final int NUM_OF_ATTRIBUTES = 8;
	
	private ArrayList<JLabel> lblAttribute = new ArrayList<JLabel>();
	private JLabel lblTitle;
	private JButton btnBack;

	/**
	 * class constructor
	 * @param actionListener package listener
	 * @param globalListener global listener
	 * @param isAdmin whether the user has admin privileges or not
	 */
	public ViewReadOnlyScholarshipPanel(ActionListener actionListener) {
		this.packageListener = actionListener;
		contentPane.setName("View Scholarship Panel (Read Only)");
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
		btnBack.setName("Back_ViewReadOnlyScholarshipPanel");
		
		
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