package displayMain;

import myJStuff.*;

import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JLabel;

import javax.swing.JButton;

public class AboutPanel extends MyPanel{
	/**
	 * Instance variables.
	 */	
	//north panel label
	private JLabel lblAbout;
	
	//south panel back button
	private JButton btnBack;
	
	//textPane for center panel
	private JTextArea myTxtPane;

	/**
	 * Constructor with one argument of ActionListener actionListener.
	 * This constructor will initialize the actionListener and call 
	 * other methods of this class for display.
	 * @param actionListener
	 */
	public AboutPanel(ActionListener actionListener) {
		this.packageListener = actionListener;

		contentPane.setName("About Panel");
		//displaying contents of each panels
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * Method to display content of north panel, which is label.
	 */
	private void displayNorth(){
		lblAbout = new MyLabel("About", textColor, Size.defaultLblTitleFontSize);
		north.add(lblAbout, "cell 0 0");
	}
	
	/**
	 * Method to display contents of south panel. This panel contains 
	 * the back button which goes back to main menu.
	 */
	private void displaySouth(){
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		// setting an action for back button
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AboutPanel");

	}
	
	/**
	 * Method to display content of center panel. It will set up the text pane.
	 */
	private void displayCenter(){
	}
}
