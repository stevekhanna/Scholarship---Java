package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import objects.*;


/**
 * 
 * @authors Steve Khanna Pierce de Jong
 * Load Data class contains methods that initializes all necessary data
 * read from txt files and makes it available for other classes to use
 *
 */
public class LoadData{
	/**
	 * Instance variables
	 */
	protected List<Student> students;
	private List<Admin> admins;
	private HashMap<Integer, Scholarship> scMap; 
	private final String studentFile = FileLocations.studentFile;
	private final String adminFile = FileLocations.adminFiles;
	private final String scholarshipFile = FileLocations.scholarshipFile;
	/**
	 * default constructor
	 */
	public LoadData(){
	}
	
	/**
	 * Load Student method loads all student data from text file
	 * @return List of type student containing all info about 
	 * students.
	 * @catch File not found exception if file does not exist
	 */
	
	public List<Student> loadStudents(){
		students = new ArrayList<>();
		try {
			System.out.println("Loading Student data from file: "+studentFile);
			Scanner fileScanner = new Scanner(new File(studentFile));
			String ignoreLine = fileScanner.nextLine();
			while(fileScanner.hasNextLine()){
				String currentLine = fileScanner.nextLine();
				if (currentLine.isEmpty())break;
				String[] parts = currentLine.split(",");
				List<Integer> scholarshipsAppliedTo = new ArrayList<Integer>();
				if (parts.length>9) {
					String[] queue = parts[9].split(":");
					for(int i =0; i<queue.length; i++) {
						scholarshipsAppliedTo.add(Integer.parseInt(queue[i]));
					}
				}
				else {
					scholarshipsAppliedTo=new ArrayList<Integer>();
				}
				
				students.add(new Student(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],
						parts[4],(Double.parseDouble(parts[5])),(Integer.parseInt(parts[6])),
						parts[7],parts[8],scholarshipsAppliedTo));
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error:" +e);
		}
		return students;
	}
	
	/**
	 * Load Admins method loads all admin data from text file
	 * @return List of type admins containing all info about 
	 * admins.
	 * @catch File not found exception if file does not exist
	 */
	
	public List<Admin> loadAdmins(){
		admins = new ArrayList<>();
		try {
			System.out.println("Loading Admin data from file: "+adminFile);
			Scanner fileScanner = new Scanner(new File(adminFile));
			String ignoreLine = fileScanner.nextLine();
			while(fileScanner.hasNextLine()){
				String currentLine = fileScanner.nextLine();
				if (currentLine.isEmpty())break;
				String[] parts = currentLine.split(",");
				admins.add(new Admin(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3]));
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error:" +e);
		}
		return admins;
	}
	
	/**
	 * Load Scholarships method loads all scholarship data from text file
	 * @return HashMap of type <Integer, Scholarship> with key = ID 
	 * pertaining to a specific scholarship and value = the scholarship itself
	 * @catch File not found exception if file does not exist
	 */
	public HashMap<Integer, Scholarship> loadScholarships(){
		scMap = new HashMap<Integer, Scholarship>();
		try {
			System.out.println("Loading Scholarship data from file: "+scholarshipFile);
			Scanner fileScanner = new Scanner(new File(scholarshipFile));
			String ignoreLine = fileScanner.nextLine();
			while(fileScanner.hasNextLine()) {
				String currentLine = fileScanner.nextLine();
				if (currentLine.isEmpty())break;
				String [] parts = currentLine.split(",");
				List<Integer> studentUcids = new ArrayList<Integer>();
				if (parts.length>10) {
					String[] queue = parts[10].split(":");
					for(int i =0; i<queue.length; i++) {
						studentUcids.add(Integer.parseInt(queue[i]));
					}
				}
				else {
					studentUcids=new ArrayList<Integer>();
				}
				Scholarship name = new Scholarship(parts[0], parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8],parts[9],studentUcids);
				int ID = name.getId();
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