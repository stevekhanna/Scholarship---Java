package util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import objects.*;
/**
 * 
 * @authors Steve Khanna, Pierce de Jong
 * The Utility class for low coupling and high cohesion
 * This class is used for saving all objects to their particular files
 * once a change has been made. This is to make sure that when you delete a scholarship for example
 * it doesn't show up in the students applied to panel if they have applied for it prior to it being deleted
 *
 */
public class Util {
	
	private List<Student> students;
	private List<Admin> admins;
	private HashMap<Integer, Scholarship> scMap; 
	
	private final String studentFile = FileLocations.studentFile;
	private final String adminFile = FileLocations.adminFiles;
	private final String scholarshipFile = FileLocations.scholarshipFile;
	
	
	private final String studentFormat = "UCID,Email,Password,Name,Faculty,GPA,Year of study,Type of study,Department,Applied to";
	private final String adminFormat = "UCID,Email,Password,Name";
	private final String scholarshipFormat = "Name,ID,GPA,Faculty,Year of Study,Type of study,Department,Numbers allowed,Description,Money,Students applied";
	
	public Util(List<Student> students, List<Admin> admins, HashMap<Integer, Scholarship> scMap) {
		this.students = students;
		this.admins = admins;
		this.scMap = scMap;
	}
	/**
	 * Rewrites all data from the list of students to the correct file;
	 * This is to ensure that any type of changed data gets reloaded into
	 * database;
	 */
	public void writeStudents(){
		// write all of the students to the file
		try {
			PrintWriter writer = new PrintWriter(studentFile, "UTF-8");
			writer.println(studentFormat);
			for(Student student: students) {
				writer.println(student.toString());
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("File could not be written properly");
		}
	}
	/**
	 * Checks which student to rewrite and sets the new correct attributes
	 * @param student
	 */
	public void saveStudent(Student student) {
		// override the correct student in the list of students
		for(Student s: students) {
			if (s.getUCID() == student.getUCID()) {
				//change that value
				students.set(students.indexOf(s), student);
			}
		}
		writeStudents();
	}
	/**
	 * Rewrites all data from the list of admins to the correct file;
	 * This is to ensure that any type of changed data gets reloaded into
	 * database;
	 */
	public void writeAdmins() {
		try {
			PrintWriter writer = new PrintWriter(adminFile, "UTF-8");
			writer.println(adminFormat);
			for(Admin admin: admins) {
				writer.println(admin.toString());
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("File could not be written properly");
		}
	}
	
	
	/**
	 * Checks which admin to rewrite and sets the new correct attributes
	 * @param admin
	 */
	public void saveAdmin(Admin admin) {
		int id = admin.getUCID();
		for(Admin a : admins) {
			if (a.getUCID() == id) {
				//change that value
				admins.set(admins.indexOf(a), admin);
				//a = admin;
				
			}
		}
		writeAdmins();
	}
	
	
	/**
	 * Rewrites all data from the scMap to the correct file;
	 * This is to ensure that any type of changed data gets reloaded into
	 * database;
	 */
	public void writeScholarships() {
		try {
			PrintWriter writer = new PrintWriter(scholarshipFile, "UTF-8");
			writer.println(scholarshipFormat);
			for(int i : scMap.keySet()) {
				writer.println(scMap.get(i).toString());
			}
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("File could not be written properly");
		}
	}
	
	/**
	 * Deletes that scholarship and rewrites the students and scholarship file
	 * @param scholarship - the scholarship to delete
	 */
	public void deleteScholarship(Scholarship scholarship) {
		scMap.remove(scholarship.getId());
		if(scholarship.getStudentsApplied()!=null){
			for (int i: scholarship.getStudentsApplied()) {
				for(Student s : students) {
					if (s.getUCID() == i) {
						s.removeScholarship(scholarship.getId());
					}
				}
			}
		}
		writeScholarships();
		writeStudents();
	}
	
	
	/**
	 * Save scholarship in the map and write to scholarships file
	 * @param scholarship - the scholarship to save
	 */
	public void saveScholarship(Scholarship scholarship) {
		int id = scholarship.getId();
		System.out.println("LINE 154 in UTIL ---------------------> "+scholarship.toString());
		scMap.replace(id, scholarship);
		writeScholarships();
	}
}
