package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayAdmin.*;
import objects.*;

public class AdminController implements ActionListener {
	
	private ActionListener globalListener;
	private JFrame frame;
	
	private AdminPanel ap;
	
	private Admin currentAdmin;
	
	private JPanel adminPanel;
	
	public AdminController(JFrame frame, ActionListener globalListener) {
		this.globalListener = globalListener;
		this.frame = frame;
	}
	
	public void start(Admin currentAdmin) {
		this.currentAdmin = currentAdmin;
		ap = new AdminPanel(this, globalListener);
		adminPanel = ap.getContentPane();
		
		switchPanel(adminPanel);

	}

	private void switchPanel(JPanel panel){
		System.out.println("SWITCHING: "+panel.getName());
		frame.getContentPane().setVisible(false);
		frame.setContentPane(panel);
		frame.getContentPane().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		switch(name) {
		case "":
			break;
		default:
			break;
		}
	}
	

}
