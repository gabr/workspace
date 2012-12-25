import java.util.ArrayList;


public class ArrayListTest {
	
	public static void pisz(ArrayList<String> zwoj){
		System.out.println(" ___________________");
		System.out.println("()__________________)");
		for(String s:zwoj)
			System.out.println(" | "+s+"\t#"+zwoj.indexOf(s)+" |");
		System.out.println(" +-----------------+");
	}

	public static void main(String[] args) {
		
		// "kolekcja" - w tym przypadku tablica, posiada dodatkowo zmienną
		// opisującą swoją długość
		// <Typ> - musi to być typ obiektowy
		// ArrayList<Typ>(rozmiar)
		ArrayList<String> zwoj = new ArrayList<String>();
		
		System.out.println(zwoj);
		zwoj.add("laska");
		zwoj.add("tiara");
		zwoj.add("szata");
		zwoj.add("ksiega");
		System.out.println(zwoj);
		
		pisz(zwoj);
		zwoj.add(1, "fajka");
		pisz(zwoj);
		zwoj.remove("tiara");
		pisz(zwoj);
	}

}
