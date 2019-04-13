package myJStuff;

import javax.swing.JOptionPane;
/**
 * Custom JOptionPane class to ensure colour scheme is consistent
 * @author Steve Khanna
 *
 */
public class MyJOptionPane extends JOptionPane{
	
	private static final long serialVersionUID = 1L;
	public MyJOptionPane() {
		setBackground(Colors.defaultBackgroundColor);
	}
	
}
