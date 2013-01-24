package org.mariusz.classes;

import java.io.Console;
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

		Ksiazka kniga = null;

		try {
			kniga = new Ksiazka("Star Wars", "Lucas", "Gorge Arek", 1992,
					"Sciencefiction");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Biblioteka filia = new Biblioteka();
		filia.add(kniga);
		filia.wypiszKsiazki_krotkiFormat();
		filia.wypiszKsiazki_dlugiFormat();
		filia.addDialog();
		filia.wypiszKsiazki_krotkiFormat();

	}

	public void addDialog() {
		Scanner s = new Scanner(System.in);
		String tytul, imiona, nazwisko, kateg;
		int rok;
		Ksiazka nowa = null;
	
		System.out.print("\n Prosze podać:\n");
		System.out.print("\ttytul: ");
		tytul = s.nextLine();
		System.out.print("\timiona autora (oddzielone spacjami): ");
		imiona = s.nextLine();
		System.out.print("\tnazwisko autora: ");
		nazwisko = s.nextLine();
		System.out.print("\trok: ");
		rok = s.nextInt();
		s.nextLine();
		System.out.print("\tkategorie (oddzielone średnikami): ");
		kateg = s.nextLine();

		try {
			nowa = new Ksiazka(tytul, nazwisko, imiona, rok, kateg);
			this.add(nowa);
		} catch (Exception e) {
			System.out.println("\n\n ! error: błędne dane:");
			System.out.println("\t"+e.toString().substring(
					e.toString().indexOf(":") + 2));
		}
	}

	public void add(Ksiazka k) {
		ksiazki.add(k);
	}

	public void wypiszKsiazki_krotkiFormat() {
		for (Ksiazka k : this.ksiazki)
			k.ustawkrotkiFormatWyswietlania(true);
		String lista = this.ksiazki.toString();
		lista = lista.substring(1, lista.length() - 1);
		lista = lista.replaceAll(", ", "\n");

		System.out.println(lista);
	}

	public void wypiszKsiazki_dlugiFormat() {
		for (Ksiazka k : this.ksiazki)
			k.ustawkrotkiFormatWyswietlania(false);
		String lista = this.ksiazki.toString();
		lista = lista.substring(1, lista.length() - 1);
		lista = lista.replaceAll(", ", "\n");

		System.out.println(lista);
	}
}
