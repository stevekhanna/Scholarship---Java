package myJStuff;

import java.awt.Color;

import javax.swing.JTextArea;
/**
 * Default instance for a text area
 * @author Elvin Limpin 30018832
 *
 */
public class MyTextArea extends JTextArea{

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 * @param text - text to appear
	 * @param textColor
	 * @param backgroundColor
	 * @param font - font size
	 */
	public MyTextArea(String text, Color textColor, Color backgroundColor, int font){
		setText(text);
		setForeground(Colors.white);
		setBackground(backgroundColor);
		setFont(new MyFont(font));
		setEditable(false);
	}
	
	/**
	 * Constructor with custom text and font size only
	 * @param text - text to appear
	 * @param font - font size
	 */
	public MyTextArea(String text,int font){
		setText(text);
		setForeground(Colors.white);
		setBackground(Colors.black);
		setFont(new MyFont(font));
		setWrapStyleWord(true);
		setEditable(false);
	}	
}