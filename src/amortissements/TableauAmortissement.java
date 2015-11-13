package amortissements;

/**
 * Représente le tableau d'amortissement d'un crédit.
 */

public class TableauAmortissement 
{
	/**
	 * Crée le tableau d'amortissement du crédit passé en paramètre.
	 */
	Ligne[] tabAmor;
	public TableauAmortissement(Credit credit)
	{
		this.tabAmor = new Ligne[credit.duree];
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
		// TODO à compléter.
		return null;
	}
}
