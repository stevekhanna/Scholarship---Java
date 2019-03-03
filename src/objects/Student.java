package objects;

public class Student extends User{
	
	private String faculty;
	
	public Student(int ucid, String email, String password, String name) {
		super(ucid, email, password, name);
	}
	
	public String toFile() {
		return getUCID()+":"+getEmail()+":"+getPassword()+":"+getName();
	}
	
	
	public String getFaculty() {
		return faculty;
	}
}
