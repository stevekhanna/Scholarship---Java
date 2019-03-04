package objects;
/**
 * 
 * @author Pierce de Jong
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
	
	/**
	 * Student constructor with the following params  
	 * @param ucid
	 * @param email
	 * @param password
	 * @param name
	 */
	public Student(int ucid, String email, String password, String name) {
		super(ucid, email, password, name);
	}
	
	/**
	 * toFile method
	 * @return String containning attributes for student with
	 * colon seperators
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
}
