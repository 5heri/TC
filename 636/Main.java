public class Main {
	
	public static void main(String[] args) {
		GameOfStones gos = new GameOfStones();

		int[] x = {7, 15, 9, 5};
		System.out.println(gos.count(x));

		int[] y = {10, 16};
		System.out.println(gos.count(y));

		int[] a = {2, 8, 4};
		System.out.println(gos.count(a));

		int[] b = {17};
		System.out.println(gos.count(b));

		int[] c = {10, 15, 20, 12, 1, 20};
		System.out.println(gos.count(c));


	}
}