package displayMain;

import myJStuff.*;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

import javax.swing.JButton;

public class AboutPanel extends MyPanel{
	
	private JLabel lblAbout;
	
	private JButton btnBack;


	public AboutPanel(ActionListener actionListener) {
		this.packageListener = actionListener;

		contentPane.setName("About Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	private void displayNorth(){
		lblAbout = new MyLabel("About", textColor, Size.defaultLblTitleFontSize);
		north.add(lblAbout, "cell 0 0");
	}
	
	private void displaySouth(){
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AboutPanel");

	}
	
	private void displayCenter(){
	}
}
