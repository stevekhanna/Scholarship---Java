package displayStudent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;

/**
 * Student Panel class displays a list of scholarships and 
 * ther person who is currently logged in 
 * @author Pierce de Jong, Steve Khanna
 *
 */
public class StudentPanel extends MyPanel{
	
	/**
	 * Instance Variables
	 */
	private ActionListener globalListener;
	private int y =0;
	JLabel lblLoggedin;
	
	JLabel lblStudent;
	
	JButton btnBack;
	
	/**
	 * Constructor with arguement of ActionListener packageListener
	 * This constructor will initialize the packageListener as well as call upon
	 * the other methods of the class to be displayed
	 * @param packageListener
	 * @param globalListener
	 */
	public StudentPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		
		displayNorth();
		displaySouth();
	}
	
	
	/**
	 * Method to display button at the north end of the screen
	 */
	private void displayNorth(){
		lblLoggedin = new MyLabel("Logged in", textColor, Size.defaultLblTitleFontSize);
		north.add(lblLoggedin, "cell 0 0,center");

		lblStudent = new MyLabel("Student", textColor, Size.defaultLblFontSize);
		north.add(lblStudent, "cell 0 1,center");}
	/**
	 * Method to display button button at the south of the screen
	 */
	private void displaySouth() {
		btnBack = new MyButton("Log out", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(globalListener);
		btnBack.setName("Back_StudentPanel");
	}
	
	
	/**
	 * 
	 * @param name sets the label name to this name
	 */
	public void setLblLoggedin(String name) {
		lblLoggedin.setText(name);
	}
	/**
	 * displays the scholarship.
	 * @param scholarship
	 */
	public void displayScholarship(Scholarship scholarship) {
		String[] attributes = scholarship.returnFull().split(":");
		ArrayList<MyLabel> lblList = new ArrayList<MyLabel>();
		lblList.add(new MyLabel("Scholarship:", Colors.black, Size.defaultLblFontSize));
		for (int i = 0; i < 9; i++) {
				lblList.add(new MyLabel(attributes[i] + ":"));
				String coord = String.format("cell %d %d", i, y); 
				center.add(lblList.get(i), coord);
		}
		y++;
	}
	

}
