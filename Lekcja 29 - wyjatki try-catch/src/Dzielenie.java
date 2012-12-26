import java.util.InputMismatchException;
import java.util.Scanner;

public class Dzielenie {

	static public void main(String[] args) {
		Scanner skan = new Scanner(System.in);
		int i, j;

		while (true) {
			try {

				System.out.print("\nWprowadź licznik: ");
				i = skan.nextInt();
				System.out.print("\nWprowadź mianownik: ");
				j = skan.nextInt();

				System.out.println("\nWynik dzielenia " + i + "/" + j + " = "
						+ i / j);
				break;

			} catch (ArithmeticException ae) {

				// ae.printStackTrace();
				System.err.println("Dzielenie przez zero!");

			} catch (InputMismatchException ie) {
				System.err.println("Wprowadzono złe dane!");
				skan.nextLine();
			}
		}
		skan.close();
	}

}
