public class Zmienne {
	public static void main(String args[]) {
		double promienKola = 10.0;
		double obwodKola = promienKola*2*Math.PI;
		
		System.out.println("Obwód koła o promieniu: "+promienKola+" wynosi:" +
				Math.round(obwodKola*100)/100.0);
	}
}