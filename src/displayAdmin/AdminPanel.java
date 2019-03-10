package displayAdmin;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.Colors;
import myJStuff.MyButton;
import myJStuff.MyLabel;
import myJStuff.MyPanel;
import myJStuff.Size;
import objects.Scholarship;
/**
 * Admin panel displays all admin related stuff
 * @author stevekhanna
 *
 */
public class AdminPanel extends MyPanel{
	
	/**
	 * Instance Vars.
	 */
	private ActionListener globalListener;
	
	private JLabel lblLoggedin;
	
	private JLabel lblAdmin;
	
	private JButton btnBack;
	private JButton btnScholarship;
	
	/**
	 * Admin Panel constructor
	 * @param packageListener
	 * @param globalListener
	 */
	public AdminPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		contentPane.setName("Admin Panel");
		
		displayNorth();
		displaySouth();
	}
	/**
	 * displayNorth method displays button at the north end of the screen
	 */
	private void displayNorth(){
		lblLoggedin = new MyLabel("Logged in", textColor, Size.defaultLblTitleFontSize);
		north.add(lblLoggedin, "cell 0 0,center");

		lblAdmin = new MyLabel("Admin", textColor, Size.defaultLblFontSize);
		north.add(lblAdmin, "cell 0 1,center");
	}
	
	/**
	 * displaySouth method displays button at the south end of the screen
	 */
	private void displaySouth() {
		btnBack = new MyButton("Log out", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(globalListener);
		btnBack.setName("Logout_AdminPanel");
		
		btnScholarship = new MyButton("View All Scholarships", btnTxtColor, btnBackgroundColor, Size.defaultBtnFontSize);
		south.add(btnScholarship, "cell 1 0");
		btnScholarship.addActionListener(globalListener);
		btnScholarship.setName("Scholarships_AdminPanel");
	}
}
