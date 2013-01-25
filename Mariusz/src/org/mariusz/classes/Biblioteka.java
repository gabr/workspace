package org.mariusz.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {
	private ArrayList<Ksiazka> ksiazki;
	private int ileKsiazek;

	public Biblioteka() {
		this.ksiazki = new ArrayList<Ksiazka>();
		this.ileKsiazek = 0;
	}

	public static void main(String[] args) {

		Biblioteka filia = new Biblioteka();

		filia.addParametry("Star Wars", "Lucas", "Gorge Arek", 1992,
				"Sciencefiction");
		filia.addParametry("Lotr", "Tolkien", "John Ronald Reuel", 1982,
				"Fantasy");
		filia.addParametry("Eragon", "Paolini", "Christopher", 2001, "fantasy");

		filia.wypiszKsiazki(true);

	}

	public void edycja(int id) {
		for (Ksiazka k : this.ksiazki)
			if (k.getId() == id) {
				Scanner s = new Scanner(System.in);
				k.ustawkrotkiFormatWyswietlania(false);
				String decyzja;
				char znak = ' ';

				while (znak != 'p' && znak != 'q') {
					System.out.println("\n > Które dane chcesz zmienic:\n");
					System.out.println("    " + k);
					System.out.println("    ---------------------------");
					System.out.println("    I. Imiona autora");
					System.out.println("    N. Nazwisko autora");
					System.out.println("    T. Tutuł książki");
					System.out.println("    R. Rok wydania");
					System.out.println("    K. Kategorie tematyczne");
					System.out.println("    ---------------------------");
					System.out.println("    p. powrót");
					System.out.println("    ---------------------------");
					System.out.print(" : ");
					decyzja = s.nextLine();
					znak = decyzja.toLowerCase().charAt(0);

					switch (znak) {
						case 'i' :
							System.out.print(" > podaj nowe imię/imiona\n");
							System.out
									.print(" ! Imiona autora powinny być oddzielone spacjami.\n : ");
							while (!k.setImiona(s.nextLine()))
								System.out
										.print(" ! pole nie moze byc puste\n : ");
							break;
						case 'n' :
							System.out.print(" > podaj nowe nazwisko\n : ");
							while (!k.setNazwisko(s.nextLine()))
								System.out
										.print(" ! pole nie moze byc puste\n : ");
							break;
						case 't' :
							System.out.print(" > podaj nowy tytuł\n : ");
							while (!k.setTytul(s.nextLine()))
								System.out
										.print(" ! pole nie moze byc puste\n : ");
							break;
						case 'r' :
							System.out.print(" > podaj nowy rok\n : ");
							while (!k.setRok(Integer.parseInt(s.nextLine())))
								System.out
										.print(" ! zakres roku to [1700,...,2012]\n : ");
							break;
						case 'k' :
							System.out.print(" > podaj nowe kategorie\n");
							System.out
									.print(" ! Kategorie powinny być oddzielone średnikami.\n : ");
							while (!k.setTytul(s.nextLine()))
								System.out
										.print(" ! pole nie moze byc puste\n : ");
							break;
					}
				}
			}
	}

	public void addDialog() {
		Scanner s = new Scanner(System.in);
		String tytul, imiona, nazwisko, kateg;
		int rok;

		System.out.print("\n > Prosze podać\n");
		System.out
				.print("    ! Imiona autora powinny być oddzielone spacjami.\n");
		System.out
				.print("    ! Kategorie powinny być oddzielone średnikami.\n");
		System.out.println("    -------------------------------");
		System.out.print("    tytul: ");
		tytul = s.nextLine();
		System.out.print("    imiona autora: ");
		imiona = s.nextLine();
		System.out.print("    nazwisko autora: ");
		nazwisko = s.nextLine();
		System.out.print("    rok: ");
		rok = s.nextInt();
		s.nextLine();
		System.out.print("    kategorie: ");
		kateg = s.nextLine();
		System.out.println("    ---------------------------");

		this.addParametry(tytul, nazwisko, imiona, rok, kateg);
	}

	public void addParametry(String tytul, String nazwiskoAutora,
			String imionaAutora, int rok, String kategorie) {

		Ksiazka nowa = null;

		try {
			nowa = new Ksiazka(tytul, nazwiskoAutora, imionaAutora, rok,
					kategorie);
			this.add(nowa);
		} catch (Exception e) {
			System.out.println("\n\n ! error: błędne dane:");
			System.out.println("\t"
					+ e.toString().substring(e.toString().indexOf(":") + 2));
		}
	}

	public void add(Ksiazka k) {
		ksiazki.add(k);
	}

	public void wypiszKsiazki(boolean format) {
		for (Ksiazka k : this.ksiazki)
			k.ustawkrotkiFormatWyswietlania(format);
		String lista = this.ksiazki.toString();
		lista = lista.substring(1, lista.length() - 1);
		lista = lista.replaceAll(", ", "\n   ");

		System.out.println("   " + lista);
	}

	public void wypozyczanie(int id) {
		for (Ksiazka k : this.ksiazki)
			if (k.getId() == id)
				k.setCzyWypozyczona(true);
	}

	public void zwrot(int id) {
		for (Ksiazka k : this.ksiazki)
			if (k.getId() == id)
				k.setCzyWypozyczona(false);
	}

	static public void Pausse() {

		System.out.println(" > Press ENTER to continue...");
		try {
			System.in.read();
			while (System.in.available() > 0)
				System.in.read(); // flush the buffer
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
