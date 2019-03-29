package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

public class AppliedPanel extends MyPanel{
	
	private JButton btnBack;
	
	private JLabel lblSuccess;

	
	public AppliedPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		
		displayNorth();
		displaySouth();
		dispalyCenter();
	}
	
	
	private void displayNorth() {
		lblSuccess = new MyLabel("Fill", Size.defaultLblFontSize);
		north.add(lblSuccess, "cell 0 0,center");
	}
	
	private void dispalyCenter() {
		
	}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AppliedPanel");
	}
	
	
	public void dispalyScholarship() {
		
	}
	
	public void success(boolean success) {
		if(success) {
			lblSuccess.setText("Success: You have applied to this scholarship");
		}else {
			lblSuccess.setText("Fail: You have either already applied or are not allowed to apply to this scholarship");
		}
	}
}
