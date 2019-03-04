/**@author Nguyen Tran
*/
package displayStudent;

import java.util.ArrayList;
import myJStuff.*;
import objects.*;

public class ScholarshipPanel extends MyPanel {
	private int y = 0;
	/**
	 * Create the panel.
	 */
	public ScholarshipPanel() {
		contentPane.setName("Scholarship Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	private void displayNorth(){
		MyLabel lblScholar = new MyLabel("All Scholarships", textColor, Size.defaultLblTitleFontSize);
		north.add(lblScholar, "cell 0 0");
	}
	
	private void displaySouth(){

	}
	
	private void displayCenter(){
		
	}

	/**
	 * displays the scholarship.
	 * @param scholarship
	 */
	public void displayScholarship(Scholarship scholarship) {
		String[] attributes = scholarship.returnFull().split(":");
		ArrayList<MyLabel> lblList = new ArrayList<MyLabel>();
		lblList.add(new MyLabel("Scholarship:", Colors.black, Size.defaultLblFontSize));
		for (int i = 0; i < 9; i++) {
				lblList.add(new MyLabel(attributes[i] + ":"));
				String coord = String.format("cell %d %d", i, y); 
				center.add(lblList.get(i), coord);
		}
		y++;
	}
	
}
