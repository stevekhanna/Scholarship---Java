package util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import objects.*;
/**
 * 
 * @author Steve Khanna Pierce de Jong
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
				//String[] entries = student.toString().split(",");
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
	
	
	public void deleteScholarship(Scholarship scholarship) {
		scMap.remove(scholarship.getScholarshipId());
		if(scholarship.getStudentsUcids()!=null){
			for (int i: scholarship.getStudentsUcids()) {
				for(Student s : students) {
					if (s.getUCID() == i) {
						s.removeScholarship(scholarship.getScholarshipId());
					}
				}
			}
		}
		writeScholarships();
		writeStudents();
	}
	
	
	
	public void saveScholarship(Scholarship scholarship) {
		int id = scholarship.getScholarshipId();
		scMap.put(id, scholarship);
		writeScholarships();
	}
}
