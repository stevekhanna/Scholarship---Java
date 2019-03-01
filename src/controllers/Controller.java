package controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import myJStuff.Size;

public class Controller implements ActionListener{
	
	private JFrame frame;
	
	private MainController mc;
	private UserController uc;
	
	public Controller(){
		createFrame();
	}
	
	/** creates the controllers and file IO utility */
	public void run(){
		mc = new MainController(frame,this);
		uc = new UserController(frame,this);
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
		System.out.println(mc.getLoginStudentPanel().getEmail());
		System.out.println(mc.getLoginStudentPanel().getPassword());
		uc.start(mc.getLoginStudentPanel().getEmail());
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