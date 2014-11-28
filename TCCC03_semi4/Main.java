public class Main {
	


	public static void main(String[] args) {

		Circuits c = new Circuits();
		
		String[] connects = {"1 2",
 								"2",
 								""};
		String[] costs = {"5 3",
						 "7",
						 ""};


		System.out.println(c.howLong(connects, costs));


	}
}
