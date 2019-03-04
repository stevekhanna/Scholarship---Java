package displayAdmin;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.MyButton;
import myJStuff.MyLabel;
import myJStuff.MyPanel;
import myJStuff.Size;
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
	
	JLabel lblLoggedin;
	
	JLabel lblAdmin;
	
	JButton btnBack;
	
	/**
	 * Admin Panel constructor
	 * @param packageListener
	 * @param globalListener
	 */
	public AdminPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		
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
		btnBack.setName("Back_AdminPanel");
	}
	
	
	/**
	 * 
	 * @param name sets the label name to this name
	 */
	public void setLblLoggedin(String name) {
		lblLoggedin.setText(name);
	}
	
	

}
