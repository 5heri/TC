import java.util.Stack;

public class DoubleLetter {

	public String ableToSolve(String S) {
		Stack stack = new Stack();
		
		for (int i = 0; i < S.length(); i++) {
			if (stack.isEmpty() || stack.peek() != Character.valueOf(S.charAt(i))) {
				stack.push(S.charAt(i));
			} else {
				stack.pop();
			}
		}
		return stack.isEmpty() ? "Possible" : "Impossible";

	// Can be done in O(n) with a stack
	/*	if (S.length() % 2 != 0) return "Impossible";
		
		while (S.length() != 0) {
			int oldLength = S.length();
			for (int i = 0; i < S.length()-2; i++) {
				if (S.charAt(i) == S.charAt(i+1)) {
					S = S.substring(0, i) + "" + S.substring(i+2, S.length());
					
				}
			}
			if (S.charAt(S.length()-1) == S.charAt(S.length()-2)) {
				S = S.substring(0, S.length()-2);
			}
			if (oldLength == S.length()) return "Impossible";
		}
		return "Possible";*/
	}

}
