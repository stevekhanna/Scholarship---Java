package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayMain.*;
/**
 * Controller used to manage the login of students and admins
 * @author pierce
 *
 */
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
	 * Constructor
	 *  and set the bounds.
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public MainController(JFrame frame, ActionListener globalListener){
		//listener = new Listener();
		this.globalListener = globalListener;		
		//setting up the frame 
		this.frame = frame;
	}
	
	/**
	 * Starts the controller
	 * Initialize all of the panels
	 * Switch to the main panel
	 */
	public void start(){
		mp = new MainPanel(this);
		ap = new AboutPanel(this);
		lap = new LoginAdminPanel(this, globalListener);
		lsp = new LoginStudentPanel(this, globalListener);
		
		
		panelMain = mp.getContentPane();
		panelAbout = ap.getContentPane();
		panelLoginAdmin = lap.getContentPane();
		panelLoginStudent = lsp.getContentPane();
					
		switchPanel(panelMain);
	}
	
	/**
	 * Sets the fram to a new JPanel
	 * @param panel - JPanel
	 */
	private void switchPanel(JPanel panel){
		System.out.println("SWITCHING: "+panel.getName());
		frame.getContentPane().setVisible(false);
		frame.setContentPane(panel);
		frame.getContentPane().setVisible(true);
	}
	
	/**
	 * Get the LoginStudentPanel panel
	 * @return - LoginStudentPanel
	 */
	public LoginStudentPanel getLoginStudentPanel() {
		return lsp;
	}
	/**
	 * Get the LoginAdminPanel
	 * @return LoginAdminPanel
	 */
	public LoginAdminPanel getLoginAdminPanel() {
		return lap;
	}
	
	
	/**
	 * ActionListener that does something when a button is pressed that is assigned top this action listener
	 * Any buttons that are assigned to the package listener
	 */
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton)e.getSource();
		String name = source.getName();
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
