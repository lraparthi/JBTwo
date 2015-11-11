//<<<<<<< HEAD
import javax.swing.JOptionPane;

/*The implementation class for the JavaBeaner's Law Firm.
The application class holds the array of case types, searches 
through cases, collects user input & login in information*/
public class LawFirm {
	
	public static final int MAXCASES = 1000;
	public static Case [] cases = new Case[MAXCASES];
	
	public static void main(String[] args){

	int choice = 0;
	String login = "";
	
	do {
		login = showLoginMenu();
		if (login.equals("")){
			
			choice = (int)JOptionPane.showInputDialog
					(null, "You have entered an incorrect password"
					+ " or username. Would you like to try again?", 
					"JavaBeaners Law Firm", JOptionPane.YES_NO_OPTION,
					null, args, JOptionPane.QUESTION_MESSAGE);
			if (choice != 0) {
				JOptionPane.showMessageDialog(null, "Goodbye!", "JavaBeaners Law Firm",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	} while (choice == 0 && login.equals(""));
	
	//if it is a secretarial type the user can
	//create new cases, see all cases, search the cases by certain criteria, 
	//and create text files based on her search results.
	int option = 0;
	do {
		if (login.equals("Secretary")) {
			option = secretaryMenu();
			if (option == 5) {
				option = 9999;
			}
		}
		else {
			option = adminMenu();
			if (option == 4) {
				option = 9999;
			}
		} 
			switch (option) {
			case 1 : addCase(cases);
					break;
			case 2: edit(cases);
					break;
			case 3: search();
					break;
			case 4: print(cases);
				break;
			case 9999:
				JOptionPane.showMessageDialog(null, "Goodbye!");
				break;
			}
	} while(option == 9999);
}

	/**
	 * This method creates a user object & gets the username & password. 
	 * @return
	 */
	private static String showLoginMenu() {
		String userName = "";
		int menuError = 0;
		
		//gets the user input for the username. 
		do {
			try { 
				userName = JOptionPane.showInputDialog(null, "Please enter your username:", 
				"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE);
				menuError = 1;
				if (userName.equals("")) {
					throw new NullPointerException();
				}
			}
			//the program asks for a username until 
			catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Goodbye!", "JavaBeaners Law Firm", 
				JOptionPane.INFORMATION_MESSAGE);
				menuError = 0;
			}
		} while(menuError == 0);
		//Creates a new user object that takes in a username and password
		
		String password = "";
		//gets user input for the password
		do {
			try { 
				password = JOptionPane.showInputDialog(null, "Please enter your password:", 
				"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE);
				menuError = 1;
				if (password.equals("")) {
					throw new NullPointerException();
				}
			}
			catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Goodbye!", "JavaBeaners Law Firm", 
				JOptionPane.INFORMATION_MESSAGE);
				menuError = 0;
			}
		} while(menuError == 0);
		boolean error;
		//the method in user is created that checks credientals
		User user = new User(userName, password);
		error = user.checkCredentials();
		if (error = false) {
			return "";
		}
		else {
			//Calls the method to set the type of user that 
			String type = user.getType();
			return type;
		}
	}
	
	private static int secretaryMenu() {
		int choice = 0;
		boolean error = false;
		do {
			try { 
				choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"Please choose an option from the list:"
				+ "\n1.Create New Case \n2.Edit Case \n3.Search Cases \n4.Print \5. Exit", 
				"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE));
				error = false;
				if (choice < 1 || choice > 5) {
					throw new IndexOutOfBoundsException();
				}
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,  "Please enter a valid #", 
				"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
				error = true;
			}
			catch(IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null,  "Please enter a valid #", 
				"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
				error = true;
			}
			catch(NullPointerException e) {
				break;
			}
		} while(error = true);
		return choice;
	}
	
	private static int adminMenu() {
		int choice = 0;
		boolean error = false;
		do {
			try { 
				choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"Please choose an option from the list:"
				+ "1.Edit Case \n2.Search Cases \n3.Print 4.Exit", 
				"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE));
				error = false;
				if (choice < 1 || choice > 4) {
					throw new IndexOutOfBoundsException();
				}
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,  "Please enter a valid #", 
				"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
				error = true;
			}
			catch(IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null,  "Please enter a valid #", 
				"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
				error = true;
			}
			catch(NullPointerException e) {
				break;
			}
		} while(error = true);
		return choice;
	}
	
	
	private static void addCase(Case [] cases) {
		Case theCase = new Case();
		int num = 0;
		if (theCase.getTotalCases() > cases.length) {
			JOptionPane.showMessageDialog(null,  "You cannot add anymore cases!", 
			"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		else {
			boolean error = false;
			do {
				try {
					num = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"Please enter the case number:", 
					"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE));
					error = false;
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,  "Please enter a valid #", 
					"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
					error = true;
				}
				catch(NullPointerException e) {
				break;
				}
			} while(error = true);
			theCase.setCaseNum(num);
			String title ="";
			do {
				try {
					title = JOptionPane.showInputDialog(null, 
					"Please enter the case title:", 
					"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE);
					error = false;
					if (title == null) {
						error = true;
						JOptionPane.showMessageDialog(null,  "Please enter a valid title", 
						"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				catch(NullPointerException e) {
				break;
				}
			} while(error == true);
			theCase.setTitle(title);
			do {
				try {
					title = JOptionPane.showInputDialog(null, 
					"Please enter the case title:", 
					"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE);
					error = false;
					if (title == null) {
						error = true;
						JOptionPane.showMessageDialog(null,  "Please enter a valid title", 
						"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				catch(NullPointerException e) {
				break;
				}
			} while(error == true);
			theCase.setTitle(title);
			int status = 0; 
			do {
				try {
					status = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"Please enter a case status: \n1.Accepted"
					+ "\n2.Rejected\3.Pending", 
					"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE));
					error = false;
					if (status < 0 || status > 3) {
						error = true;
						JOptionPane.showMessageDialog(null,  "Please enter a valid option", 
						"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
						throw new IndexOutOfBoundsException();
						
					}
				}
				catch(NullPointerException e) {
				break;
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,  "Please enter a valid option", 
					"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
				}
				catch(IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,  "Please enter a valid option", 
					"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
				}
			} while(error == true);
			switch (status) {
			case 1: 
				theCase.setStatus("Accepted");
				break;
			case 2:
				theCase.setStatus("Rejected");
				break;
			case 3:
				theCase.setStatus("Pending");
				break;
			}
		}
	}
	
	public static void edit(Case [] cases) {
		//TO DO:
	}
	
	public static void search (){
		String searchResult = "";
		String response = "";
		String[] options = {"Case Number", "Plaintiff Name", "Lawyer's Name"};
		int selection = JOptionPane.showOptionDialog(null, "Select criteria to search by: ", null, 0, 3, null, options, null);
		switch(selection){
		case 0:
			//selected Case Number
			int caseNum = 0;
			while(true){
				response = JOptionPane.showInputDialog("Please enter the case number for the case you would like to find: ");
				try{
					caseNum = Integer.parseInt(response);
					break;
				}catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Case number must be in numberic form!");
				}
			}
			for (int i = 0; i < Case.getTotalCases(); i++){
				if (cases[i].getCaseNum() == caseNum){
					searchResult = cases[i].toString();
					break;
				}
			}
			break;
		case 1:
			//selected Plaintiff Name
			response = JOptionPane.showInputDialog("Please enter the name of the plaintiff you wish to find cases for: ");
			for (int i = 0; i < Case.getTotalCases(); i++){
				if (((cases[i].getPlaintiff()).getName()).equalsIgnoreCase(response.trim())){
					searchResult += cases[i].toString() + "\n";
				}
			}
			break;
		case 2:
			//selected Lawyer's Name
			response = JOptionPane.showInputDialog("Please enter the name of Lawyer you wish to find notes for: ");
			for (int i = 0; i < Case.getTotalCases(); i++){
				if (cases[i].getStatus().equals("Accepted")){
					Accepted aCase = (Accepted) cases[i];
					for(int z = 0; z < aCase.getNumLawyers(); z++){
						for (Note note : aCase.getNotes()){
							if(note.getLawyer().equalsIgnoreCase(response)){
								searchResult += note.toString() + "\n";
							}
						}
					}					
				}
			}
			break;
		default:
			//selected x button
			return;
		}
		
		if (searchResult.equals("")){
			System.out.println("No matches found!");
		}else{
			System.out.println(searchResult);
		}
	}

	public static void print(Case [] cases) {
		//TO DO:
	}
}


