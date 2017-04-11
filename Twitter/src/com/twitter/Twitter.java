package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa predstavlja drustvenu mrezu Twitter
 * @author Milica Skembarevic
 * @version 1.0
 *
 */

public class Twitter {
	/**
	 * Atribut poruke je lista koja predstavlja sve poruke na Twitter-u
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	/**
	 * Ova metoda vraca listu svih poruka na Twitter-u
	 * @return <i>lista sa svim porukama</i>
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda pravi novu poruku na Twitter-u i ubacuje je u listu svih poruka
	 * @param <b>korisnik</b> je ime korisnika koji pise poruku
	 * @param <b>poruka</b> predstavlja sadrzaj poruke
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja pretrazuje sve poruke na Twitteru i vraca niz poruka koje sadrze zadati tag
	 * @param <b>maxBroj</b> predstavlja maksimalan broj elemenata niza koji metoda vraca
	 * @param <b>tag</b> predstavlja oznaku koja se pretrazuje u listi svih poruka
	 * @return <i>Ova metoda vraca niz poruka koji imaju zadati tag</i>
	 * @throws java.lang.RuntimeException kada tag ima vrednosti null ili prazan String
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}

} 