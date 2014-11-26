import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class GrafixMask {
	
	boolean[][] fill;
	
	public int[] sortedAreas(String[] rectangles) {
		fill = new boolean[400][600];
		
		for (String rec : rectangles) {
			String[] coor = rec.split(" ");
			int x1 = Integer.parseInt(coor[0]);
			int y1 = Integer.parseInt(coor[1]);
			int x2 = Integer.parseInt(coor[2]);
			int y2 = Integer.parseInt(coor[3]);
			
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					fill[i][j] = true;
				}
			} 
		}
		
		List<Integer> values = new ArrayList<Integer>();
		
		for (int i = 0; i < 400; i++) {
			for (int j = 0; j < 600; j++) {
				if (!fill[i][j])
					values.add(doFill(i, j));
			}
		}
		
		int[] results = new int[values.size()];
		for (int i = 0; i < values.size(); i++) {
			results[i] = values.get(i);
		}
		Arrays.sort(results);
		return results;
	}
	
	private int doFill(int x, int y) {
		int result = 0;
		Stack<Node> s = new Stack<Node>();
		s.push(new Node(x, y));
		
		while (!s.isEmpty()) {
			Node top = s.pop();
			
			if (inGrid(top.x, top.y) && !fill[top.x][top.y]) {
				fill[top.x][top.y] = true;
				result++;
				
				s.push(new Node(top.x + 1, top.y));
				s.push(new Node(top.x - 1, top.y));
				s.push(new Node(top.x, top.y + 1));
				s.push(new Node(top.x, top.y - 1));
			}
		}
		return result;
	}
	
	private boolean inGrid(int x, int y) {
		return x >= 0 && x < 400 && y >= 0 && y < 600;
	}
	
	class Node {
		int x;
		int y;
		
		Node(int nx, int ny) {
			x = nx;
			y = ny;
		} 
	}

}
