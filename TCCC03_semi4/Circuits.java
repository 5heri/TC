public class Circuits {

	int[][] maxCost; 
	public int howLong(String[] connects, String[] costs) {
		maxCost = new int[connects.length][connects.length];
		
		for (int i = 0; i < connects.length; i++) {
			if (connects[i].equals("")) continue;
			String[] connectsTo = connects[i].split(" ");
			String[] costsTo = costs[i].split(" ");
			
			for (int j = 0; j < connectsTo.length; j++) {
				int connectedTo = Integer.parseInt(connectsTo[j]);
				int costTo = Integer.parseInt(costsTo[j]);
				
				maxCost[i][connectedTo] = costTo;
			
			}
		}
		
		for (int k = 0; k < maxCost.length; k++) {
			for (int i = 0; i < maxCost.length; i++) {
				for (int j = 0; j < maxCost[0].length; j++) {
					if (maxCost[i][k] != 0 && maxCost[k][j] != 0 
						&& maxCost[i][j] < maxCost[i][k] + maxCost[k][j]) {
						maxCost[i][j] = maxCost[i][k] + maxCost[k][j];
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < maxCost.length; i++) {
			for (int j = 0; j < maxCost[0].length; j++) {
				if (maxCost[i][j] > max) {
					max = maxCost[i][j];
				}
			}
		}
		return max;	
	}

}
