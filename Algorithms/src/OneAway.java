
public class OneAway {

	public static boolean isOneAway(String a, String b) {
		if (a.length() - b.length() <= -2 || a.length() - b.length() >= 2) {
			return false; 
		}
		if (a.length() == b.length()) {
			return checkForReplaceCase(a, b); 
		} else {
			return checkForInsertOrDelete(a, b); 
		}
	}
	
	public static boolean checkForReplaceCase(String a, String b) {
		int differCount = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				differCount++; 
				System.out.println(differCount); 
			}
			if (differCount >= 2) {
				return false; 
			}
		}
		return true; 
	}
	
	public static boolean checkForInsertOrDelete(String a, String b) {
		return false; 
	}
	
	/*public static void main(String[] args) {
		String a = "pale"; 
		String b = "bae"; 
		System.out.println(isOneAway(a, b)); 
	}*/
}
