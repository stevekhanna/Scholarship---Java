package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

/**
 * Student Panel class displays a list of scholarships and 
 * ther person who is currently logged in 
 * @author Pierce de Jong, Steve Khanna
 *
 */
public class ScholarshipPanel extends MyPanel{
	
	private int y =0;
	JLabel lblLoggedin;
	
	JLabel lblStudent;
	
	JButton btnBack;
	public ScholarshipPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("Student Panel");
		
		displayNorth();
		displaySouth();
	}
	
	
	/**
	 * Method to display button at the north end of the screen
	 */
	private void displayNorth(){
		
	}
	/**
	 * Method to display button button at the south of the screen
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_ScholarshipPanel");
	}
}
