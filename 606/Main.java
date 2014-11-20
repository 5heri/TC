public class Main {
	
	public static void main(String[] args) {
		EllysSubstringSorter s = new EllysSubstringSorter();
		EllysSubstringSorterAlternate sAlt = new EllysSubstringSorterAlternate();

		System.out.println(s.getMin("ESPRIT", 3));
		System.out.println(sAlt.getMin("ESPRIT", 3));

		System.out.println(s.getMin("AAAAAAAAAAAAAAAAAACB", 13));
		System.out.println(sAlt.getMin("AAAAAAAAAAAAAAAAAACB", 13));
	}
}
