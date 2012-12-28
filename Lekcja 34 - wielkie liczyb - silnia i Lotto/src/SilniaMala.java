import java.math.BigInteger;
import java.util.Scanner;

public class SilniaMala {

	public static BigInteger silnia(int n) {
		BigInteger bn = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			bn = bn.multiply(BigInteger.valueOf(i));
		}
		return bn;
	}

	public static void main(String[] args) {
		Scanner skaner = new Scanner(System.in);
		System.out.print("Podaj dodatnia liczbe całkowitą: ");
		System.out.println("Silnia z podanej liczby wynosi: "
				+ silnia(skaner.nextInt()));

		int n = 49;
		int k = 6;
		BigInteger p = silnia(n).divide(silnia(k).multiply(silnia(n-k)));
		System.out.printf("\nPrawdopodobieństwo wygrania w totka wynosi" +
				"jak jeden do %,d",	p);
	}

}
