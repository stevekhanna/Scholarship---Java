package myJStuff;

import java.awt.Font;

public class MyFont extends Font{
	private static final long serialVersionUID = 1L;
	/**
	 * Set the font with a specific int size
	 * @param size
	 */
	public MyFont(int size) {
		super(makeFont(), Font.PLAIN, size);
	}
	
	private static String makeFont() {
		String OS = System.getProperty("os.name").toLowerCase();
		if(OS.indexOf("mac")>=0) {
			return "Avenir";
		}else if (OS.indexOf("win")>=0) {
			return "Malgun Gothic";
		}else {
			return "NanumGothic";
		}
	}
}