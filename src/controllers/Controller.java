package controllers;

import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import myJStuff.*;
import util.*;
import userInfo.*;

public class Controller implements ActionListener{
	
	private JFrame frame;
	
	private MainController mc;
	private UserController uc;
	
	private List<User> students;
	
	public Controller(){
		createFrame();
	}
	
	/** creates the controllers and file IO utility */
	public void run(){
		mc = new MainController(frame,this);
		uc = new UserController(frame,this);
		
		LoadStudents ls = new LoadStudents();
		students = ls.loadStudents();
		mc.start();
	}
	
	/** algorithm to create the frame facilitating all panels */
	private void createFrame(){
		int width = Size.screenWidth;
		int height = Size.screenHeight;
		
		frame = new JFrame();
		// Set the position and size of the screen from top right(x pos, y pos, width, height)
		frame.setBounds(250, 100, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(300,300));
		frame.setVisible(true);
	}
	
	
	private boolean checkLogin() {
		String email=mc.getLoginStudentPanel().getEmail();
		String password = mc.getLoginStudentPanel().getPassword();
		for( User s : students) {
			if (s.getEmail().equalsIgnoreCase(email) && s.getPassword().equals(password)) {
				uc.start(mc.getLoginStudentPanel().getEmail());	
			}
		}
		return false;
	}

	/**
	 * Action listener that switches panels based on the button clicked
	 * @param e - Action Event
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		
		switch(name){
		
		/** initializes a new game */
		case"Login_LoginStudentPanel":
			/** Starts the SetUpController */
			checkLogin();
			break;
		case"Back_ShowPanel":
			mc.start();
		default:break;
		}
	}
}