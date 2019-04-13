package myJStuff;

import javax.swing.JScrollPane;
/**
 * Custom SrollPanel class to ensure colour scheme is consistent
 * @author Khoa
 *
 */
public class MyScrollPanel extends MyPanel{

	protected JScrollPane scrollPane;
	
	public MyScrollPanel() {
		addScrollToCenter();
	}
	
	protected void addScrollToCenter() {
		JScrollPane scroller = new JScrollPane(center);
		scroller.getViewport().getView().setBackground(Colors.defaultBackgroundColor);
	    contentPane.add(scroller);
	}

}
