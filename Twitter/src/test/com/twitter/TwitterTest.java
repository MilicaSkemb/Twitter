package test.com.twitter;


import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;



public class TwitterTest {

	Twitter t;


	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {

		t.unesi("Milica", "Poruka1");
		t.unesi("Milica", "Poruka2");
		t.unesi("Milica", "Poruka3");

		LinkedList<TwitterPoruka> tp = new LinkedList<TwitterPoruka>();

		TwitterPoruka t1 = new TwitterPoruka();
		t1.setKorisnik("Milica");
		t1.setPoruka("Poruka1");
		tp.addLast(t1);
		TwitterPoruka t2 = new TwitterPoruka();
		t2.setKorisnik("Milica");
		t2.setPoruka("Poruka2");
		tp.addLast(t2);
		TwitterPoruka t3 = new TwitterPoruka();
		t3.setKorisnik("Milica");
		t3.setPoruka("Poruka3");
		tp.addLast(t3);

		assertEquals(tp, t.vratiSvePoruke());
		
	}

	@Test
	public void testUnesi(){
		t.unesi("Milica", "Poruka");

		assertEquals("Milica", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Poruka",t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test
	public void testVratiPoruke() {

		t.unesi("Milica", "Poruka 1");
		t.unesi("Milica", "Poruka 2");
		t.unesi("Milica", "Poruka3");

		TwitterPoruka[] tp = new TwitterPoruka[10];

		TwitterPoruka t1 = new TwitterPoruka();
		t1.setKorisnik("Milica");
		t1.setPoruka("Poruka 1");
		ubaciPorukuUNiz(tp,t1);
		TwitterPoruka t2 = new TwitterPoruka();
		t2.setKorisnik("Milica");
		t2.setPoruka("Poruka 2");
		ubaciPorukuUNiz(tp, t2);
		TwitterPoruka t3 = new TwitterPoruka();
		t3.setKorisnik("Milica");
		t3.setPoruka("Poruka3");
		ubaciPorukuUNiz(tp, t3);


		assertArrayEquals(tp, t.vratiPoruke(10, "Poruka"));

	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(50, null);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(50, "");
	}

	private void ubaciPorukuUNiz(TwitterPoruka[] p, TwitterPoruka t){
		for(int i = 0; i < p.length ;i++){
			if(p[i] == null){
				p[i] = t;
				return;
			}
		}
	}

}



