// TODO: FIND BUG

public class GameOfStones {

	public int count(int[] stones) {
		
		int bestPile = 0;
		for (int i = 0; i < stones.length; i++) {
			bestPile += stones[i];
		}	
		bestPile /= stones.length;
			
		int difference = 0;
		int prevDiff = difference;
		int actions = 0;
		for (int i = 0; i < stones.length; i++) {
			prevDiff = difference;
			difference += (bestPile - stones[i]);
			
			if (prevDiff != difference) {
				actions += Math.abs(prevDiff/2);
			}
			if (!isEven(difference)) {
				return -1;
			}	
		}
		if (difference != 0) {
			return -1;
		}
		return actions;
	}
	
	private boolean isEven(int n) {
		return n % 2 == 0;
	}
}
