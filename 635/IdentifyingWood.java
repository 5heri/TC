public class IdentifyingWood {

	public String check(String s, String t) {
		
		int j = 0;
		for (int i = 0; i < s.length() && j < t.length(); i++) {
			if (s.charAt(i) == t.charAt(j)) {
				j++;
			}
		}
		if (j == t.length()) {
			return "Yep, it's wood.";
		} else {
			return "Nope.";
		} 	
	}
	
}
