public class Wyliczeniowy {

	public enum DzienTygodnia {
		Poniedzialek(1, "pon"), Wtorek(2, "wt"), Sroda(3, "śr"), Czwartek(4,
				"czw"), Piatek(5, "pt"), Sobota(6, "sob"), Niedziela(7, "nd");
		
		private int numer;
		private String s;
		
		private DzienTygodnia(int n, String s){
			this.numer = n;
			this.s = s;
		}
		
		public String toString(){
			return numer + ". " + s + " - " + super.toString();
		}
	};

	public static void main(String[] args) {
		DzienTygodnia week = DzienTygodnia.Sroda;
		for (DzienTygodnia x : DzienTygodnia.values())
			System.out.println(x);
		
		if(week == DzienTygodnia.Sroda)
			System.out.println("Jak środa to super!");
		
		DzienTygodnia day = DzienTygodnia.valueOf("Wtorek");
		System.out.println(day);

	}

}
