package util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import objects.*;

public class Util {
	
	private List<Student> students;
	private List<Admin> admins;
	private HashMap<Integer, Scholarship> scMap; 
	
	private final String studentFile = FileLocations.studentFile;
	private final String adminFile = FileLocations.adminFiles;
	private final String scholarshipFile = FileLocations.scholarshipFile;
	
	
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
			for(Student student: students) {
				writer.println(student.toString());
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("File could not be writted properly");
		}
	}
	/**
	 * Checks which student to rewrite and sets the new correct attributes
	 * @param student
	 */
	public void saveStudent(Student student) {
		// override the correct student in the list of students
		int id = student.getUCID();
		for(Student s: students) {
			if (s.getUCID() == id) {
				//change that value
				s = student;
				
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
			for(Admin admin: admins) {
				writer.println(admin.toString());
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("File could not be writted properly");
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
				a = admin;
				
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
			for(int i = 0; i<scMap.size(); i++) {
				writer.println(scMap.get(i).toString());
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("File could not be writted properly");
		}
	}
	
	
	
	
	public void saveScholarship(Scholarship scholarship) {
		int id = scholarship.getScholarshipId();
		scMap.put(id, scholarship);
		writeScholarships();
	}
}
