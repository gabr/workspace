package org.mariusz.classes;

public class Ksiazka {

	private static int static_id;
	private int id;
	private String tytul;
	private String nazwiskoAutora;
	private String imionaAutora;
	private int rok;
	private String kategorie;
	private boolean czyWypozyczona;
	private int liczbaWypozyczen;
	private boolean krotkiFormatWyswietlania;

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

		++static_id;
		this.id = static_id;
		this.czyWypozyczona = false;
		this.liczbaWypozyczen = 0;

		this.tytul = tytul;
		this.nazwiskoAutora = nazwiskoAutora;
		this.imionaAutora = imionaAutora;
		this.rok = rok;
		this.kategorie = kategorie;
		this.krotkiFormatWyswietlania = true;

	}

	public String toString() {
		String inicjaly, imiona;
		imiona = this.imionaAutora;
		inicjaly = imiona.charAt(0) + ".";
		while (imiona.indexOf(" ") != -1) {
			imiona = imiona.substring(imiona.indexOf(" ") + 1);
			inicjaly += imiona.charAt(0) + ".";
		}
		if (this.krotkiFormatWyswietlania)
			return id + " " + inicjaly + " " + this.nazwiskoAutora + " „"
					+ this.tytul + "” " + (this.czyWypozyczona ? "tak" : "nie");
		else
			return "ID: " + id + " " + this.imionaAutora + " "
					+ this.nazwiskoAutora + " „" + this.tytul + "” rok: "
					+ this.rok + "r. kategorie: " + this.kategorie
					+ "; wypozyczona: " + (this.czyWypozyczona ? "tak" : "nie");
	}

	public void ustawkrotkiFormatWyswietlania(boolean format) {
		this.krotkiFormatWyswietlania = format;
	}

	static {
		static_id = 0;
	}
}