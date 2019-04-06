package objects;

import java.util.List;

/**
 * 
 * @author Pierce de Jong, Steve Khanna
 * 
 * Student class extends user class 
 * contains student constructor to make a new student
 * and return method for returning faculty of student
 *
 */
public class Student extends User{
	
	/**
	 * Instance Variable
	 */
	private String faculty;
	private double gpa;
	private int yearOfStudy;
	private String typeOfStudy;
	private String department;
	private List<Integer> scholarshipsAppliedTo = null;
	private List<Integer> scholarshipsAcceptedTo = null;
	private int[] scholarshipsWon;
	
	
	/**
	 * Student constructor with the following params  
	 * @param ucid
	 * @param email
	 * @param password
	 * @param name
	 * @param faculty
	 * @param gpa
	 * @param yearOfStudy
	 * @param typeOfStudy
	 * @param department
	 * @param scholarshipsAppliedTo
	 * @param scholarshipsAcceptedTo
	 * @param scholarshipsWon
	 */
	public Student(int ucid, String email, String password, String name, String faculty,
			double gpa, int yearOfStudy, String typeOfStudy, String department, List<Integer> scholarshipsAppliedTo, List<Integer> scholarshipsAcceptedTo, int[] scholarshipsWon) {
		super(ucid, email, password, name);
		this.faculty = faculty;
		this.gpa = gpa;
		this.yearOfStudy = yearOfStudy;
		this.typeOfStudy= typeOfStudy;
		this.department= department;
		this.scholarshipsAppliedTo=scholarshipsAppliedTo;
		this.scholarshipsAcceptedTo = scholarshipsAcceptedTo;
		this.scholarshipsWon = scholarshipsWon;
	}
	
	/**
	 * toFile method
	 * @return String containing attributes for student with
	 * colon separators
	 */
	public String toFile() {
		return getUCID()+":"+getEmail()+":"+getPassword()+":"+getName();
	}
	
	/**
	 * Getter method for faculty
	 * @return String containing the faculty of the student
	 */
	public String getFaculty() {
		return faculty;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getTypeOfStudy() {
		return typeOfStudy;
	}

	public void setTypeOfStudy(String typeOfStudy) {
		this.typeOfStudy = typeOfStudy;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Integer> getScholarshipsAppliedTo() {
		return scholarshipsAppliedTo;
	}
	/**
	 * Add scholarship to students "appliedto" list
	 * @param id of the scholarship to add
	 * @return boolean if successful or not
	 */
	public boolean addScholarship(int id) {
		if (scholarshipsAppliedTo.contains(id)) {
			return false;
		}
		else {
			scholarshipsAppliedTo.add(id);
			return true;
		}
	}
	/**
	 * Adds a new scholarship at priority set by student
	 * @param id of scholarship
	 * @param index where to add
	 * @return boolean if successful or not
	 */
	public boolean addScholarshipByPriority(int id, int index) {
		if (scholarshipsAppliedTo.contains(id)) {
			return false;
		}
		else {
			scholarshipsAppliedTo.add(index,id);
			return true;
		}
	}
	/**
	 * Change the scholarships priority
	 * @param id of the scholarship
	 * @param priority to change to
	 * @return boolean if successful or not 
	 */
	public boolean changeScholarshipPriority(int id, int priority) {
		if (scholarshipsAppliedTo.remove((Integer) id)) {
			scholarshipsAppliedTo.add(priority,id);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Remove scholarship from the students applied to
	 * @param id of the scholarship to remove
	 * @return if successful or not
	 */
	public boolean removeScholarship(int id){
		return scholarshipsAppliedTo.remove((Integer) id);
	}
	/**
	 * toString method to format everything properly to write to the file
	 */
	@Override
	public String toString() {
		String appliedToSch = "";
		if(scholarshipsAppliedTo != null) {
			for(Integer i : scholarshipsAppliedTo) {
				if(i== scholarshipsAppliedTo.get(scholarshipsAppliedTo.size()-1)) {
					appliedToSch += i+"";
				}
				else {
					appliedToSch += i+":";
				}
			}
		}
		String acceptedToSch = "";
		if(scholarshipsAcceptedTo != null) {
			for(Integer i : scholarshipsAcceptedTo) {
				if(i== scholarshipsAcceptedTo.get(scholarshipsAcceptedTo.size()-1)) {
					acceptedToSch += i+"";
				}
				else {
					acceptedToSch += i+":";
				}
			}
		}
		
		String schWon="";
		if (scholarshipsWon!=null) {
			schWon = scholarshipsWon[0]+":"+scholarshipsWon[1];
		}
		
		String returnString = getUCID()+","+getEmail()+","+getPassword()+","+getName()
		+","+faculty+","+gpa+","+yearOfStudy+","+typeOfStudy+","+department;
		
		if (appliedToSch.compareTo("")!=0) {
			returnString += "," + appliedToSch;
		}
		if(acceptedToSch.compareTo("")!=0) {
			returnString += "," + acceptedToSch;
		}
		if(schWon.compareTo("")!=0) {
			returnString +=","+schWon;
		}
		
		return returnString;
	}
	
}
