public class Petle {

	public static void main(String args[]) {

		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "\t");
			if (i % 5 == 0)
				System.out.println();
		}

		int x = 10;
		while (x != 0) {
			System.out.print(x);
			x--;
		}

		do {
			System.out.println("\nTa pętla wykona się tylko raz");
		} while (false);
	}

}
