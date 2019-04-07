package controllers;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import myJStuff.*;
import objects.*;
import util.*;

public class MainController implements ActionListener{
	
	private JFrame frame;
	
	private LoginController lController;
	private StudentController sController;
	private AdminController aController;

	private List<Student> students;
	private List<Admin> admins;
	private HashMap<Integer, Scholarship> scMap;
	
	private Admin currentAdmin;
	private Student currentStudent;
	
	private Util util;
	
	public MainController(){
		createFrame();
	}
	
	public void run(){
		lController = new LoginController(this,frame);
		sController = new StudentController(this,frame);
		aController = new AdminController(this,frame);
		
		loadData();
		
		// Start the login controller
		lController.start();
		
		// Create an instance of the saveUtil class
		util = new Util(students,admins,scMap);
	}
	
	/**
	 * Load all of the data from the CSV files
	 */
	private void loadData() {
		LoadData ld = new LoadData();
		students = ld.loadStudents();
		admins = ld.loadAdmins();
		scMap = ld.loadScholarships();
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
		String email=lController.getLoginStudentPanel().getEmail();
		String password = lController.getLoginStudentPanel().getPassword();
		for( Student s : students) {
			if (s.getEmail().equalsIgnoreCase(email) && s.getPassword().equals(password)) {
				System.out.println("Success");
				currentStudent = s;
				currentAdmin = null;
				return true;
			}
		}
		Object[] okOption = { "OK" };
		JOptionPane.showOptionDialog(null, "Invalid login. Please try again", "Inavlid",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, okOption, okOption[0]);
		System.out.println("Fail");
		return false;
	}
	
	private boolean checkAdminLogin() {
		System.out.print("Check Admin Login:  ");
		String email=lController.getLoginAdminPanel().getEmail();
		String password = lController.getLoginAdminPanel().getPassword();
		for( Admin s : admins) {
			if (s.getEmail().equalsIgnoreCase(email) && s.getPassword().equals(password)) {
				System.out.println("Success");
				currentAdmin = s;
				currentStudent = null;
				return true;
			}
		}
		Object[] okOption = { "OK" };
		JOptionPane.showOptionDialog(null, "Invalid login. Please try again", "Invalid",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, okOption, okOption[0]);
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
				sController.start(currentStudent, scMap, util);
			}
			break;
		case"Login_LoginAdminPanel":
			if(checkAdminLogin()) {
				aController.start(currentAdmin, scMap, students, util);
			}
			break;
		case"Scholarships_AdminPanel":
			//spc.start(true,scMap);
			break;
		case"Logout_AdminPanel":
			currentAdmin=null;
			currentStudent=null;
			loadData();
			lController.start();
		case"Logout_StudentPanel":
			currentAdmin=null;
			currentStudent=null;
			loadData();
			lController.start();
		default:break;
		}
	}
}