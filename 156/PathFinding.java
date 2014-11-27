// BUGS

import java.util.LinkedList;

public class PathFinding {

	boolean[][][][] visited;
	
	public int minTurns(String[] board) {
	
			int width = board[0].length();
			int height = board.length;
			visited = new boolean[20][20][20][20];
			
			Node start = findAandB(board);
			LinkedList<Node> q = new LinkedList<Node>();
			
			pushToQueue(q, start);
			
			while (!q.isEmpty()) {
				Node top = q.remove();
					
				if (checkConditions(top, board)) {
					if (switchedPositions(start, top)) {
						return top.steps;
					}
					
					for (int p1xH = -1; p1xH <= 1; p1xH++) {
						for (int p1yH = -1; p1yH <= 1; p1yH++) {
							for (int p2xH = -1; p2xH <= 1; p2xH++) {
								for (int p2yH = -1; p2yH <= 1; p2yH++) {
									if (!(top.p1x == top.p2x + p2xH 
								    	&& top.p1y == top.p2y + p2yH
								    	&& top.p2x == top.p1x + p1xH
								    	&& top.p2y == top.p1x + p1xH)) {
								    	
								    	pushToQueue(q, new Node(top.p1x + p1xH,
								    	                        top.p1y + p1yH,
								    	                        top.p2x + p2xH,
								    	                        top.p2y + p2yH,
								    	                        top.steps + 1));	
								    }			
								}
							}
						}
					}
				}
			}	
			return -1;	
	}
	
	private boolean checkConditions(Node n, String[] board) {
		return n.p1x >= 0 && n.p1x < board.length
			&& n.p2x >= 0 && n.p2y < board[0].length()
			&& board[n.p1x].charAt(n.p1y) != 'X'
			&& board[n.p2x].charAt(n.p2y) != 'X'
			&& n.p1x != n.p2x && n.p1y != n.p2y;  
	
	}
	
	private boolean switchedPositions(Node start, Node top) {
		return top.p1x == start.p2x && top.p1y == start.p2y
			&& top.p2x == start.p1x && top.p2y == start.p1y;
	}
	
	private Node findAandB(String[] board) {
	
		Node n = new Node(0,0,0,0,0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				if (board[i].charAt(j) == 'A') {
					n.p1x = i;
					n.p1y = j; 
				} else if (board[i].charAt(j) == 'B') {
					n.p2x = i;
					n.p2y = j;
				}
			}
		}
		System.out.println(n.p1x + " " + n.p1y + " " + n.p2x + " " + n.p2y);
		return n;
	
	}
	
	private void pushToQueue(LinkedList<Node> q, Node n) {
		System.out.println(n.p1x + " " + n.p1y + " " + n.p2x + " " + n.p2y);
		if (!visited[n.p1x][n.p1y][n.p2x][n.p2y]) {
			q.add(n);
			visited[n.p1x][n.p1y][n.p2x][n.p2y] = true;
		}
	}
	
	
	
	
	
	class Node {
		int p1x, p1y, p2x, p2y;
		int steps;
		
		Node(int x1, int y1, int x2, int y2, int nS) {
			p1x = x1;
			p1y = y1;
			p2x = x2;
			p2y = y2;
			steps = nS;
		} 
	}
}
