package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayLogin.*;
import myJStuff.MyController;
/**
 * Controller used to manage the login of students and admins
 * @author pierce
 *
 */
public class LoginController extends MyController {
	/**
	 * Instance variables
	 */
	
	private HomePanel hp;
	private AboutPanel ap;
	private LoginAdminPanel lap;
	private LoginStudentPanel lsp;
	
	private JPanel panelHome;
	private JPanel panelAbout;	
	private JPanel panelLoginAdmin;
	private JPanel panelLoginStudent;
	
	/**
	 * Constructor
	 *  and set the bounds.
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public LoginController(ActionListener globalListener,JFrame frame){
		super(globalListener, frame);
	}
	
	/**
	 * Starts the controller
	 * Initialize all of the panels
	 * Switch to the home panel
	 */
	public void start(){
		hp = new HomePanel(this);
		ap = new AboutPanel(this);
		lap = new LoginAdminPanel(this, globalListener);
		lsp = new LoginStudentPanel(this, globalListener);
		
		
		panelHome = hp.getContentPane();
		panelAbout = ap.getContentPane();
		panelLoginAdmin = lap.getContentPane();
		panelLoginStudent = lsp.getContentPane();
					
		switchPanel(panelHome);
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
			switchPanel(panelHome); 
			break;
		case "Back_LoginStudentPanel":
			switchPanel(panelHome); 
			break;
		case "LoginAdmin_HomePanel":
			lap.resetFields();
			switchPanel(panelLoginAdmin); 
			break;
		case "Back_AboutPanel":
			switchPanel(panelHome); 
			break;
		case "About_HomePanel":
			switchPanel(panelAbout); 
			break;
		case "LoginStudent_HomePanel":
			lsp.resetFields();
			switchPanel(panelLoginStudent);
			break;
		default:
			switchPanel(panelHome);
			break;
		}
       
	}
    
}
