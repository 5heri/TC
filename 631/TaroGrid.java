public class TaroGrid {

	public int getNumber(String[] grid) {
		
		int maxConsec = 1;
		for (int cols = 0; cols < grid[0].length(); cols++) {
			
			char currentChar = grid[0].charAt(cols);
			int currentCount = 1;
			for (int rows = 1; rows < grid.length; rows++) {
				if (currentChar == grid[rows].charAt(cols)) {
					currentCount++;
				} else {
					currentChar = grid[rows].charAt(cols);
					currentCount = 1;
				}
				
				if (currentCount > maxConsec) maxConsec = currentCount;
			}
			if (maxConsec == grid.length) return maxConsec;
		}
		return maxConsec;
	}

}
