package org.mariusz.classes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteka {

	private ArrayList<Ksiazka> ksiazki;
	private int ileKsiazek;

	public Biblioteka() {
		this.ksiazki = new ArrayList<Ksiazka>();
		this.ileKsiazek = 0;

		Ksiazka k = null;

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("biblioteka.dat");
			ois = new ObjectInputStream(fis);

			try {
				while (true) {
					k = (Ksiazka) ois.readObject();
					this.ksiazki.add(k);
					++this.ileKsiazek;
					Ksiazka.setId(this.ileKsiazek);
				}
			} catch (EOFException e) {
			}

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
			}
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {

		Biblioteka filia = new Biblioteka();

		// main menu
		System.out.println();
		Scanner s = new Scanner(System.in);
		String decyzja;
		char znak = ' ';

		while (znak != 'z' && znak != 'q' && znak != 'e') {
			System.out.println(" > menu główne:\n");
			System.out.println("    ---------------------------");
			System.out.println("    1. Lista książek (format skrócony)");
			System.out.println("    2. Lista książek (pełny format)");
			System.out.println("    3. Dodaj nową książkę");
			System.out.println("    4. Edytuj dane ksiązki");
			System.out.println("    5. Wypożycz książkę");
			System.out.println("    6. Zwróć książkę");
			System.out.println("    7. Znajdź książkę");
			System.out.println("    8. Funkcje dodatkowe => ...");
			System.out.println("    ---------------------------");
			System.out.println("    z. zamknij program");
			System.out.println("    ---------------------------");
			System.out.print(" : ");
			decyzja = s.nextLine();
			znak = decyzja.toLowerCase().charAt(0);

			switch (znak) {
				case '1' :
					System.out.println("\n" + filia + "\n");
					Pausse();
					break;

				case '2' :
					System.out.println("\n" + filia.listaKsiazek(false) + "\n");
					Pausse();
					break;

				case '3' :
					filia.addDialog();
					filia.aktualizujDane();
					Pausse();
					break;

				case '4' :
					System.out.println("\n > podaj numer ID książki");
					System.out.print(" : ");
					filia.edycja(s.nextInt());
					filia.aktualizujDane();
					s.nextLine();
					break;

				case '5' :
					System.out.println("\n > podaj numer ID książki");
					System.out.print(" : ");
					filia.wypozyczanie(s.nextInt());
					s.nextLine();
					filia.aktualizujDane();
					Pausse();
					break;

				case '6' :
					System.out.println("\n > podaj numer ID książki");
					System.out.print(" : ");
					filia.zwrot(s.nextInt());
					s.nextLine();
					filia.aktualizujDane();
					Pausse();
					break;

				case '7' :
					filia.szukajDialog();
					break;

				case '8' :
					funkcjeDodatkowe(filia);
					break;
			}
		}

	}

	public static void funkcjeDodatkowe(Biblioteka filia) {
		System.out.println();
		Scanner s = new Scanner(System.in);
		String decyzja;
		char znak = ' ';

		while (znak != 'p' && znak != 'q') {
			System.out.println(" > funkcje dodatkowe:\n");
			System.out.println("    ---------------------------");
			System.out
					.println("    1. Liczba książek (w tym liczba wypożyczonych)");
			System.out.println("    2. Statystyka książek");
			System.out.println("    ---------------------------");
			System.out.println("    p. powrót");
			System.out.println("    ---------------------------");
			System.out.print(" : ");
			decyzja = s.nextLine();
			znak = decyzja.toLowerCase().charAt(0);

			switch (znak) {
				case '1' :
					System.out.println(filia.ileKsiazek());
					Pausse();
					break;

				case '2' :
					System.out.println(filia.statystyki());
					Pausse();
					break;
			}
		}
	}

	public String ileKsiazek() {
		String wynik = "";
		int wypozyczone = 0;

		wynik = "   liczba wszystkich książek: " + this.ileKsiazek + "\n   ";

		for (Ksiazka k : this.ksiazki)
			if (k.getCzyWypozyczona())
				++wypozyczone;
		wynik += "w tym wypożyczonych: " + wypozyczone;

		return wynik;
	}

	public String statystyki() {

		ArrayList<Ksiazka> popularne = new ArrayList<Ksiazka>();
		popularne.addAll(this.ksiazki);
		Ksiazka tmp = null;

		String wynik = "";
		int przeczytane = 0, max = 0, ile = 5;
		double srednia = 0.00;

		for (int j = 0; j < popularne.size(); j++)
			for (int i = 0; i < popularne.size(); i++) {
				tmp = popularne.get(i);
				if (popularne.get(j).getId() != tmp.getId()
						&& popularne.get(j).getTytul().equals(tmp.getTytul())) {
					popularne.get(j).setLiczbaWypozyczen(
							popularne.get(j).getLiczbaWypozyczen()
									+ tmp.getLiczbaWypozyczen());
					popularne.remove(tmp);
					i = 0;
					j = 0;
				}
			}

		tmp = null;

		for (Ksiazka k : this.ksiazki) {
			srednia += (double) k.getLiczbaWypozyczen();
			if (k.getLiczbaWypozyczen() > 0)
				++przeczytane;
		}

		srednia /= (double) this.ksiazki.size();
		srednia = Math.round(srednia * 100) / 100;
		wynik = "   liczba przeczytanych ksiażek: " + przeczytane + "\n   ";
		wynik += "średnia wypożyczeń na egzemplarz: " + srednia + "\n   ";
		wynik += "5 najbardziej popularnych egzemplarzy: ";

		if (popularne.size() > 5)
			while (ile != 0 && !popularne.isEmpty()) {
				for (Ksiazka k : popularne)
					if (k.getLiczbaWypozyczen() >= max) {
						max = k.getLiczbaWypozyczen();
						tmp = k;
					}
				tmp.ustawkrotkiFormatWyswietlania(true);
				wynik += "\n     " + tmp.toString();
				popularne.remove(tmp);
				--ile;
				max = 0;
			}
		else
			for (Ksiazka k : popularne) {
				k.ustawkrotkiFormatWyswietlania(true);
				wynik += "\n     " + k.toString();
			}

		return wynik;
	}

	public void szukajDialog() {

		Scanner s = new Scanner(System.in);
		String decyzja, wynik = "";
		char znak = ' ';

		while (znak != 'p' && znak != 'q') {
			System.out.println("\n > Wybierz kategorię wyszukiwania:\n");
			System.out.println("    ---------------------------");
			System.out.println("    N. Nazwisko autora");
			System.out.println("    T. Tutuł książki");
			System.out.println("    K. Kategorie tematyczne");
			System.out.println("    ---------------------------");
			System.out.println("    p. powrót");
			System.out.println("    ---------------------------");
			System.out.print(" : ");
			decyzja = s.nextLine();
			znak = decyzja.toLowerCase().charAt(0);

			switch (znak) {
				case 'n' :
					System.out.print(" > podaj nazwisko: ");
					wynik = szukajPoNazwisku(s.nextLine()).toString();
					break;

				case 't' :
					System.out.print(" > podaj tytuł: ");
					wynik = szukajPoTytule(s.nextLine()).toString();
					break;

				case 'k' :
					System.out.print(" > podaj jedną kategorię: ");
					wynik = szukajPoKategorii(s.nextLine()).toString();
					break;
			}

			if (!wynik.isEmpty()) {
				wynik = wynik.substring(1, wynik.length() - 1);
				wynik = wynik.replace(", ", "\n   ");
				System.out.println("   " + wynik);
				Pausse();
				wynik = "";
			}
		}
	}

	public ArrayList<String> szukajPoNazwisku(String nazwisko) {
		ArrayList<String> wynik = new ArrayList<String>();

		for (Ksiazka k : this.ksiazki)
			if (k.getNazwisko().toLowerCase().contains(nazwisko.toLowerCase()))
				wynik.add(k.toString());

		return wynik;
	}

	public ArrayList<String> szukajPoTytule(String tytul) {
		ArrayList<String> wynik = new ArrayList<String>();

		for (Ksiazka k : this.ksiazki)
			if (k.getTytul().toLowerCase().contains(tytul.toLowerCase()))
				wynik.add(k.toString());

		return wynik;
	}

	public ArrayList<String> szukajPoKategorii(String kategoria) {
		ArrayList<String> wynik = new ArrayList<String>();

		for (Ksiazka k : this.ksiazki)
			for (String s : k.getKategorie().split(";"))
				if (s.toLowerCase().equals(kategoria.toLowerCase()))
					wynik.add(k.toString());

		return wynik;
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
							while (!k.setKategorie(s.nextLine()))
								System.out
										.print(" ! pole nie moze byc puste\n : ");
							break;
					}
				}
			}
	}

	public boolean addDialog() {

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
		try {
			rok = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("    ! Zła wartość dla wartości rok!\n");
			return false;
		}
		s.nextLine();
		System.out.print("    kategorie: ");
		kateg = s.nextLine();
		System.out.println("    ---------------------------");

		this.addParametry(tytul, nazwisko, imiona, rok, kateg);
		return true;
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
		this.ileKsiazek++;
		ksiazki.add(k);
	}

	public String toString() {
		return this.listaKsiazek(true);
	}

	public String listaKsiazek(boolean format) {
		for (Ksiazka k : this.ksiazki)
			k.ustawkrotkiFormatWyswietlania(format);
		String lista = this.ksiazki.toString();
		lista = lista.substring(1, lista.length() - 1);
		lista = lista.replaceAll(", ", "\n   ");

		return "   " + lista;
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

	public void aktualizujDane() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("biblioteka.dat");
			oos = new ObjectOutputStream(fos);

			for (Ksiazka k : this.ksiazki)
				oos.writeObject(k);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
			}
		}
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
