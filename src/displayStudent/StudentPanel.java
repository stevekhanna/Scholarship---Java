package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
public class StudentPanel extends MyPanel{
	
	private ActionListener globalListener;
	
	JLabel lblLoggedin;
	
	JLabel lblStudent;
	
	JButton btnBack;
	
	public StudentPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		
		displayNorth();
		displaySouth();
	}
	
	private void displayNorth(){
		lblLoggedin = new MyLabel("Logged in", textColor, Size.defaultLblTitleFontSize);
		north.add(lblLoggedin, "cell 0 0,center");

		lblStudent = new MyLabel("Student", textColor, Size.defaultLblFontSize);
		north.add(lblStudent, "cell 0 1,center");}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(globalListener);
		btnBack.setName("Back_ShowPanel");
	}
	
	
	
	public void setLblLoggedin(String name) {
		lblLoggedin.setText(name);
	}
	
	

}
