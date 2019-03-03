package myJStuff;
/**
 * Default button
 * @author Elvin Limpin 30018832
 */
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class MyButton extends JButton{
	/**
	 * These constructors have a flexible set of parameters
	 * to ensure that any instance would follow default values
	 * if not specified
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Custom constructor for buttons that comes
	 * with the default font
	 * @param text
	 * @param foreground
	 * @param background
	 * @param i - font size
	 */
	public MyButton(String text, Color foreground, Color background, int i){
		setText(text);
		setForeground(foreground);
		setBackground(background);
		setFont(new MyFont(i));
		setBorder(new EmptyBorder(4,4,4,4));
	}

	/**
	 * Default constructor for buttons
	 * @param text - text to display
	 */
	public MyButton(String text){
		setText(text);
		setForeground(Colors.defaultButtonTextColor);
		setBackground(Colors.defaultButtonBackgroundColor);
		setFont(new MyFont(Size.defaultBtnFontSize));
		setBorder(new EmptyBorder(4,4,4,4));
		setPreferredSize(new Dimension(Size.defaultBtnWidth,Size.defaultBtnHeight));
	}

	/**
	 * Constructor that takes custom text and text-size
	 * @param text - text to display
	 * @param size - size of the font
	 */
	public MyButton(String text, int size){
		setText(text);
		setForeground(Colors.defaultButtonTextColor);
		setBackground(Colors.defaultButtonBackgroundColor);
		setFont(new MyFont(size));
		setBorder(new EmptyBorder(4,4,4,4));
	}
	
	/**
	 * Alternative custom constructor that takes
	 * a specific font
	 * @param text - text to display
	 * @param btnTxtColor
	 * @param btnBackgroundColor
	 * @param buttonFont - font for the button
	 */
	public MyButton(String text, Color btnTxtColor, Color btnBackgroundColor, MyFont buttonFont) {
		setText(text);
		setForeground(btnTxtColor);
		setBackground(btnBackgroundColor);
		setFont(buttonFont);
		setBorder(new EmptyBorder(4,4,4,4));
	}
}