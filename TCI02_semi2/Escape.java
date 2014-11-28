import java.util.LinkedList;

public class Escape {

	private static final char NORMAL = '\u0000';
	private static final char HARMFUL = 'H';
	private static final char DEADLY = 'D';
	private static final int[][] DIRS = {{-1, 0}, {0,1}, {1, 0}, {0,-1}};
	
	char[][] grid;
	boolean[][] visited;
	
	public int lowest(String[] harmful, String[] deadly) {
		grid = new char[501][501];
		visited = new boolean[501][501];
		
		fillGrid(harmful, HARMFUL);
		fillGrid(deadly, DEADLY);

		//displayGrid();
		
		LinkedList<Node> q = new LinkedList<Node>();
		
		visited[0][0] = true;
		q.add(new Node(0,0,0));
		
		while (!q.isEmpty()) {
			Node top = q.remove();
			/*System.out.println("removed: " + top.x + " " + top.y + " " + grid[top.x][top.y]);
			if (inGrid(top.x-1,top.y)) {
				System.out.println("Left: " + grid[top.x-1][top.y]);
			} else {
				System.out.println("Left: O");
			}
			if (inGrid(top.x, top.y+1)) {
				System.out.println("UP: " + grid[top.x][top.y+1]);
			} else {
				System.out.println("UP: O");
			}
			if (inGrid(top.x+1, top.y)) {
				System.out.println("RIGHT: " + grid[top.x+1][top.y]);
			} else {
				System.out.println("RIGHT: O");
			}
			if (inGrid(top.x, top.y-1)) {
				System.out.println("DOWN: " + grid[top.x][top.y-1]);
			} else {
				System.out.println("DOWN: O");
			}
			System.out.println();*/

			
			if (top.x == 500 && top.y == 500) 
				return top.damage;
			
			for (int i = 0; i < DIRS.length; i++) {
				int nX = top.x + DIRS[i][0];
				int nY = top.y + DIRS[i][1];
				//System.out.println(nX + " " + nY);
				
				if (inGrid(nX, nY) && !visited[nX][nY] && grid[nX][nY] != DEADLY) {
					if (grid[nX][nY] == HARMFUL) {
						q.add(new Node(nX, nY, top.damage + 1));
					} else {
						q.add(new Node(nX, nY, top.damage));
					}
					
					visited[nX][nY] = true;

				}
			}
		}
		return -1;
	}
	
	private boolean inGrid(int x, int y) {
		return x >= 0 && x < grid.length
			&& y >= 0 && y < grid[0].length;
	}
	
	private void fillGrid(String[] ranges, char v) {

		for (int i = 0; i < ranges.length; i++) {
			String[] values = ranges[i].split("\\s");
			int x1 = Math.min(Integer.parseInt(values[0]), Integer.parseInt(values[2]));
			int y1 = Math.min(Integer.parseInt(values[1]), Integer.parseInt(values[3]));
			int x2 = Math.max(Integer.parseInt(values[0]), Integer.parseInt(values[2]));
			int y2 = Math.max(Integer.parseInt(values[1]), Integer.parseInt(values[3]));
			
			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					grid[j][k] = v;
				}
			}
		}
	}

	private void displayGrid() {
		for (int i = 0; i < 501; i++) {
			for (int j = 0; j < 501; j++) {
				char v = '.';
				if (grid[i][j] == HARMFUL) {
					v = HARMFUL;
				} else if (grid[i][j] == DEADLY) {
					v = DEADLY;
				}

				System.out.print(v);
			}
			System.out.println();
		}

	}
	
	class Node {
		int x, y;
		int damage;
		
		Node(int x, int y, int damage) {
			this.x = x;
			this.y = y;
			this.damage = damage;
		}
	}


}
