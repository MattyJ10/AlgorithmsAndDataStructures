/*
public class isPalindromePermutation {
	public static boolean isPalindromePermute(String s) {
		boolean isEven = false; 
		s = s.toLowerCase(); 
		if (s.length() % 2 == 0) {
			isEven = true; 
		}
		int[] counts = new int[128]; 
		for (int i = 0; i < s.length(); i++) {
			char val = s.charAt(i); 
			if (val == ' ') {
				continue; 
			}
			counts[val] += 1; 
		}
		
	}
	
	public static void main(String[] args) {
		String s = "Tact Coa"; 
		System.out.println(isPalindromePermute(s)); 
	}
}*/
