package org.mariusz.classes;

public class Ksiazka {

	private static int id;
	private String tytul;
	private String nazwiskoAutora;
	private String imionaAutora;
	private int rok;
	private String kategorie;
	private boolean czyWypozyczona;
	private int liczbaWypozyczen;

	public Ksiazka() throws Exception {
		this("", "", "", 0, "");
	}

	public Ksiazka(String tytul, String nazwiskoAutora, String imionaAutora,
			int rok, String kategorie) throws Exception {
		
		if (nazwiskoAutora.isEmpty() || kategorie.isEmpty() || tytul.isEmpty()) {
			Exception eEmptyString;
			eEmptyString = new Exception(
					"Nazwisko autora, kategorie i tytul książki są wymagane!");
			throw eEmptyString;
		}
		
		if (rok < 1700 || rok > 2012) {
			Exception eZlyZakresRoku;
			eZlyZakresRoku = new Exception(
					"Rok książki musi zawierać się w zakresie [1700,...,2012]");
			throw eZlyZakresRoku;
		}

		id++;
		this.czyWypozyczona = false;
		this.liczbaWypozyczen = 0;

		this.tytul = tytul;
		this.nazwiskoAutora = nazwiskoAutora;
		this.imionaAutora = imionaAutora;
		this.rok = rok;
		this.kategorie = kategorie;

	}

	public String toString() {
		String inicjaly, imiona;
		imiona = this.imionaAutora;
		inicjaly = imiona.charAt(0) + ".";
			while (imiona.indexOf(" ") != -1) {
				imiona = imiona.substring(imiona.indexOf(" ")+1);
				inicjaly += imiona.charAt(0) + ".";
			}
		return id + " " + inicjaly + " " + this.nazwiskoAutora + " ,,"
				+ this.tytul + "\'\' " + (this.czyWypozyczona ? "tak" : "nie");
	}
	static {
		id = 0;
	}
}
