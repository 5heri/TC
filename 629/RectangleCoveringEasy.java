public class RectangleCoveringEasy {

	public int solve(int holeH, int holeW, int boardH, int boardW) {
		if (boardH >= holeH && boardW >= holeW) {
			if (boardH == holeH && boardW == holeW) {
				return -1;
			}
			return 1;
		} else if (boardW >= holeH && boardH >= holeW) {
			if (boardW == holeH && boardH == holeW) {
				return -1;
			}
			return 1;
		}
		return -1;
	}
	
}

