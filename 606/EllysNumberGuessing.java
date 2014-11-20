
public class EllysNumberGuessing {

	public int getNumber(int[] guesses, int[] answers) {

		int upF = guesses[0] + answers[0];
		int lowF = guesses[0] - answers[0];

		int currBest = 0;

		if (upF > 1000000000 && lowF >= 1) {   // lowF is valid
			currBest = lowF;
		} else if (lowF < 1 && upF <= 1000000000) { // upF is valid
			currBest = upF;
		} else if (lowF >= 1 && upF <= 1000000000) { // both are valid
			if (guesses.length == 1) {
				return -1;
			}
			currBest = getBest(guesses, answers);
			if (currBest == -1 || currBest == -2) {
				return currBest;
			}
		} else if (upF > 1000000000 && lowF < 1) {
			return -2;
		}

		for (int i = 1; i < guesses.length; i++) {
				if (currBest != (guesses[i] + answers[i]) 
						&& currBest != (guesses[i] - answers[i])) {
					return -2;
				}
		}
		return currBest; 
	}

	private int getBest(int[] guesses, int[] answers) {
		for (int i = 1; i < guesses.length; i++) {
			if (guesses[i-1] != guesses[i] 
				|| answers[i-1] != answers[i]) {
				return getValidAndSame(guesses[i-1] + answers[i-1], 
										guesses[i-1] - answers[i-1],
										guesses[i] + answers[i],
										guesses[i] - answers[i]);
			}
		}
		return -1;
	}

	private int getValidAndSame(int firstP, int secondP, int firstQ, int secondQ) {
		if (firstP == firstQ || firstP == secondQ) {
			return firstP;
		} else if (secondP == firstQ || secondP == secondQ) {
			return secondP;
		} else {
			return -2;
		}
	}
}
