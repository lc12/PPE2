package amortissements;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreditTest {

	@Test
	public void testCalculeTaux() {
		/*fail("Not yet implemented");
		Credit c = new Credit(1,100.0,5.0,5,5);
		Credit c1 = new Credit(1,100.0,5.0,5,5);
		assertTrue(c.annuiteMax == c1.annuiteMax && c.duree == c1.duree );*/
		//double taux = 5;
		//double taux1 = 5;
		//assertEquals(Credit.calculeTaux(1, 15000, 2500, 6).taux ,taux, 2);
		//assertEquals(Credit.calculeTaux(1, 15000, 2955, 6).taux ,taux1, 2);
	}

	@Test
	public void testCalculeDuree() {
		//fail("Not yet implemented");
		int duree = 6;
		//int duree1 = 6;
		assertEquals(Credit.calculeDuree(1, 15000, 2500, 5).duree, duree, 2);
		//assertEquals(Credit.calculeDuree(2, 15000, 2955, 5).duree, duree1, 2);
	}

	@Test
	public void testCalculeMontantEmprunte() {
		//fail("Not yet implemented");
		//double MontantE = 15000 ;
		//double MontantE2 = 15000;
		//assertEquals(Credit.calculeMontantEmprunte(1, 3250, 5, 6).montantEmprunt,MontantE,2);
		//assertEquals(Credit.calculeMontantEmprunte(2, 2955, 5, 6).montantEmprunt,MontantE2,2);
	}

	@Test
	public void testCalculeAnuiteMaximale() {
		//fail("Not yet implemented");
		double Annuité = 3250;
		//double Annuité2 = 2955;
		assertEquals(Credit.calculeAnuiteMaximale(1, 15000, 5, 6).annuiteMax,Annuité, 2);
		//assertEquals(Credit.calculeAnuiteMaximale(2, 15000, 5, 6).annuiteMax,Annuité2, 2);
	}

}
