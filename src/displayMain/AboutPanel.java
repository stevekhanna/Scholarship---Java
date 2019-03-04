package displayMain;

import myJStuff.*;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

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
		lblAbout = new MyLabel("About", textColor, Size.defaultLblTitleFontSize);
		north.add(lblAbout, "cell 0 0");
	}
	
	/**
	 * shows the bottom part of the About panel.
	 */
	private void displaySouth(){
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
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
