
public class BinaryCode {

	public static void main(String[] args) {

		String[] decoded = decode("0");
		//123210122


		System.out.println(decoded[0]);
		System.out.println(decoded[1]);
	}


	
	/*public static String[] decode(String message) {

		String[] decodedStrings = {"NONE", "NONE"};
		String firstZero = "0";
		String firstOne = "1";
		boolean firstZeroNone = false;
		boolean firstOneNone = false;

		int valueZero = getInt(message.charAt(0)) - getInt(firstZero.charAt(0));
		if (valueZero > 1) {
			firstZeroNone = true;
		} else {
			firstZero += valueZero;
		}

		int valueOne = getInt(message.charAt(0)) - getInt(firstOne.charAt(0));
		if (valueOne > 1) {
			firstOneNone = true;
		} else {
			firstOne += valueOne;
		}

		for (int i = 2; i < message.length(); i++) {
			System.out.println("i:" + i);
			System.out.println("message at i-1: " + message.charAt(i-1));
			System.out.println("firstZeroNone: " + firstZeroNone);
			if (!firstZeroNone) {
				valueZero = getInt(message.charAt(i-1)) -
						    getInt(firstZero.charAt(i-1)) -
							getInt(firstZero.charAt(i-2));
							System.out.println(valueZero);
				if (valueZero != 1 && valueZero != 0) {
					firstZeroNone = true;
				} else {
					firstZero += valueZero;
				}
			}

			if (!firstOneNone) {
				valueOne = getInt(message.charAt(i-1)) -
						   getInt(firstOne.charAt(i-1)) -
						   getInt(firstOne.charAt(i-2));
				if (valueOne != 1 && valueZero != 0) {
					firstOneNone = true;
				} else {
					firstOne += valueOne;
				}
			}
		}

		if (!firstZeroNone) {
			decodedStrings[0] = firstZero;
		} 

		if (!firstOneNone) {
			decodedStrings[1] = firstOne;
		}

		return decodedStrings;
	}*/

	public static String[] decode(String message) {
		String[] results = new String[2];

		results[0] = decode(message, '0');
		results[1] = decode(message, '1');

		return results;
	}

	private static String decode(String message, char first) {
		String result = "" + first;

		if (message.length() == 1) {
			if (message.charAt(0) != first) {
				return "NONE";
			}
			return result;
		} else {
  			int value = getInt(message.charAt(0)) - getInt(result.charAt(0));
			if (value != 1 && value != 0) {
				return "NONE";
			}
			result += value;

			for (int i = 2; i < message.length(); i++) {
				value = getInt(message.charAt(i-1)) -
				        	getInt(result.charAt(i-1)) - getInt(result.charAt(i-2));

				if (value != 1 && value != 0) {
					return "NONE";
				}
				result += value;
			}

			if (getInt(result.charAt(result.length()-1)) + getInt(result.charAt(result.length()-2)) 
				            != getInt(message.charAt(message.length()-1))) {
				return "NONE";
			}
			return result;
		}
		

	}

	private static int getInt(char c) {
		return Character.getNumericValue(c);
	}
	
}
