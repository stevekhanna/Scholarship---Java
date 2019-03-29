package objects;

/**
 * 
 * @author Pierce de Jong
 * User class contains all attributes for a generic user
 * i.e. not student or admin sub class 
 * Contains a methods to get and set each instance var
 *
 */

public class User {
	
	/**
	 * Instance Variable
	 */
	private String name;
	private String email;
	private String password;
	private int ucid;
	
	/**
	 * User constructor with the following constructor
	 * @param ucid
	 * @param email
	 * @param password
	 * @param name
	 */
	public User(int ucid, String email, String password, String name) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.ucid = ucid;
	}
	
	/**
	 * 
	 * Getter and setter methods for each instance variable
	 */
	
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUCID() {
		return ucid;
	}

}
