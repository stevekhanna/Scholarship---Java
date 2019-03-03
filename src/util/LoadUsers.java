package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import objects.*;

public class LoadUsers{
	/**
	 * Instance variables
	 */
	private List<Student> students;
	private List<Admin> admins;

	private final String studentFile = "src/data/students.txt";
	private final String adminFile = "src/data/admins.txt";
	
	/**
	 * default constructor
	 */
	public LoadUsers(){
	}
	
	public List<Student> loadStudents(){
		students = new ArrayList<>();
		try {
			System.out.println("Loading Student data from file: "+studentFile);
			Scanner fileScanner = new Scanner(new File(studentFile));
			while(fileScanner.hasNextLine()){
				String currentLine = fileScanner.nextLine();
				String[] parts = currentLine.split(":");
				students.add(new Student(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3]));
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error:" +e);
		}
		return students;
	}
	
	public List<Admin> loadAdmins(){
		admins = new ArrayList<>();
		try {
			System.out.println("Loading Admin data from file: "+adminFile);
			Scanner fileScanner = new Scanner(new File(adminFile));
			while(fileScanner.hasNextLine()){
				String currentLine = fileScanner.nextLine();
				String[] parts = currentLine.split(":");
				admins.add(new Admin(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3]));
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error:" +e);
		}
		return admins;
	}
}