import java.lang.StringBuilder;

public class MiddleCode {

	public String encode(String s) {

		StringBuilder sb = new StringBuilder(s);
		StringBuilder t = new StringBuilder();

		while (sb.length() > 0) {
			if (sb.length() % 2 == 0) { 
				if (sb.charAt(sb.length()/2 - 1) <= sb.charAt(sb.length()/2)) {
					t.append(sb.charAt(sb.length()/2 - 1));
					sb.deleteCharAt(sb.length()/2 - 1);
				} else {
					t.append(sb.charAt(sb.length()/2));
					sb.deleteCharAt(sb.length()/2);
				}
			} else {
				t.append(sb.charAt(sb.length()/2));
				sb.deleteCharAt(sb.length()/2);				
			}
		}
		return t.toString();
	}

}

