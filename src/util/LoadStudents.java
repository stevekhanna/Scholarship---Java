package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import userInfo.*;

public class LoadStudents{
	/**
	 * Instance variables
	 */
	private List<User> students;

	private final String file = "src/data/students.txt";
	
	/**
	 * default constructor
	 */
	public LoadStudents(){
	}
	
	public List<User> loadStudents(){
		students = new ArrayList<>();
		try {
			System.out.println("Loading Student data from file: "+file);
			Scanner fileScanner = new Scanner(new File(file));
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
}