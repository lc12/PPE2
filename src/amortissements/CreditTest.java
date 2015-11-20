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
		double taux = 5;
		double taux1 = 0.05;
		assertEquals(taux, Credit.calculeTaux(1, 15000, 3250, 6).taux , 0.1);
		assertEquals(taux1,Credit.calculeTaux(2, 15000, 2955, 6).taux, 0.01);
	}

	@Test
	public void testCalculeDuree() {
		//fail("Not yet implemented");
		int duree = 6;
		int duree1 = 6;
		assertEquals(duree, Credit.calculeDuree(1, 15000, 3250, 5).duree, 1);
		assertEquals(duree1, Credit.calculeDuree(2, 15000, 2955, 0.05).duree, 1);
	}

	@Test
	public void testCalculeMontantEmprunte() {
		//fail("Not yet implemented");
		double MontantE = 15000 ;
		double MontantE2 = 15000;
		assertEquals(MontantE, Credit.calculeMontantEmprunte(1, 3250, 5, 6).montantEmprunt,2);
		assertEquals(MontantE2, Credit.calculeMontantEmprunte(2, 2955, 0.05, 6).montantEmprunt,2);
	}

	@Test
	public void testCalculeAnuiteMaximale() {
		//fail("Not yet implemented");
		double Annuite = 3250;
		double Annuité = 2955;
		assertEquals(Annuite, Credit.calculeAnuiteMaximale(1, 15000, 5, 6).annuiteMax, 2);
		assertEquals(Annuité,Credit.calculeAnuiteMaximale(2, 15000, 0.05, 6).annuiteMax, 0.5);
	}
	
//	@Test
//	public void tastCalculeTauxDich(){
//		double taux = 0.05;
//		assertEquals(taux, Credit.calcAnuitConstanteDichTaux(15000, 2955, 6, 0, 100), 0.001);
//	}

}
