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
	}
	
	public Kolo(double x){
		if(x >=0) promien = x;
		else promien = 1.0;
	}
	
	public Kolo(double x, String j) {
		if(x >=0){
			promien = x;
			if(j.equals("km")) promien *= 1000;
			if(j.equals("cm")) promien /= 100;
		} else promien = 1.0;
	}
	
	/** promień koła 
	 * @see Kolo#promien
	 */
	private double promien;
	
	
	
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

	}

}
