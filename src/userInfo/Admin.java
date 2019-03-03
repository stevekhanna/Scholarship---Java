package userInfo;

public class Admin extends User{

	private boolean admin;
	
	public Admin(int ucid, String email, String password, String name) {
		super(ucid, email, password, name);
		admin = true;
	}
	
	public String toFile() {
		return getUCID()+":"+getEmail()+":"+getPassword()+":"+getName();
	}
	
	
	public boolean isAdmin() {
		return admin;
	}
}
