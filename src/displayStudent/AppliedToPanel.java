package displayStudent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;

public class AppliedToPanel extends MyPanel{
private JButton btnBack;
	
	private JLabel lblSuccess;
	private int y=1;
	private JLabel lblName;
	
	private int totalScholarships;
	
	public AppliedToPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		
		displayNorth();
		displaySouth();
		dispalyCenter();
	}
	
	
	private void displayNorth() {
		lblSuccess = new MyLabel("Scholarships you have applied to", Size.defaultLblFontSize);
		north.add(lblSuccess, "cell 0 0,center");
	}
	
	private void dispalyCenter() {
		
		lblName = new MyLabel("Name", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 0 0");
		lblName = new MyLabel("Amount", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 1 0");
		lblName = new MyLabel("Department", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 2 0");
		lblName = new MyLabel("Priority", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 3 0");
	}
	
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AppliedToPanel");
	}
	
	public void setTotalScholarships(int i) {
		totalScholarships = i;
	}

	public void addScholarship(Scholarship scholarship, int priority) {
		ArrayList<Integer> strList = new ArrayList<Integer>();
		
		for(int i = 0; i<totalScholarships; i++) {
				strList.add((totalScholarships -i ));
		}
		Collections.sort(strList);
		//strList.add(0,priority);
		Object[] strArr = strList.toArray();      
	    JComboBox<Object> cb=new MyComboBox(strArr);  
	    //cb.setBounds(50, 50,90,20);
	    cb.setSelectedIndex(priority-1);
	    center.add(cb, String.format("cell 3 %d, left",y));
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
		y++;
	}
}
