package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayMain.*;

public class MainController implements ActionListener {
	/**
	 * Instance variables
	 */
	
	private ActionListener globalListener;
	
	private JFrame frame;
	
	private MainPanel mp;
	private AboutPanel ap;
	private LoginAdminPanel lap;
	private LoginStudentPanel lsp;
	
	private JPanel panelMain;
	private JPanel panelAbout;	
	private JPanel panelLoginAdmin;
	private JPanel panelLoginStudent;
	
	/**
	 * Constructor with two arguments.
	 * This constructor will initialize the frame and actionListener
	 *  and set the bounds.
	 * @param frame 
	 * @param globalListener
	 */
	public MainController(JFrame frame, ActionListener globalListener){
		//listener = new Listener();
		this.globalListener = globalListener;		
		//setting up the frame 
		this.frame = frame;
	}
	
	/**
	 * This method will initialize all the panels 
	 * related to the main menu.
	 */
	public void start(){
		mp = new MainPanel(this,globalListener);
		ap = new AboutPanel(this);
		lap = new LoginAdminPanel(this);
		lsp = new LoginStudentPanel(this);
		
		
		panelMain = mp.getContentPane();
		panelAbout = ap.getContentPane();
		panelLoginAdmin = lap.getContentPane();
		panelLoginStudent = lsp.getContentPane();
					
		switchPanel(panelMain);
		//Uncomment this to remove the test button from the main panel
		//mp.hideTestButton();
	}
	
	/**
	 * This method will switch the frame to the passed JPanel
	 * Sets current content pane to invisible
	 * Sets the frame to the new JPanel
	 * Sets new content pane to visible
	 * @param panel
	 */
	private void switchPanel(JPanel panel){
		System.out.println("SWITCHING: "+panel.getName());
		frame.getContentPane().setVisible(false);
		frame.setContentPane(panel);
		frame.getContentPane().setVisible(true);
	}
	
	
	/**
	 * This method will assign an action to each button in the displayMain Package
	 * When a button is pressed, the name String of the button is stored as a local variable
	 * A switch statement is used to compare the name with other string values 
	 * to find the correct button.
	 * @param e, ActionEvent e
	 */
	public void actionPerformed(ActionEvent e){
		//Gets the name (NOT TEXT) of the button that was pressed
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		//Finds the button that was pressed and does the needed commands
		switch(name){
		case "Back_LoginAdminPanel":
			switchPanel(panelMain); 
			break;
		case "Back_LoginStudentPanel":
			switchPanel(panelMain); 
			break;
		case "LoginAdmin_MainPanel":
			switchPanel(panelLoginAdmin); 
			break;
		case "Back_AboutPanel":
			switchPanel(panelMain); 
			break;
		case "About_MainPanel":
			switchPanel(panelAbout); 
			break;
		case "LoginStudent_MainPanel":
			switchPanel(panelLoginStudent);
			break;
		default:
			switchPanel(panelMain);
			break;
		}
       
	}
    
}
