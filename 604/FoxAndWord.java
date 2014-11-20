public class FoxAndWord {

	public int howManyPairs(String[] words) {
		int pairCount = 0;
		
		for (int i = 0; i < words.length; i++) {
			for (int j = i+1; j < words.length; j++) {
					if (interesting(words[i], words[j])) {
						pairCount++;
					}
			}
		}
		return pairCount;
	}
	
	private boolean interesting(String str1, String str2) {
	
		if (str1.length() != str2.length()) {
			return false;
		}
		int length = str1.length();	
		for (int i = 0; i < length; i++) {
			String newString = str1.substring(length-1-i, length) 
			            + "" + str1.substring(0,length-1-i);
			if (newString.equals(str2)) {
				return true;
			}
		}
		return false;
	}

}
