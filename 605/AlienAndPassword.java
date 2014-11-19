public class AlienAndPassword {

	public int getNumber(String S) {
		
		int res = 1;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) != S.charAt(i-1)) {
				res++;
			}
		}
		return res;
	}

}
