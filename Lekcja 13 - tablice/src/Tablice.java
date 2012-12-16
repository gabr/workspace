import java.util.Arrays;

/**
 * 
 */

/**Przykłady użycia tablic
 * @author gabr
 *
 */
public class Tablice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int tablica[] = {1, 4, 2, 7, 3};
		
		System.out.print("tablica: ");
		System.out.println(Arrays.toString(tablica));
		
		int kopia[] = new int[5];
		kopia = tablica;
		tablica[0] = 100;
		
		System.out.println("--------------------------------");
		System.out.print("tablica: ");
		System.out.println(Arrays.toString(tablica));
		System.out.print("kopia: ");
		System.out.println(Arrays.toString(kopia));	
		
		tablica[0] = 1;
		kopia = Arrays.copyOf(tablica, tablica.length);
		
		tablica[0] = 100;
		System.out.println("--------------------------------");
		System.out.print("tablica: ");
		System.out.println(Arrays.toString(tablica));
		System.out.print("kopia: ");
		System.out.println(Arrays.toString(kopia));	
		
		Arrays.sort(kopia);
		System.out.println("--------------------------------");
		System.out.print("kopia: ");
		System.out.println(Arrays.toString(kopia));

	}

}
