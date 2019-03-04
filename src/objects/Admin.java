package objects;

/**
 * Admin class that extends user class
 * contains constructor to make a new instance of admin
 * @author Pierce de Jong
 *
 */

public class Admin extends User{
	
	/**
	 * Admin constructor with the following params
	 * @param ucid
	 * @param email
	 * @param password
	 * @param name
	 */
	public Admin(int ucid, String email, String password, String name) {
		super(ucid, email, password, name);
	}
	/**
	 * toFile method
	 * @returns String with colon separators 
	 * all the attributes of that instance
	 */
	public String toFile() {
		return getUCID()+":"+getEmail()+":"+getPassword()+":"+getName();
	}
	
}
