package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import objects.*;

public class LoadData{
	/**
	 * Instance variables
	 */
	private List<Student> students;
	private List<Admin> admins;
	private HashMap<Integer, Scholarship> scMap; 
	private final String studentFile = "src/data/students.txt";
	private final String adminFile = "src/data/admins.txt";
	private final String scholarshipFile ="src/data/scholarships.txt";
	/**
	 * default constructor
	 */
	public LoadData(){
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
	
	public HashMap<Integer, Scholarship> loadScholarships(){
		scMap = new HashMap<Integer, Scholarship>();
		try {
			System.out.println("Loading Scholarship data from file: "+scholarshipFile);
			Scanner fileScanner = new Scanner(new File(scholarshipFile));
			while(fileScanner.hasNextLine()) {
				String currentLine = fileScanner.nextLine();
				currentLine = currentLine.replaceAll("\t", ":");
				String [] parts = currentLine.split(":");
				Scholarship name = new Scholarship(parts[0], parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8]);
				int ID = name.getScholarshipId();
				scMap.put(ID, name);
			}
			fileScanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error:" +e);
		}
		return scMap;
	}
}