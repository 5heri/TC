import java.lang.StringBuilder;

public class Time {

	public String whatTime(int seconds) {
		StringBuilder sb = new StringBuilder();
		int currTimeLeft = seconds;
		
		sb.append(currTimeLeft/3600);
		sb.append(':');
		currTimeLeft %= 3600;
		
		sb.append(currTimeLeft/60);
		sb.append(':');
		sb.append(currTimeLeft%60);
		
		return sb.toString();
	}

}
