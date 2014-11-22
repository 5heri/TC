public class MountainRanges {

	public int countPeaks(int[] heights) {
		if (heights.length == 1) return 1;
		
		int count = 0;
		
		if (heights[count] > heights[count+1]) count++;
		if (heights[heights.length-1]> heights[heights.length-2]) count++;
		
		for (int i = 1; i < heights.length-1; i++) {
			if (heights[i] > heights[i-1] && heights[i] > heights[i+1]) {
				count++;
				i++;
			}			
		}
		return count;	
	}
	
}
