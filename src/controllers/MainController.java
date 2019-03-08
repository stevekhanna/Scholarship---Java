package controllers;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import myJStuff.*;
import objects.*;
import util.*;

public class MainController implements ActionListener{
	
	private JFrame frame;
	
	private LoginController lc;
	private StudentController sc;
	private AdminController ac;

	private List<Student> students;
	private List<Admin> admins;
	private HashMap<Integer, Scholarship> scMap;
	
	private Admin currentAdmin;
	private Student currentStudent;
	
	public MainController(){
		createFrame();
	}
	
	public void run(){
		lc = new LoginController(this,frame);
		sc = new StudentController(this,frame);
		ac = new AdminController(this,frame);
		
		LoadData ld = new LoadData();
		students = ld.loadStudents();
		admins = ld.loadAdmins();
		scMap = ld.loadScholarships();
		
		
		lc.start();
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
		String email=lc.getLoginStudentPanel().getEmail();
		String password = lc.getLoginStudentPanel().getPassword();
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
		String email=lc.getLoginAdminPanel().getEmail();
		String password = lc.getLoginAdminPanel().getPassword();
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
				sc.start(currentStudent, scMap);
			}
			break;
		case"Login_LoginAdminPanel":
			if(checkAdminLogin()) {
				ac.start(currentAdmin, scMap);
			}
			break;
		case"Logout_AdminPanel":
			currentAdmin=null;
			currentStudent=null;
			lc.start();
		case"Logout_StudentPanel":
			currentAdmin=null;
			currentStudent=null;
			lc.start();
		default:break;
		}
	}
}