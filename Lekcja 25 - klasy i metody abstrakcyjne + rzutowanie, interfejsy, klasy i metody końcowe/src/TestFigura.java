
public class TestFigura {
	
	public static void main(String[] args) {

//		Figura figa = new Figura("Fioletowa", true);
		Kolo pileczka = new Kolo(5, "Niebieska", true);
		Prostokat deseczka = new Prostokat(2, 5, "Brazowa", false);
		
//		System.out.println(figa);
		System.out.println(pileczka);
		System.out.println(deseczka);
		
		Figura[] figury = new Figura[2];
		
//		figury[0] = figa;
		figury[0] = pileczka;
		figury[1] = deseczka;
		
		for(int i = 0; i < 2 ; i++){
			System.out.println(figury[i]);
			System.out.println(figury[i].pole());
			// lub zamiast tworzyć metody abstrakcyjne można rzutować
			// obiekt na jakiś, który na pewno posiada daną metodę:
			/*
			 * if(gigury[0] instanceof Kolo)
			 * 		System.out.println((Kolo) figury[i].pole());
			 * else if(gigury[0] instanceof Prostokat)
			 * 		System.out.println((Prostokat) figury[i].pole());
			 */
		}
	}

}
