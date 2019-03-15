package displayScholarship;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;

public class ViewScholarshipPanel extends MyPanel{
	private final int NUM_OF_ATTRIBUTES = 8;
	
	private ActionListener globalListener;

	private boolean isAdmin;
	private ArrayList<JLabel> lblAttribute = new ArrayList<JLabel>();
	private JLabel lblTitle;
	private JButton btnBack;
	private JButton btnApply;
	private JButton btnEdit;

	public ViewScholarshipPanel(ActionListener actionListener,ActionListener globalListener, boolean isAdmin) {
		this.packageListener = actionListener;
		this.globalListener = globalListener;
		this.isAdmin = isAdmin;
		contentPane.setName("Scholarship Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}

	private void displayNorth(){
		lblTitle = new MyLabel("Scholarship Panel", Size.defaultLblTitleFontSize);
		north.add(lblTitle, "cell 0 0");
	}
	
	/**
	 * shows the bottom part of the About panel.
	 */
	private void displaySouth(){
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0, left");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_ViewScholarshipPanel");
		
		System.out.println(isAdmin);
		
		if(!isAdmin) {
			btnApply = new MyButton("Apply");
			btnApply.setName("Apply_ViewScholarshipPanel");
			btnApply.addActionListener(globalListener);
			south.add(btnApply, "cell 1 0, right");
		}else {
			btnEdit = new MyButton("Edit");
			btnEdit.setName("EditScholarship_ViewScholarshipPanel");
			btnEdit.addActionListener(globalListener);
			south.add(btnEdit, "cell 1 0, right");
		}
		
	}
	
	/**
	 * Empty method, displays center of panel.
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
	
	public void dispalyScholarship(Scholarship scholarship) {
		if(!isAdmin) {
			btnApply.setActionCommand(Integer.toString(scholarship.getScholarshipId()));
		}else {
			btnEdit.setActionCommand(Integer.toString(scholarship.getScholarshipId()));
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