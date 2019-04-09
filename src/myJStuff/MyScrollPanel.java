package myJStuff;

import javax.swing.JScrollPane;

public class MyScrollPanel extends MyPanel{

	protected JScrollPane scrollPane;
	
	public MyScrollPanel() {
		addScrollToCenter();
	}
	
	protected void addScrollToCenter() {
		//scrollerPanel = new JPanel();
		//scrollerPanel.add(center);
		JScrollPane scroller = new JScrollPane(center);
		//scroller.setPreferredSize(new Dimension(800,200));
		//newScroller.setPreferredSize(new Dimension(800,200));
		scroller.getViewport().getView().setBackground(Colors.defaultBackgroundColor);
		//scrollerPanel.setBackground(Colors.defaultBackgroundColor);
		
	    contentPane.add(scroller);
	}

}
