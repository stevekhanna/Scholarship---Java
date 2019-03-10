package displayScholarship;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

public class ScholarshipPanel extends MyPanel{
	
	private JLabel lblTitle;
	private JButton btnBack;

	public ScholarshipPanel(ActionListener actionListener) {
		this.packageListener = actionListener;
		contentPane.setName("Scholarship Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}

	private void displayNorth(){
		lblTitle = new MyLabel("Scholarship Panel", textColor, Size.defaultLblTitleFontSize);
		north.add(lblTitle, "cell 0 0");
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