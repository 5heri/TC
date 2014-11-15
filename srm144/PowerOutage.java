public class PowerOutage {
	
 	public int estimateTimeOut(int[] fromJunction, int[] toJunction, 
 	                                               int[] ductLength) {

 	    int doubledLengths = 0;

 	    for (int i = 0; i < ductLength.length; i++) {
 	    	doubledLengths += (2 * ductLength[i]);
 	    }

 	    return doubledLengths - longestPath(0, fromJunction, toJunction, ductLength);
	}	

	private int longestPath(int currDuct, int[] fromJ, int[] toJ, int[] dLength) {
		int currMax = 0;

		for (int i = 0; i < fromJ.length; i++) {
			if (currDuct == fromJ[i]) {
				currMax = Math.max(currMax, 
			            dLength[i] + longestPath(toJ[i], fromJ, toJ, dLength));
			}
		}
		return currMax;	
	}

}
