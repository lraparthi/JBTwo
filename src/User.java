
public class User {
	
		private static String username;
		private static final String [] USERNAMES = {"Debby", "Polymorphism", "Java", "Bean", "Constructor"};
		private static final String [] PASSWORDS = {"IloveJAVA", "abstract", "password123", "01121994", "constructMe"};
		
		
	
		public static boolean exists(String un, String pw){
			for(int i = 0; i< USERNAMES.length; i++){
				if (un.equals(USERNAMES[i])){
					if(pw.equals(PASSWORDS[i])){
						username = un;
						return true;
					}else{
						return false;
					}
				}
			}
			return false;
		}
		
		
		
		public static String getType(){
			if (username.equals(USERNAMES[0])) {
				return("Secretary");
			}
			else {
				return("Administrator");
			}
		}
	
	}
