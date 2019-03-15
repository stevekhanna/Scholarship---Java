package util;

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
	
	public void writeStudents(){
		// write all of the students to the file
	}
	
	public void saveStudent(Student student) {
		// override the correct student in the list of students
	}
	
	public void writeAdmins() {
		
	}
	
	public void saveAdmin(Admin a) {
		
	}
	
	public void writeScholarships() {
		
	}
	
	public void saveScholarship(Scholarship scholarship) {
		
	}
}
