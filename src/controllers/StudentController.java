package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayStudent.*;
import objects.*;

public class StudentController implements ActionListener {
	
	private ActionListener globalListener;
	private JFrame frame;
	
	private StudentPanel sp;
	
	private Student currentStudent;
	
	private JPanel studentPanel;
	
	public StudentController(JFrame frame, ActionListener globalListener) {
		this.globalListener = globalListener;
		this.frame = frame;
	}
	
	public void start(Student currentUser) {
		this.currentStudent = currentStudent;
		sp = new StudentPanel(this, globalListener);
		studentPanel = sp.getContentPane();
		
		switchPanel(studentPanel);
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
