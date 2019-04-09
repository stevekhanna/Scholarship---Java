package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import myJStuff.*;

public class CreateScholarshipPanel extends MyPanel{
	/**
	 * instance variables
	 */
	private JTextField fldName;
	private JTextField fldGpa;
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
	
	private JComboBox<Object> yosList;
	private JComboBox<Object> facList;
	private JComboBox<Object> tosList;
	
	private JLabel lblHeader;
	
	private JButton btnBack;
	
	private JButton btnSave;
	
	/**
	 * class constructor
	 * @param packageListener listener for the panel
	 */
	public CreateScholarshipPanel(ActionListener packageListener){
		this.packageListener = packageListener;
		contentPane.setName("Create Scholarship Panel");
		displayNorth();
		displayCenter();
		displaySouth();
	}
	
	/**
	 * displayNorth method displays the heading of the panel 
	 */
	private void displayNorth() {
		lblHeader = new MyLabel("Create Scholarship", Size.defaultLblSubTitleFontSize);
		north.add(lblHeader, "cell 0 0,center");
	}
	
	/**
	 * displayCenter method displays labels of attributes of the scholarship to be added and fields to write in
	 */
	private void displayCenter() {
		
		String[] diffFaculties = {"Arts","Science","Commerce","University"};
		String[] diffYOS = {"1","2","3","4","5","6","7","8","9","10"};
		String[] diffTOS = {"Bachelor", "Master's","PhD","Continuing Education"};
		
		lblEditName = new MyLabel("Scholarship Name:", Size.defaultLblFontSize);
		center.add(lblEditName, "cell 0 0");
		
		fldName = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldName,"cell 0 1");
		
		lblEditGpa = new MyLabel("GPA:", Size.defaultLblFontSize);
		center.add(lblEditGpa, "cell 0 2");
		
		fldGpa = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldGpa,"cell 0 3");
		
		lblEditFaculty = new MyLabel("Faculty:", Size.defaultLblFontSize);
		center.add(lblEditFaculty, "cell 0 6");
		
		facList = new MyComboBox(diffFaculties);
		
		facList.setSelectedIndex(0);
		center.add(facList, "cell 0 7");
		
		lblEditYearOfStudy = new MyLabel("Year of Study:", Size.defaultLblFontSize);
		center.add(lblEditYearOfStudy, "cell 0 8");
		
		
		yosList = new MyComboBox(diffYOS);		
		yosList.setSelectedIndex(0);
		center.add(yosList, "cell 0 9");
		
		
		
		lblEditTypeOfStudy = new MyLabel("Type of Study:", Size.defaultLblFontSize);
		center.add(lblEditTypeOfStudy, "cell 2 6");
		
		tosList = new MyComboBox(diffTOS);		
		tosList.setSelectedIndex(0);
		center.add(tosList, "cell 2 7");
		
		lblEditDepartment = new MyLabel("Department:", Size.defaultLblFontSize);
		center.add(lblEditDepartment, "cell 2 0");
		

		fldDepartment = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldDepartment, "cell 2 1");		
		
		lblEditNumAllowed = new MyLabel("Number of Scholarships:", Size.defaultLblFontSize);
		center.add(lblEditNumAllowed, "cell 2 2");
		
		fldNumAllowed = new MyTextField("", Size.defaultLblFontSize);
		center.add(fldNumAllowed, "cell 2 3");
		
		lblEditDescription = new MyLabel("Description:", Size.defaultLblFontSize);
		center.add(lblEditDescription, "cell 0 4");
		
		fldDescription = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldDescription,"cell 0 5");
		
		lblEditAmount = new MyLabel("Amount:", Size.defaultLblFontSize);
		center.add(lblEditAmount, "cell 2 4");
		
		fldAmount = new MyTextField("",Size.defaultLblFontSize);
		center.add(fldAmount,"cell 2 5");
		
	}
	
	/**
	 * displaySouth method displays 2 functional buttons (back and create)
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0, left");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_CreateScholarshipPanel");
		
		btnSave = new MyButton("Create", Size.defaultBtnFontSize, Size.defaultBtnEditWidth);
		south.add(btnSave, "cell 1 0 , right");
		btnSave.addActionListener(packageListener);
		btnSave.setName("Create_CreateScholarshipPanel");
		
	}
	
	/**
	 * method to get name from the text field
	 * @return name of the scholarship as a string
	 */
	public String getName() {
		if(fldName.getText().contains(",")) {
			return "";
		}else {
			return fldName.getText();
		}
	}
	
	/**
	 * method to get GPA requirement from the text field
	 * @return the GPA requirement as a double
	 */
	public double getGpa() {
		try{
			return Double.parseDouble(fldGpa.getText());
		}catch(Exception e){
			return -1.0;
		}
		
	}
	
	/**
	 * method to get the faculty requirement from the text field
	 * @return faculty requirement as a string
	 */
	public String getFaculty() {
		return String.valueOf(facList.getSelectedItem());
		
	
	}
	
	/**
	 * method to get the year requirement from the text field
	 * @return the year of study requirement as an integer
	 */
	public int getYearOfStudy() {
		try {
			return Integer.parseInt(String.valueOf(yosList.getSelectedItem()));
		}catch(Exception e) {
			return -1;
		}
	}
	
	/**
	 * method to get the type of study requirement from the text field
	 * @return the type of study requirement as a string
	 */
	public String getTypeOfStudy() {
		return String.valueOf(tosList.getSelectedItem());
	}
	
	/**
	 * method to get the department requirement from the text field 
	 * @return the department requirement as a string
	 */
	public String getDepartment() {
		if(fldDepartment.getText().contains(",")) {
			return "";
		}else {
			return fldDepartment.getText();
		}
	}
	
	/**
	 * method to get the number of scholarships to be awarded
	 * @return the number of scholarships as an integer
	 */
	public int getNumAllowed() {
		try {
			return Integer.parseInt(fldNumAllowed.getText());
		}catch(Exception e ) {
			return -1;
		}
		
	}

	/**
	 * method to get scholarship description from the text field
	 * @return the description as a string
	 */
	public String getDescription() {
		if (fldDescription.getText().contains(",")) {
			return "";
		}else {
			return fldDescription.getText();
		}
	}
	
	/**
	 * method to get the value of the scholarship
	 * @return the money rewarded as a double
	 */
	public double getMoney() {
		try {
			return Double.parseDouble(fldAmount.getText());
		}
		catch(Exception e) {
			return -1.0;
		}
		
	}
	
	/**
	 * method clears all text fields
	 */
	public void clearAll() {
		fldName.setText("");
		fldGpa.setText("");
		fldDepartment.setText("");
		fldNumAllowed.setText("");
		fldDescription.setText("");
		fldAmount.setText("");
	}
	
}