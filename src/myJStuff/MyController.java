package myJStuff;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class MyController implements ActionListener{

	protected ActionListener globalListener;
	
	protected JFrame frame;
	
	protected MyController(ActionListener globalListener, JFrame frame) {
		this.globalListener = globalListener;
		this.frame = frame;
	}
	
	/**
	 * Switches the current panel
	 * @param panel - JPanel - panel to go to
	 */
	protected void switchPanel(JPanel panel){
		System.out.println("SWITCHING: "+panel.getName());
		frame.getContentPane().setVisible(false);
		frame.setContentPane(panel);
		frame.getContentPane().setVisible(true);
	}
	
}
