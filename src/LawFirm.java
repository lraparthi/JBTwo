/*
 * Melanie Johnson
 * Haruka Konishi
 * Lehareen Raparthi
 * 
 */

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
		try {
         		login = showLoginMenu();
         		System.out.println(login);
		      	if (login == null){
		      	choice = (int)(JOptionPane.showConfirmDialog
			(null, "You have entered an incorrect password"
			+ " or username. Would you like to try again?", 
			"JavaBeaners Law Firm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
				if (choice != 0) {
					JOptionPane.showMessageDialog(null, "Goodbye!", "JavaBeaners Law Firm",
					JOptionPane.INFORMATION_MESSAGE);
					break;
				}
		      	}
      		}
      		catch(NullPointerException e) {
         		login = "";
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
			if (option == 5) {
				option = 9999;
			}
		} 
		
		
			switch (option) {
			case 1 : 
			       int n = cases[0].getTotalCases();
			       cases[n] = addCase(cases);
					
					System.out.println(cases[0].getTotalCases());
					break;
			case 2: edit(cases);
					break;
			case 3: search();
					break;
			case 4: print(cases);
				break;
			case 9999:
				JOptionPane.showMessageDialog(null, "Goodbye!");
				System.exit(0);
				
			default: 
				JOptionPane.showMessageDialog(null, "Please enter options 1-4 !");
			}
	} while( JOptionPane.showConfirmDialog(null, "Continue to the menu?") == JOptionPane.YES_OPTION);
}

	/**
	 * This method creates a user object & gets the username & password. 
	 * @return
	 */
	private static String showLoginMenu() {
		String userName="";
		String password="";
		String[] options = {"Try Again", "Quit"};
		while(true){
			userName = "";			
			//gets the user input for the username. 			
			while (userName.equals("")){
				userName = JOptionPane.showInputDialog(null, "Please enter your username:", 
				"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE);
				if (userName.equals("")){
					JOptionPane.showMessageDialog(null, "Please enter your username!");
				}
			}
			
			password = "";			
			//gets user input for the password
			while (password.equals("")){
				password = JOptionPane.showInputDialog(null, "Please enter your password:", 
				"JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE);
				if (password.equals("")){
					JOptionPane.showMessageDialog(null, "Please enter your password!");
				}
			}
			
			if(User.exists(userName, password)){
				break;
			}
			else{
				int choice = JOptionPane.showOptionDialog(null, "Account not found.  What would you like to do?", "poo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
				if (choice == 1){
					System.exit(0);
				}
			}
		}
		
		return User.getType();
	}
	
	private static int secretaryMenu() {
		int choice = 0;
		boolean error = false;
		do {
			try { 
				choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"Please choose an option from the list:"
				+ "\n1.Create New Case \n2.Edit Case \n3.Search Cases \n4.Print \n5. Exit", 
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
			/*catch(NullPointerException e) {
				error = true;
				break;
			}*/
			} while(error == true);
			return choice;
	}
	
	
	private static int adminMenu() {
		int choice = 0;
		boolean error = false;
		do {
			try { 
				choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"Please choose an option from the list:"
				+ "\n1.Edit Case \n2.Search Cases \n3.Print \n4.Exit", 
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
				return 5;
			}
		} while(error == true);
		return choice+1;
	}
	
	
	private static Case addCase(Case [] cases) {
		Case theCase = new Case();
		int num = 0;
		if (theCase.getTotalCases() > cases.length) {
			JOptionPane.showMessageDialog(null,  "You cannot add anymore cases!", 
			"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		else {
			boolean error = false;
			do {
				try {
					num = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"Please enter the case number:", "JavaBeaners Law Firm", JOptionPane.QUESTION_MESSAGE));
					System.out.println(error);
               for (int i = 0; i < cases[0].getTotalCases(); i++) {
                  if (num == cases[i].getCaseNum()) {
                     throw new IndexOutOfBoundsException();
                  }
               }
            }
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,  "Please enter a valid #", 
					"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
					error = true;
				}
				catch(NullPointerException e) {
				break;
				}
            catch (IndexOutOfBoundsException e) {
              JOptionPane.showMessageDialog(null,  "That case number has already been added.", 
					"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
					error = true;
            }
			} while(error);
			
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
			} while(error);
			theCase.setTitle(title);
			int status = 0; 
			do {
				try {
					status = Integer.parseInt(JOptionPane.showInputDialog(null, 
					"Please enter a case status: \n1.Accepted"
					+ "\n2.Rejected\n3.Pending", 
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
					JOptionPane.showMessageDialog(null,  "Please enter a valid option", 
					"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
            				String reason = "";
            				do {
        					reason = JOptionPane.showInputDialog(null, "Please enter the reason the case was rejected.",  
               					JOptionPane.QUESTION_MESSAGE);
               					if (reason.equals("")) {
                  					JOptionPane.showMessageDialog(null,  "Please enter a valid rejected reason", 
							"JavaBeaners Law Firm", JOptionPane.ERROR_MESSAGE);
               					}
            				} while( reason.equals(""));
        				theCase.setReason(reason);
					break;
			case 3:
				theCase.setStatus("Pending");
				break;
			}
		}
		return theCase;
	}

	
	public static void edit(Case [] cases) {
		String message = "Which case number would you like to edit";
		for (int x = 0; x < cases[0].getTotalCases(); x++) {
			int caseNum = cases[x].getCaseNum();
			message += "\n" + (x + 1) + ". " + caseNum;
		}
		boolean error;
		int option = 0;
		do {
			try { 
			option = Integer.parseInt(JOptionPane.showInputDialog(null, message));
			error = true;
			if (option < 0 || option > cases[0].getTotalCases()) {
				throw new IndexOutOfBoundsException();
			}
			}
			catch (NumberFormatException e) {
				error = false;
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
			}
			catch(IndexOutOfBoundsException e) {
				error = false;
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
			}
		} while(error == false);
		Case theCase = cases[option-1]; ////FIX XXXX
		error = false;
		int option1 = 0;
		do {
			try { 
				option1 = Integer.parseInt(JOptionPane.showInputDialog( 
				"What status would you like to change it to?" +
			    "\n1. Accepted \n2. Rejected"));
				error = false;
				if (option1 < 1 || option1 > 2) {
					throw new IndexOutOfBoundsException();
				}
			}
			catch (NumberFormatException e) {
				error = true;
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
			}
			catch (IndexOutOfBoundsException e) {
				error = true;
				JOptionPane.showMessageDialog(null, "Please enter a valid option");
			}
			
		} while (error);
		switch (option1) {
		case (0) : 
			if (theCase instanceof Accepted) {
				JOptionPane.showMessageDialog(null, "The case is already accepted.");
			}
			else {
				Accepted newCase = (Accepted) theCase; 
				JOptionPane.showMessageDialog(null, "The case has been updated to accepted.");
				int lawyer = 0;
				do {
					try {
					lawyer = Integer.parseInt(JOptionPane.showInputDialog
							("How many lawyers are in this case?"));
							error = false;
							if (lawyer <= 0 || lawyer > 10) {
								throw new IndexOutOfBoundsException();
							}
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter an actual number");
						error = true;
					}
					catch (IndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please enter a valid number");
						error = true;
					}
				} while (error == true);
				newCase.setNumLawyers(lawyer);
				int days = 0;
				do {
					try {
					lawyer = Integer.parseInt(JOptionPane.showInputDialog
							("How many number of days are in this case?"));
							error = false;
							if (days <= 0 || days > 10) {
								throw new IndexOutOfBoundsException();
							}
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter an actual number");
						error = true;
					}
					catch (IndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please enter a valid number of days");
						error = true;
					}
				} while (error == true);
				newCase.setNumDaysTrial(lawyer);
				String courthouseName;
				do {
					courthouseName = JOptionPane.showInputDialog
							("What is the courthouse name?");
							error = false;
							if (courthouseName.equals("")) {
								JOptionPane.showMessageDialog(null, "Please enter a courthouse name");
								error = true;
							}
				} while (error == true);
				newCase.setCourthouseName(courthouseName);
				cases[option-1] = newCase;
			break;
			}
		
		case (1) :
			if (theCase instanceof Rejected) {
				JOptionPane.showMessageDialog(null, "The case is already rejected.");
			}
			else {
				Rejected newCase = (Rejected) theCase; 
				String reason = "";
				JOptionPane.showMessageDialog(null, "The case has been updated to rejected.");
				do {
					reason = JOptionPane.showInputDialog
					("What is the rejected reason?");
					error = false;
					if (reason.equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter a reason");
						error = true;
					}
		} while (error == true);
			newCase.setReason(reason);
			cases[option-1] = newCase;
			}
		break;
		}
		
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
		String output = "";
		for (Case aCase: cases){
			if (aCase!=null){
				output+= aCase.toString() + "\n";			
			}
		}
		JOptionPane.showMessageDialog(null, output);
	}
}

/*
	public static void print(Case [] cases) throws FileNotFoundException {
		//TO DO:
		String output = "";
		for (Case aCase: cases){
			if (aCase!=null){
				output+= aCase.toString() + "\n";			
			}
		}
		String filename = "./src/allCases.txt";
		PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
		
		pw.write(output);
		pw.close();
		
		JOptionPane.showMessageDialog(null, output);
	}
}

*/
