import java.util.Scanner;
import static org.gabr.math.Silnia.silnia;

public class TestSilnia {

	public static void main(String[] args) {
		Scanner skan = new Scanner(System.in);
		System.out.print("Podaj liczbe całkowitą: ");
		System.out.printf("Silnia z podanej liczby wynosi: %,d\n",
							silnia(skan.nextInt()));

	}

}