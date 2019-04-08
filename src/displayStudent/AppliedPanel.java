package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
/**
 * 
 * @author Steve Khanna, Montek Parmar
 * Students applied panel: this is to show if the student has successfully applied to the scholarship or not
 *
 */
public class AppliedPanel extends MyPanel{
	/**
	 * instance variables
	 */
	private JButton btnBack;
	
	private JLabel lblSuccess;

	/**
	 * class constructor
	 * @param packageListener listener for the panel
	 */
	public AppliedPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("Applied Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * displays whether or not applying for a scholarship was successful
	 */
	private void displayNorth() {
		lblSuccess = new MyLabel("Fill", Size.defaultLblFontSize);
		north.add(lblSuccess, "cell 0 0,center");
	}
	
	private void displayCenter() {
		
	}
	
	/**
	 * displays the back button
	 */
	private void displaySouth() {
		btnBack = new MyButton("Continue", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0,right");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AppliedPanel");
	}
	
	/**
	 * set display string based on success of application
	 * @param success whether the application was successfully applied for 
	 */
	public void success(boolean success) {
		if(success) {
			lblSuccess.setText("Success: You have applied to this scholarship");
		}else {
			lblSuccess.setText("Fail: You have either already applied or are not allowed to apply to this scholarship");
		}
	}
}
