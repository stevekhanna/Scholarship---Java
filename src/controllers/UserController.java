package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayMain.AboutPanel;
import displayUser.*;

public class UserController implements ActionListener {
	
	private ActionListener globalListener;
	private JFrame frame;
	
	private ShowPanel sp;
	
	
	private JPanel showPanel;
	
	public UserController(JFrame frame, ActionListener globalListener) {
		this.globalListener = globalListener;
		this.frame = frame;
	}
	
	public void start(String name) {
		sp = new ShowPanel(this, globalListener);
		
		showPanel = sp.getContentPane();
		sp.setLblLoggedin(name);
		switchPanel(showPanel);
		
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
