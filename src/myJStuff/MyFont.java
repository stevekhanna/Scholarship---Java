package myJStuff;

import java.awt.Font;

public class MyFont extends Font{
	private static final long serialVersionUID = 1L;
	/**
	 * Set the font with a specific int size
	 * @param size
	 */
	public MyFont(int size) {
		super("Georgia", Font.PLAIN, size);
	}
}