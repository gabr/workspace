import java.util.Scanner;


public class TestRowniania {
	
	public static void main(String[] args){
		
		System.out.println("a*x^2 + b*x + c");
		System.out.println("Podaj parametry a, b i c:");
		Scanner skaner = new Scanner(System.in);
		System.out.print("\na : "); int a = skaner.nextInt();
		System.out.print("\nb : "); int b = skaner.nextInt();
		System.out.print("\nc : "); int c = skaner.nextInt();
		
		RownanieKwadratowe r = new RownanieKwadratowe(a, b, c);
		System.out.println(r.rozwiaz());
		System.out.println(r);
	}

}
