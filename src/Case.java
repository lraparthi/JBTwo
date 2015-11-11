
public class Case {
	//initialize variables
	private int caseNumber;
	private String title;
	private String status;
	private static int totalCases;
	private Plaintiff plaintiff;
	
	//default constructor
	public Case(){
		caseNumber = 0;
		title = "";
		status = "";
		totalCases++;
		
	}
	
	/**	 
	 * @param caseNum
	 */
	public void setCaseNum(int caseNum){
		caseNumber = caseNum;
	}
	
	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * 
	 * @param name
	 * @param phone
	 * @param email
	 */
	public void setPlaintiff(String name, String phone, String email ){
		
		plaintiff = new Plaintiff(name, phone, email);
		
	}
	
	//set the status
	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	//get casenumber
	public int getCaseNum(){
		return caseNumber;
	}
	//get title
	public String getTitle(){
		return title;
	}
	
	/**
	 * returns the total amount of cases
	 * @return
	 */
	public static int getTotalCases() {
		return totalCases;
	}
	
	public Plaintiff getPlaintiff(){
		return plaintiff;
	}
	
	
	public String getStatus(){
		return status;
	}
	public String toString(){
		return "Case Number:" + caseNumber + "Status: " + status + " Title: " + title ;
	}
	
	
	
	
}
