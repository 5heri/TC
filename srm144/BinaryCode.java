
public class BinaryCode {
	
	public String[] decode(String message) {

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
			if (!firstZeroNone) {
				valueZero = getInt(message.charAt(i-1)) -
						    getInt(firstZero.charAt(i-1)) -
							getInt(firstZero.charAt(i-2));
				if (valueZero != 1 || valueZero != 0) {
					firstZeroNone = true;
				} else {
					firstZero += valueZero;
				}
			}

			if (!firstOneNone) {
				valueOne = getInt(message.charAt(i-1)) -
						   getInt(firstOne.charAt(i-1)) -
						   getInt(firstOne.charAt(i-2));
				if (valueOne != 1 || valueZero != 0) {
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
	}

	private int getInt(char c) {
		return Character.getNumericValue(c);
	}
	
}
