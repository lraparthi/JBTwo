
public class User {

	private String username;
	private String password;
	private String type;
	private static final String [] USERNAMES = {"Debby", "Polymorphism", "Java", "Bean", "Constructor"};
	private static final String [] PASSWORDS = {"IloveJAVA", "abstract", "password123", "01121994", "constructMe"};
	
	
	/**
	 * The constructor that takes in a username and password
	 * @param username
	 * @param password
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	/**
	 * The mutator method that sets the user type.
	 * @param t
	 */
	public void setType(String t){
		this.type = t;
	}
	
	/**
	 * The accessor method that returns the user type.
	 * @return
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * The method that returns a formatted string of the 
	 * contents. 
	 */
	public String toString(){
		return "Username: " + username + "Password: " + password;
	}
	
	/**
	 * This method checks the username & password credentials 
	 * to find a legitimate user.
	 * @return
	 */
	public boolean checkCredentials() {
		boolean pass = false;
		for(int i = 0; i < USERNAMES.length; i++) { 
			if (username.equals(USERNAMES[i])) {
				pass = true;
				break;
			}
		}
		if (pass == false) {
			return false;
		}
		pass = false;
	for(int i = 0; i < PASSWORDS.length; i++) { 
		if (password.equals(PASSWORDS[i])) {
			pass = true;
			break;
		}
	}
	if (pass == false) {
		return false;
	}
	else {
		if (username.equals(USERNAMES[0])) {
			setType("Secretary");
		}
		else {
			setType("Administrator");
		}
		return true;
	}
	}
}
