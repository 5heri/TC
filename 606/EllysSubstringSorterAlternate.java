// BUGS

import java.lang.StringBuilder;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EllysSubstringSorterAlternate {
	
	public String getMin(String S, int L) {
		
		int i = findIndex(S, L);
		if (i == -1) {
			return S;
		}
		
		List<Character> l = new ArrayList<Character>();
		for (int start = i; start < i + L; start++) {
			l.add(S.charAt(start));
		}
		Collections.sort(l);
		
		StringBuilder sb = new StringBuilder(S);
		for (Character c : l) {
			sb.setCharAt(i, c);
			i++;
		}
		return sb.toString();
	} 
	
	private int findIndex(String S, int L) {
		for (int i = 0; i <= S.length() - L; i++) {
			char currChar = S.charAt(i);
			for (int j = i + 1; j < L + i; j++) {
				if (currChar > S.charAt(j)) {
					return i;
				}
			}		
		} 
		return -1;
	}
}
