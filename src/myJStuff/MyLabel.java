package myJStuff;
import java.awt.Color;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	private static final long serialVersionUID = 1L;

	/** Custom constructor
	 * @param text - String to be displayed
	 * @param color - Color of the font
	 * @param size - int
	 **/
	public MyLabel(String text,	Color color, int size){
		setText(text);
		setForeground(color);
		setFont(new MyFont(size));
	}

	/**
	 * Constructor sets default values
	 * @param text - String to be displayed
	 */
	public MyLabel(String text) {
		this(text, Colors.defaultTextColor, 25);
	}
	
	public MyLabel(String text, int size) {
		this(text, Colors.defaultTextColor, size);
	}
}
