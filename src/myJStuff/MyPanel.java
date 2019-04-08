package myJStuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author pierce
 * 
 * Abstract class that is used by all of the panels
 * Creates a MigLayout panel with a north, south, east, west, and center panels
 * These are used by the displayPanels to add lbls and buttons to the screen
 *
 */
public abstract class MyPanel {

	protected ActionListener packageListener;
	
	protected JPanel contentPane = new JPanel();
	protected JPanel north;
	protected JPanel south;
	protected JPanel west;
	protected JPanel east;
	protected JPanel center;
	
	protected final static String location = "src/resources/";
	
	
	// Height and width of the screen
	protected static final int width = 900;
	protected static final int height = 600;
	
	protected EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
	
	public MyPanel(){
		setTheme();
		
		contentPane.setBorder(emptyBorder);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.setName("MyPanel --- Rename your Panel");
		north = new JPanel();
		
		contentPane.add(north, BorderLayout.NORTH);
		north.setLayout(new MigLayout("", "[grow,center]", "[]"));
		
		west = new JPanel();
		contentPane.add(west, BorderLayout.WEST);
		
		east = new JPanel();
		contentPane.add(east, BorderLayout.EAST);
		
		center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new MigLayout("", "[grow]", "[]"));
		
		
		south = new JPanel();
		contentPane.add(south, BorderLayout.SOUTH);
		south.setLayout(new MigLayout("", "[][grow]", "[]"));
		
		setBackgroundColor(Colors.defaultBackgroundColor);
	}
	
	protected void setBackgroundColor(Color color){
		north.setBackground(color);
		south.setBackground(color);
		east.setBackground(color);
		west.setBackground(color);
		center.setBackground(color);
		contentPane.setBackground(color);
	}
	
	protected void addScrollToCenter() {
		JPanel NewScroller = new JPanel();
		NewScroller.add(center);
		JScrollPane scroller = new JScrollPane(NewScroller);
		//scroller.setPreferredSize(new Dimension(200,200));
		
	    contentPane.add(scroller);
	}
	
	protected void setTheme(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		   System.out.println("Nimbus theme is not found.");
		   e.printStackTrace();
		}
	}
	/**
	 * Getter
	 * @return JPanel - content pane
	 */
	public JPanel getContentPane(){
		return contentPane;
	}
}