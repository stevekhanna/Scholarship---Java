package displayStudent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;
/**
 * @author Nguyen Tran
 *
 */
public class WonScholarshipsPanel extends MyPanel{
	private JButton btnBack;
	private MyLabel lblWon;
	private MyLabel lblName;
	private int y = 1;
	
	/**
	 * instance variables
	 */
	

	/**
	 * class constructor
	 * @param packageListener listener for the panel
	 */
	public WonScholarshipsPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("Scholarships Won Panel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * displays heading of the panel
	 */
	private void displayNorth() {
		lblWon = new MyLabel("Scholarships you have won", Size.defaultLblFontSize);
		north.add(lblWon, "cell 0 0,center");
	}
	
	/**
	 * displays attribute names
	 */
	private void displayCenter() {

		lblName = new MyLabel("Name", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 0 0");
		lblName = new MyLabel("Amount", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 1 0");
		lblName = new MyLabel("Department", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 2 0");
		
		//addScrollToCenter();
		
	}
	
	/**
	 * displays the back button
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_WonScholarshipsPanel");
	}
	
	/**
	 * remove all scholarships from the panel
	 */
	public void resetScholarships() {
		center.removeAll();
		center.revalidate();
		center.repaint();
		displayCenter();
		y = 1;
	}

	/**
	 * add scholarship won by the student to center
	 * @param scholarship scholarship to be added
	 */
	public void addScholarship(Scholarship scholarship) {
	    String name = scholarship.getName();
		String money = Double.toString(scholarship.getMoney());
		String toS = scholarship.getDepartment();
		ArrayList<String> labelName = new ArrayList<String>();
		labelName.add(name);
		labelName.add(money);
		labelName.add(toS);
		JLabel lbl;
		int i = 0;
		for(String lblNm: labelName) {
			lbl = new MyLabel(lblNm,Colors.defaultTextColor,Size.defaultLblFontSize);
			String cellNum = Integer.toString(i);
			center.add(lbl, String.format("cell "+cellNum+" %d, left",y));
			i++;
		}
		JButton btnView = new MyButton("View", Size.defaultBtnFontSize,Size.defaultBtnEditWidth);
		center.add(btnView, String.format("cell 3 %d, left",y));
		btnView.addActionListener(packageListener);
		btnView.setName("ViewReadOnly_WonScholarshipPanel");
		btnView.setActionCommand(scholarship.getId()+"");
		y++;
		
	}
}
