package myJStuff;

import java.awt.Dimension;

import javax.swing.JFormattedTextField;

public class MyFormattedTextField extends JFormattedTextField{

	/**
	 * default constructor
	 * @param string - text that appears
	 * @param i - font size
	 */
	public MyFormattedTextField(String string, int i) {
		super(string);
		this.setFont(new MyFont(i));
		this.setPreferredSize(new Dimension(Size.defaultBtnWidth,Size.defaultBtnHeight));
	}

	private static final long serialVersionUID = 1L;
}
