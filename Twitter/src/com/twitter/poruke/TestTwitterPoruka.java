package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTwitterPoruka {

	private TwitterPoruka t;

	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}


	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Milica");
		assertEquals("Milica",t.getKorisnik());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		
		t.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		
		t.setKorisnik("");
	}


	@Test
	public void testSetPoruka() {
		t.setPoruka("Poruka");
		assertEquals("Ovo je poruka", t.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		
		t.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaEmptyString() {
		
		t.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaViseOd140() {
		
		t.setPoruka("milicamilicamilicamilicamilicamilicamilicamilicamilicamilica"
				+ "milicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilica"
				+ "milicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilica"
				+ "milicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilica"
				+ "milicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilicamilica");
	}

	@Test
	public void testToString() {
		t.setKorisnik("Milica");
		t.setPoruka("Poruka");
		assertEquals("KORISNIK:"+t.getKorisnik()+" PORUKA:"+t.getPoruka(),t.toString());
	}

}
