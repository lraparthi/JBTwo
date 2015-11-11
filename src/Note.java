
public class Note {

	private String note;
	private String lawyer;
	
	/**
	 * Sets the note contents variable
	 * @param note
	 */
	public void setNote(String note){
		this.note = note;
	}
	
	/**
	 * Sets the lawyer variable
	 * @param lawyer
	 */
	public void setLawyer (String lawyer){
		this.lawyer = lawyer;
	}
	
	/**
	 * Returns the note variable
	 * @return
	 */
	public String getNote(){
		return note;
	}
	
	/**
	 * Returns the lawyer variable
	 * @return
	 */
	public String getLawyer(){
		return lawyer;
	}
	
	/**
	 * Returns the contents of the object in a formatted string.
	 */
	public String toString(){
		return lawyer + ": " + note;
	}
	
}
