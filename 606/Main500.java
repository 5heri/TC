public class Main500 {
	

	public static void main(String[] args) {
		EllysNumberGuessing e = new EllysNumberGuessing();

		int[] guesses = {42, 42, 42, 42, 42};
		int[] answers = {13, 13, 13, 13, 13};
		System.out.println(e.getNumber(guesses, answers));
	}
}

// {999900000}
// {100001}
//{{5, 5, 4}, {2, 2, 1}}
//{{404, 4}, {200, 200}}

//{500000, 600000, 700000}
//{120013, 220013, 79987}

// {13000000, 55000000}, {42000000, 84000000}}

//{42, 42, 42, 42, 42}, {13, 13, 13, 13, 13}}
// {{400, 1}, {1, 398}}
