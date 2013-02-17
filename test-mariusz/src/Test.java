
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double liczba = 1.23456789;
		
		System.out.println("liczba przed zmianami: "+liczba);
		
		liczba = liczba * 100.0;
		liczba = Math.round(liczba);
		liczba = liczba / 100.0;
		
		System.out.println("liczba po zmianach: "+liczba);
		
		String liczba_napis = Double.toString(liczba);
		
		System.out.println("string: "+liczba_napis);
	}

}
