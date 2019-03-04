package controllers;

import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import myJStuff.*;
import objects.*;
import util.*;

public class Controller implements ActionListener{
	
	private JFrame frame;
	
	private MainController mc;
	private StudentController sc;
	private AdminController ac;

	private List<Student> students;
	private List<Admin> admins;
	
	private Admin currentAdmin;
	private Student currentStudent;
	
	public Controller(){
		createFrame();
	}
	
	public void run(){
		mc = new MainController(frame,this);
		sc = new StudentController(frame,this);
		ac = new AdminController(frame,this);
		
		LoadUsers lu = new LoadUsers();
		students = lu.loadStudents();
		admins = lu.loadAdmins();
		
		
		mc.start();
	}
	
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
	
	
	private boolean checkStudentLogin() {
		System.out.print("Check Student Login:  ");
		String email=mc.getLoginStudentPanel().getEmail();
		String password = mc.getLoginStudentPanel().getPassword();
		for( Student s : students) {
			if (s.getEmail().equalsIgnoreCase(email) && s.getPassword().equals(password)) {
				System.out.println("Success");
				currentStudent = s;
				return true;
			}
		}
		System.out.println("Fail");
		return false;
	}
	
	private boolean checkAdminLogin() {
		System.out.print("Check Admin Login:  ");
		String email=mc.getLoginAdminPanel().getEmail();
		String password = mc.getLoginAdminPanel().getPassword();
		for( Admin s : admins) {
			if (s.getEmail().equalsIgnoreCase(email) && s.getPassword().equals(password)) {
				System.out.println("Success");
				currentAdmin = s;
				return true;
			}
		}
		System.out.println("Fail");
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
		case"Login_LoginStudentPanel":
			if(checkStudentLogin()) {
				sc.start(currentStudent);
			}
			break;
		case"Login_LoginAdminPanel":
			if(checkAdminLogin()) {
				ac.start(currentAdmin);
			}
			break;
		case"Back_AdminPanel":
			currentAdmin=null;
			currentStudent=null;
			mc.start();
		case"Back_StudentPanel":
			currentAdmin=null;
			currentStudent=null;
			mc.start();
		default:break;
		}
	}
}