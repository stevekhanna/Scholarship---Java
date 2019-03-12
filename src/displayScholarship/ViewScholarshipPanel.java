package displayScholarship;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;

public class ViewScholarshipPanel extends MyPanel{
	
	private ActionListener globalListener;
	
	private boolean isAdmin;
	
	private JLabel lblTitle;
	private JButton btnBack;
	private JButton btnApply;

	public ViewScholarshipPanel(ActionListener actionListener,ActionListener globalListener, boolean isAdmin) {
		this.packageListener = actionListener;
		this.globalListener = globalListener;
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
		south.add(btnBack, "cell 0 0, left");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_ViewScholarshipPanel");
		
		if(!isAdmin) {
			btnApply = new MyButton("Apply", Size.defaultLblFontSize);
			btnApply.setName("Apply_ViewScholarshipPanel");
			btnApply.addActionListener(globalListener);
			center.add(btnApply, "cell 0 1, right");
		}
		
	}
	
	/**
	 * Empty method, displays center of panel.
	 */
	private void displayCenter(){
	}
	
	public void dispalyScholarship(Scholarship scholarship) {
		btnApply.setActionCommand(Integer.toString(scholarship.getScholarshipId()));
		lblTitle.setText(scholarship.getName());
	
	}
}