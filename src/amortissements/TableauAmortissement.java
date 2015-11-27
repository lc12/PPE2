package amortissements;

/**
 * ReprÃ©sente le tableau d'amortissement d'un crÃ©dit.
 */

public class TableauAmortissement 
{
	Ligne[] tabAmor;
	/**
	 * Crée le tableau d'amortissement du crédit passé en paramètre.
	 */
	
	public TableauAmortissement(Credit credit)
	{
		this.tabAmor = new Ligne[credit.duree];
		Ligne laLigne = Ligne.premiereLigne(credit);
		tabAmor[0] = laLigne;
		
		for (int i=1 ; i < tabAmor.length ; i++)
		{
			tabAmor[i] = tabAmor[i-1].ligneSuivante(credit);
			
			if (i == tabAmor.length-1 && tabAmor[i].capitalFinal != 0.00 ) {
				tabAmor[i].annuite += tabAmor[i].capitalFinal;
				tabAmor[i].capitalFinal = 0;
			}
		}
	}
	
	/**
	 * Retourne la durÃ©e de l'amortissement.
	 */
	
	public int getNbLignes()
	{
		return tabAmor.length;
	}
	
	/**
	 * Retourne la i-Ã¨me ligne du tableau d'amortissement.
	 * Les indices commencent Ã  0.
	 */
	
	public Ligne getLigne(int i)
	{
		return tabAmor[i];		
	}
	
	/**
	 * Retourne une reprÃ©sentation du tableau au format 
	 * chaÃ®ne de caractÃ¨res.
	 */
	
	public String toString() {
		String leTableau ="";
		
		for (Ligne ligne : tabAmor) {
			leTableau += "Année = " + ligne.getAnnee()
					+ " Capital Initial = " + Math.round(ligne.getCapitalInitial())
					+ " Interet = " + Math.round(ligne.getInterets())
					+ " Amortissement = " + Math.round(ligne.getAmortissements())
					+ " Anuité = " + ligne.getAnnuite()
					+ " Capital Final = " + Math.round(ligne.getCapitalFinal()) + "\n";
		}
		return leTableau;
	}
}
