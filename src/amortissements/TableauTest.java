package amortissements;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableauTest {

	@Test
	public final void testTableauAmortissement() {
		//fail("Not yet implemented"); // TODO
//		Ligne l1 = Ligne.premiereLigne(new Credit(1,15000,3250,5,6) );
//		TableauAmortissement ta = new TableauAmortissement(new Credit (1,15000,3250,5,6));
//		assertEquals(l1,ta.tabAmor);
	}

	@Test
	public final void testToString() {
		//fail("Not yet implemented"); // TODO
		String letableau = "Annee = 1 Capital Initial = 15000 Interet = 750 Amortissement = 2500 Annuite = 3250.0 Capital Final = 12500"+ "\n"
				+ "Annee = 2 Capital Initial = 12500 Interet = 625 Amortissement = 2500 Annuite = 3125.0 Capital Final = 10000"+ "\n"
				+ "Annee = 3 Capital Initial = 10000 Interet = 500 Amortissement = 2500 Annuite = 3000.0 Capital Final = 7500" + "\n"
				+ "Annee = 4 Capital Initial = 7500 Interet = 375 Amortissement = 2500 Annuite = 2875.0 Capital Final = 5000" + "\n"
				+ "Annee = 5 Capital Initial = 5000 Interet = 250 Amortissement = 2500 Annuite = 2750.0 Capital Final = 2500" + "\n"
				+ "Annee = 6 Capital Initial = 2500 Interet = 125 Amortissement = 2500 Annuite = 2625.0 Capital Final = 0" + "\n";
		TableauAmortissement t = new TableauAmortissement(new Credit(1,15000,3250,5,6));
		assertEquals(letableau, t.toString());
	}

}
