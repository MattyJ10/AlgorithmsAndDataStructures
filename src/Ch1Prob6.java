
public class Ch1Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val = Compressor("abc");
		System.out.println(val);
	}
	
	public static String Compressor(String s) {
		String ret = "";
		int charCount = 1; 
		for (int i = 0; i<s.length()-1; i++) {
			if (i ==s.length()-2) {
				if (s.charAt(i) == s.charAt(i+1)) {
					charCount++;
					ret = ret + s.charAt(i) + charCount;
				} else {
					ret = ret + s.charAt(i) + charCount + s.charAt(i+1) + 1;
				}
			} else {
				if (s.charAt(i) == s.charAt(i+1)) {
					charCount++;
				} else {
					ret = ret + s.charAt(i) + charCount;
					charCount = 1; 
				}
			}
		}
		if (ret.length() >= s.length()) {
			return s;
		} else {
			return ret;
		}
				
	}
}
