package myJStuff;

import java.awt.Dimension;

import javax.swing.JTextField;

public class MyTextField extends JTextField {

	/**
	 * default constructor
	 * @param string - text that appears
	 * @param i - font size
	 */
	public MyTextField(String string, int i) {
		super(string, i);
		this.setFont(new MyFont(i));
		this.setPreferredSize(new Dimension(Size.defaultBtnWidth,Size.defaultBtnHeight));
		this.setForeground(Colors.defaultTextColor);
	}

	private static final long serialVersionUID = 1L;
}
