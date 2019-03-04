package displayStudent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;
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

	private int y =0;
	public void displayScholarship(Scholarship scholarship) {
		String name = scholarship.getName();
		String gPA = Double.toString(scholarship.getGpaRequirement());
		String toS = scholarship.getTypeOfStudy();
		ArrayList<String> labelName = new ArrayList<String>();
		labelName.add(name);
		labelName.add(gPA);
		labelName.add(toS);
		JLabel lbl;
		int i = 0;
		for(String lblNm: labelName) {
			lbl = new MyLabel(lblNm,Colors.black,Size.defaultLblFontSize);
			String cellNum = Integer.toString(i);
			center.add(lbl, String.format("cell "+cellNum+" %d, center",y));
			i++;
		}
		y++;
	}
	

}
