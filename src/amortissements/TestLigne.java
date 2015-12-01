package amortissements;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLigne {

	@Test
	public final void testPremiereLigne() {
		//fail("Not yet implemented"); // TODO
			double CF = 12500;
			int Annee = 1;
			double CI = 15000;
			double Int = 750;
			double Amort = 2500;
			double Annuit = 3250;
			Ligne l1 = Ligne.premiereLigne(new Credit(1,15000,3250,5,6));
			assertEquals(CF, l1.capitalFinal,0.5);
			assertEquals(Annee, l1.annee,0.5);
			assertEquals(CI, l1.capitalInitial,0.5);
			assertEquals(Int, l1.interets,0.5);
			assertEquals(Amort, l1.amortissements,0.5);
			assertEquals(Annuit, l1.annuite,0.5);
			
			double CF1 = 12795;
			int Annee1 = 1;
			double CI1 = 15000;
			double Int1 = 750;
			double Amort1 = 2205;
			double Annuit1 = 2955;
			Ligne l2 = Ligne.premiereLigne(new Credit (2, 15000, 2955,5, 6));
			assertEquals(CF1, l2.capitalFinal,0.5);
			assertEquals(Annee1, l2.annee,0.5);
			assertEquals(CI1, l2.capitalInitial,0.5);
			assertEquals(Int1, l2.interets,0.5);
			assertEquals(Amort1, l2.amortissements,0.5);
			assertEquals(Annuit1, l2.annuite,0.5);
					
		
	}

	@Test
	public final void testLigneSuivante() {
		//fail("Not yet implemented"); // TODO
		int Annee = 2;
		double CI = 12500;
		double Int = 625;
		double Amort = 2500;
		double Annuit = 3125;
		double CF = 10000;
		Ligne l1 = new Ligne(1,15000,750,2500, 3250, 12500);
		assertEquals(Annee, l1.ligneSuivante(new Credit(1,15000,3250,5,6)).annee, 0.5);
		assertEquals(CI, l1.ligneSuivante(new Credit(1,15000,3250,5,6)).capitalInitial, 0.5);
		assertEquals(Int, l1.ligneSuivante(new Credit(1,15000,3250,5,6)).interets, 0.5);
		assertEquals(Amort, l1.ligneSuivante(new Credit(1,15000,3250,5,6)).amortissements, 0.5);
		assertEquals(Annuit, l1.ligneSuivante(new Credit(1,15000,3250,5,6)).annuite, 0.5);
		assertEquals(CF, l1.ligneSuivante(new Credit(1,15000,3250,5,6)).capitalFinal, 0.5);
		
		int Annee1 = 2;
		double CI1 = 12795;
		double Int1 = 640;
		double Amort1 = 2316;
		double Annuit1 = 2955;
		double CF1 = 10479;
		Ligne l2 = new Ligne(1,15000,750,2205, 2955, 12795);
		assertEquals(Annee1, l2.ligneSuivante(new Credit(2,15000, 2955,5, 6)).annee, 0.5);
		assertEquals(CI1, l2.ligneSuivante(new Credit(2,15000, 2955,5, 6)).capitalInitial, 0.5);
		assertEquals(Int1, l2.ligneSuivante(new Credit(2,15000, 2955,5, 6)).interets, 0.5);
		assertEquals(Amort1, l2.ligneSuivante(new Credit(2,15000, 2955,5, 6)).amortissements, 1);
		assertEquals(Annuit1, l2.ligneSuivante(new Credit(2,15000, 2955,5, 6)).annuite, 0.5);
		assertEquals(CF1, l2.ligneSuivante(new Credit(2,15000, 2955, 5, 6)).capitalFinal, 1);
	}

}
