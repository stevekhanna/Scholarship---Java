package myJStuff;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
/**
 * Custom combo box class to ensure that all components match the colour scheme
 * @author Steve Khanna
 *
 */
public class MyComboBox extends JComboBox<Object> {
	
	private static final long serialVersionUID = 1L;

	public MyComboBox(Object[] arr) {
		super(arr);
		setBounds(50, 50,90,20);
		setForeground(Colors.defaultButtonTextColor);
		setBackground(Colors.defaultButtonBackgroundColor);
		setFont(new MyFont(Size.defaultLblFontSize));
	}
}