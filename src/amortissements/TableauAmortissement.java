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
			tabAmor[i] = laLigne.ligneSuivante(credit);
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
		// TODO à compléter.
		return null;
	}
}
