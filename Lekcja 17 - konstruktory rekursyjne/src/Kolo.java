/**Akcesory i mutatory
 * 
 * akcesor - pobieranie wartości pól
 * mutator - ustawianie wartości pola
 */

/**Klasa reprezentuje koło
 * @author gabr
 *
 */
public class Kolo {

	
	public Kolo(){
		promien = 1.0;
		id = nextId;
		++nextId;
	}
	
	public Kolo(double x){
		this();					// rekursyjnie wywołańie musi być pierwszą
								// instrukcją w nowym konstruktorze
		if(x >=0) promien = x;
	}
	
	public Kolo(double x, String j) {
		this(x);
		if(j.equals("km")) promien *= 1000;
		if(j.equals("cm")) promien /= 100;
	}
	
	/** promień koła 
	 * @see Kolo#promien
	 */
	private double promien;
	private int id;
	private static int nextId;	// <-- pole przynależy do KLASY, a nie OBIEKTU
								// patrz na sam dół klasy, tam jest przypisanie
								// pierwszej i defaultowej wartości nextId;
	
	public int getId(){
		return id;
	}
	
	public void setPromien(double r) {
		if(r >= 0) promien = r;
	}
	
	public double getPromien() {
		return promien;
	}
	
	/**Liczy obwód koła na podstawie aktualnej wartości {@linkplain #promien promienia}
	 * @return zwraca obwód koła
	 */
	public double obliczObwodKola(){
		return 2*promien*Math.PI;
	}
	
	/**Liczy pole koła na podstawie aktualnej wartości {@linkplain #promien promienia}
	 * @return zwraca promień koła
	 */
	public double obliczPoleKola(){
		return Math.PI*Math.pow(promien, 2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Kolo kolo = new Kolo(2.7);
		
		System.out.println("Promien kola wynosi: "+kolo.getPromien());
		System.out.println("Obwód koła wynosi: "+Math.round(kolo.obliczObwodKola()*100)/100.0);
		System.out.println("Pole koła wynosi: "+Math.round(kolo.obliczPoleKola()*100)/100.0);
		
		Kolo kolka[] = new Kolo[3];
		kolka[0] = new Kolo(0);
		kolka[1] = new Kolo(3.5);
		kolka[2] = new Kolo(7, "km");
		
		for(Kolo x:kolka) {
			System.out.println("Promien kola ["+x.getId()+"] wynosi: "+
					x.getPromien());
		}

	}
	
	static {
		nextId = 0;
	}

}
