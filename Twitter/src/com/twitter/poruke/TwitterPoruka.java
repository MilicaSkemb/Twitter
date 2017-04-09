package com.twitter.poruke;


/**
* Klasa definise poruku na drustvenoj mrezi Twitter0.
* @author Milica Skembarevic
* @version 1.0
*
*/

public class TwitterPoruka {
	/**
	  * Atribut ime korisnika kao String.
	  * 
	  */
	private String korisnik;
	
	/**
	 * Atribut sadrzaj poruke na Twitteru kao String.
	 * 
	 */
	private String poruka;
	/**
	 * Metoda koja vraca naziv korisnika.
	 * @return trenutni naziv korisnika.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Metoda koja postavlja vrednost atributa korisnik.
	 * @param korisnik prestavlja String koji stavljamo da bude naziv korisnika
	 * @throws java.lang.RuntimeException u slucaju da je parametar null ili prazan String
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || !korisnik.isEmpty())
		throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Metoda koja vraca sadrzaj poruke.
	 * @return sadrzaj poruke
	 */
	
	public String getPoruka() {
		return "poruka";
	}
	/**
	 * Metoda koja postavlja novu vrednost u atribut poruka
	 * @param poruka predstavlja tekst poruke
	 * @throws java.lang.RuntimeException  u slucaju da je parametar null ili prazan String
	 */
	public void setPoruka(String poruka) {
		if (this.poruka==null || this.poruka == new String("") ||
		this.poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
			this.poruka = poruka;
	}
	/**
	 * Metoda vraca trenutne vrednosti atributa kroz jedan String.
	 * @return String sa vrednostima atributa korisnik i poruka
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
