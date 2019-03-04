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

	private void displayScholarship(Scholarship inSc) {
		String[] scArray = inSc.returnFull().split(":");
		ArrayList<MyLabel> lblList = new ArrayList<MyLabel>();
		lblList.add(new MyLabel("Scholarship:", textColor, Size.defaultLblTitleFontSize));
		for (int i = 0; i < 9; i++) {
			if (scArray[i] != "") {
				lblList.add(new MyLabel(scArray[i] + ":"));
				int x = 0;
				String coord = String.format("cell %d %d", x, y); 
				center.add(lblList.get(i), coord);
				x++;
			}
		}
		y++;
	}
	
}
