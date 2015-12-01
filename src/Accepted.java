
public class Accepted extends Case {
	
	private int numLawyers;
	private String courthouseName;
	private int numDaysTrial;
	private Note[] notes;
	
	
	/**
	 * The default constructor for accepted cases
	 * that calls the superclass default constructor and 
	 * initializes the number of lawyers, courthouse name
	 * and number of days of the trial.
	 */
	public Accepted(){
		super();
		numLawyers  = 0;
		courthouseName = "";
		numDaysTrial = 0;
      notes = new Note[20];
		
	}
	
	public void setNotes(String information){
	   Note note = new Note();
      note.setNote(information);
      int n = note.getTotalNotes();
      notes[n] = note;
	}
	
	
	public Note[] getNotes(){
		return notes;
	}
	
	
	/**
	 * Sets the number of lawyers on the case;
	 * @param num
	 */
	public void setNumLawyers(int num){
		numLawyers = num;
		
	}
	
	/**
	 * The method sets the name of the courthouse
	 * @param court
	 */
	public void setCourthouseName(String court){
		courthouseName = court;
	}
	
	/**
	 * Sets the number of days of the trial 
	 * @param days
	 */
	public void setNumDaysTrial(int days){
		numDaysTrial = days;
	}
	
	/**
	 * The accessor method returns the number of lawyers
	 * @return
	 */
	public int getNumLawyers(){
		return numLawyers;
	}
	
	/**
	 * The accessor method returns the court house name 
	 * @return
	 */
	public String getCourthouseName(){
		return courthouseName;
	}
	
	/**
	 * The accessor method for returning the number of days of the trial. 
	 * @return
	 */
	public int getNumDaysTrial(){
		return numDaysTrial;
	}
	
	/**
	 *The accessor method returns a formatted string 
	 */
	public String toString(){
		return "NumLawyers: " + numLawyers + " Courthouse name:" +courthouseName + "Number of days trial is: " + numDaysTrial;
	}
	
}

	
