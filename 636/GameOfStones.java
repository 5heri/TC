public class GameOfStones {

	public int count(int[] stones) {
		
		int bestPile = 0;
		for (int i = 0; i < stones.length; i++) {
			bestPile += stones[i];
		}	
		if (bestPile % stones.length != 0) {
			return -1;
		}
		bestPile /= stones.length;
			
		int count = 0;
		for (int i = 0; i < stones.length; i++) {
			if (Math.abs(stones[i]-bestPile) % 2 != 0) {
				return -1;
			}
			count += Math.abs(stones[i]-bestPile)/2;
		}
		return count/2;
	}
}
