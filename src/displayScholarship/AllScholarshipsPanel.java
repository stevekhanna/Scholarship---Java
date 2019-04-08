package displayScholarship;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import myJStuff.*;
import objects.Scholarship;

public class AllScholarshipsPanel extends MyPanel{
	
	/**
	 * instance variables
	 */
	private ActionListener globalLisenter;
	
	private JLabel lblTitle;
	private JButton btnBack;
	private JButton btnSearch;
	private JTextField fldSearch;
	private JLabel lblSearchError;
	
	private JLabel lblName;
	
	private int y = 1;
	
	private boolean isAdmin;

	/**
	 * class constructor
	 * @param actionListener package listener
	 * @param globalLisenter global listener
	 * @param isAdmin whether it is the admin or student viewing the scholarships, granting additional power to admin
	 */
	public AllScholarshipsPanel(ActionListener actionListener, ActionListener globalLisenter, boolean isAdmin) {
		this.packageListener = actionListener;
		this.globalLisenter = globalLisenter;
		this.isAdmin = isAdmin;
		contentPane.setName("All Scholarships Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}

	/**
	 * displays heading of the panel
	 */
	private void displayNorth(){
		lblTitle = new MyLabel("Scholarships", Size.defaultLblTitleFontSize);
		north.add(lblTitle, "cell 0 0");
	}
	
	/**
	 * shows the bottom part of the scholarship list panel
	 * with a back button, and a search button
	 * search using the textfield
	 */
	private void displaySouth(){
		
		// This button goes back to either the student or admin controller from the scholarships controller
		btnBack = new MyButton("Back", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 1");
		// Global listener to switch between the controllers
		btnBack.addActionListener(globalLisenter);
		btnBack.setName("Back_AllScholarshipsPanel");
		
		btnSearch = new MyButton("Search", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnSearch, "cell 2 1");
		// Global listener to switch between the controllers
		btnSearch.addActionListener(packageListener);
		btnSearch.setName("Search_AllScholarshipsPanel");

		
		fldSearch = new MyTextField("", Size.defaultBtnFontSize);
		south.add(fldSearch, "cell 1 1, center");
		
		lblSearchError = new MyLabel("", Size.defaultLblFontSize);
		south.add(lblSearchError, "cell 1 0, center");	
		
		
	}
	
	public void setErrorMessage(String error) {
		lblSearchError.setText(error);
	}
	
	
	public String getSearchResult() {
		return fldSearch.getText();
	}
	
	
	public void setSearchResult(String search) {
		fldSearch.setText(search);
	}
	
	/**
	 * Display attribute names of the scholarships
	 */
	private void displayCenter(){
		lblName = new MyLabel("Name", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 0 0");
		lblName = new MyLabel("GPA Req.", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 1 0");
		lblName = new MyLabel("Faculty", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 2 0");
		lblName = new MyLabel("Department", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 3 0");
		lblName = new MyLabel("Amount", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 4 0");
	}
	
	/**
	 * displays the scholarship
	 * if viewer is admin, show delete button for scholarship
	 * @param scholarship scholarship to be displayed
	 */
	public void displayScholarship(Scholarship scholarship) {
		String name = scholarship.getName();
		String gPA = Double.toString(scholarship.getGpaRequirement());
		String faculty = scholarship.getFaculty();
		String amount = Double.toString(scholarship.getMoney());
		String dept = scholarship.getDepartment();
		ArrayList<String> labelName = new ArrayList<String>();
		labelName.add(name);
		labelName.add(gPA);
		labelName.add(faculty);
		labelName.add(dept);
		labelName.add(amount);
		JLabel lbl;
		int i = 0;
		for(String lblNm: labelName) {
			lbl = new MyLabel(lblNm,Colors.defaultTextColor,Size.defaultLblFontSize);
			String cellNum = Integer.toString(i);
			center.add(lbl, String.format("cell "+cellNum+" %d, left",y));
			i++;
		}
		JButton btnView = new MyButton("View", Size.defaultLblFontSize, Size.defaultBtnEditWidth);
		btnView.setActionCommand(Integer.toString(scholarship.getId()));
		btnView.setName("ViewScholarship_AllScholarshipsPanel");
		btnView.addActionListener(packageListener);
		center.add(btnView, String.format("cell 5 %d, center",y));
		
		if(isAdmin) {
			JButton btnDelete = new MyButton("Delete", Size.defaultLblFontSize, Size.defaultBtnEditWidth);
			btnDelete.setActionCommand(Integer.toString(scholarship.getId()));
			btnDelete.setName("DeleteScholarship_AllScholarshipsPanel");
			btnDelete.addActionListener(globalLisenter);
			center.add(btnDelete, String.format("cell 6 %d, center",y));		
		}

		y++;
	}
}