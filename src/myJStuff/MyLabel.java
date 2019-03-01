package myJStuff;

/**
 * 
 * 
 */
import java.awt.Color;

import javax.swing.JLabel;

/**
 * Default layout for labels
 * @author Elvin Limpin 30018832
 *
 */

public class MyLabel extends JLabel{
	
	/**
	 * These constructors have a flexible set of parameters
	 * to ensure that any instance would follow default values
	 * if not specified
	 */
	private static final long serialVersionUID = 1L;

	/** Custom constructor
	 * @param text - text to appear
	 * @param color - color of the font
	 * @param size - size of the font
	 **/
	public MyLabel(String text,	Color color, int size){
		setText(text);
		setForeground(color);
		setFont(new MyFont(size));
	}

	/**
	 * Constructor sets default values
	 * except for the string
	 * @param string - the font displayed
	 */
	public MyLabel(String string) {
		this(string, Colors.white, 25);
	}

	/**
	 * Constructor sets default value for
	 * color (white)
	 * @param string - text to display
	 * @param i - size of the font
	 */
	public MyLabel(String string, int i) {
		this(string, Colors.white, i);
	}
}
