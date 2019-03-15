package objects;

import java.util.List;

/**
 * Scholarship class contains all attributes for scholarship
 * 
 * @author Steve Khanna
 *
 *
 */
public class Scholarship {

	/**
	 * Instance Variables
	 */
	private String name;
	private int scholarshipId;
	private double gpaRequirement;
	private String faculty;
	private int yearOfStudy;
	private String typeOfStudy;
	private String Department;
	private int numAllowed;
	private String description;
	private double money;
	
	private List<Integer> studentUcids;

	/**
	 * Default scholarship constructor
	 */
	public Scholarship() {
		this.name = "Sch1";
		this.scholarshipId = 1;
		this.gpaRequirement = 3.00;
		this.faculty = "Science";
		this.yearOfStudy = 3;
		this.typeOfStudy = "Bachelor";
		this.Department = "CPSC";
		this.numAllowed = 100;
		this.description = "This is a generic scholarship";
		this.setMoney(0.00);

	}
	
	/**
	 * Overloaded scholarship controller
	 * @param name 
	 * @param sId
	 * @param gReq
	 * @param faculty
	 * @param YOS
	 * @param TOS
	 * @param Dept
	 * @param nums
	 * @param desc
	 * @param money
	 * This is used when a new scholarship is created
	 */
	public Scholarship(String name, String sId, String gReq, String faculty, String YOS, String TOS, String Dept,
			String nums, String desc, String money,List<Integer> studentUcids) {
		this.name = name;
		this.scholarshipId = Integer.parseInt(sId);
		this.gpaRequirement = Double.parseDouble(gReq);
		this.faculty = faculty;
		this.yearOfStudy = Integer.parseInt(YOS);
		this.typeOfStudy = TOS;
		this.Department = Dept;
		this.numAllowed = Integer.parseInt(nums);
		this.description = desc;
		this.money = Double.parseDouble(money);
		this.studentUcids= studentUcids;

	}
	
	/**
	 * returnFull method
	 * @returns String of all scholarship attributes with colons separating them
	 */

	public String returnFull() {
		return (name + ":" + scholarshipId + ":" + gpaRequirement + ":" + faculty + ":" + yearOfStudy + ":"
				+ typeOfStudy + ":" + Department + ":" + numAllowed + ":" + description + ":" +money);
	}
	/**
	 * 
	 * The rest of the code contains getters and setters for each attribute
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public double getGpaRequirement() {
		return gpaRequirement;
	}

	public void setGpaRequirement(double gpaRequirement) {
		this.gpaRequirement = gpaRequirement;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
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
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public int getNumAllowed() {
		return numAllowed;
	}

	public void setNumAllowed(int numAllowed) {
		this.numAllowed = numAllowed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public boolean addStudent(int id) {
		if (studentUcids.contains(id)) {
			return false;
		}
		else {
			studentUcids.add(id);
			return true;
		}
	}
	
	@Override
	public String toString() {
		
		String listOfStudents = "";
		for(Integer i : studentUcids) {
			if(i== studentUcids.get(studentUcids.size()-1)) {
				listOfStudents += i+"";
			}
			else {
				listOfStudents += i+":";
			}
		}
		return (name + "," + scholarshipId + "," + gpaRequirement + "," + faculty + "," + yearOfStudy + ","
				+ typeOfStudy + "," + Department + "," + numAllowed + "," + description + "," +money+ "," +listOfStudents);
	}

}
