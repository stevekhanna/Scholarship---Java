package displayLogin;

import myJStuff.*;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AboutPanel extends MyPanel{
	
	private JLabel lblAbout;
	
	private JButton btnBack;

	/**
	 * constructor with 1 argument, initializes the about panel for display.
	 * @param actionListener listener for the back button.
	 */
	public AboutPanel(ActionListener actionListener) {
		this.packageListener = actionListener;
		contentPane.setName("About Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * shows the top part of the About panel.
	 */
	private void displayNorth(){
		lblAbout = new MyLabel("About", Size.defaultLblTitleFontSize);
		north.add(lblAbout, "cell 0 0");
		JTextArea ta = new JTextArea("This software is a system that awards scholarships to students, based on the administrator's needs. ");
		
		north.add(ta, "cell 0 1");
		
	}
	
	
	/**
	 * shows the bottom part of the About panel.
	 */
	private void displaySouth(){
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AboutPanel");

	}
	
	/**
	 * Empty method, displays center of panel.
	 */
	private void displayCenter(){
	}
}
