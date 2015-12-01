package amortissements;

/**
 * Représente le tableau d'amortissement d'un crédit.
 */

public class TableauAmortissement 
{
	Ligne[] tabAmor;
	/**
	 * Cr�e le tableau d'amortissement du cr�dit pass� en param�tre.
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
	 * Retourne la durée de l'amortissement.
	 */
	
	public int getNbLignes()
	{
		return tabAmor.length;
	}
	
	/**
	 * Retourne la i-ème ligne du tableau d'amortissement.
	 * Les indices commencent à 0.
	 */
	
	public Ligne getLigne(int i)
	{
		return tabAmor[i];		
	}
	
	/**
	 * Retourne une représentation du tableau au format 
	 * chaîne de caractères.
	 */
	
	public String toString() {
		String leTableau ="";
		
		for (Ligne ligne : tabAmor) {
			leTableau += "Annee = " + ligne.getAnnee()
					+ " Capital Initial = " + Math.round(ligne.getCapitalInitial())
					+ " Interet = " + Math.round(ligne.getInterets())
					+ " Amortissement = " + Math.round(ligne.getAmortissements())
					+ " Annuite = " + ligne.getAnnuite()
					+ " Capital Final = " + Math.round(ligne.getCapitalFinal()) + "\n";
		}
		return leTableau;
	}
}
