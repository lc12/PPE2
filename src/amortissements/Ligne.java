package amortissements;

/**
 * Ligne du tableau d'amortissement d'un crédit.
 */

public class Ligne 
{
	int annee;
	double capitalInitial, interets, amortissements, annuite, capitalFinal;
	/**
	 * Crée une ligne à partir des valeurs passées en paramètres.
	 */

	Ligne(int annee, double capitalInitial, double interets, 
			double amortissements, double annuite, double capitalFinal)
	{
		this.annee = annee;
		this.capitalInitial = capitalInitial;
		this.interets = interets;
		this.amortissements = amortissements;
		this.annuite = annuite;
		this.capitalFinal = capitalFinal;
	}

	/**
	 * Retourne l'indice de l'année concernée par la ligne.
	 * Les indices commencent à 1.
	 */
	
	public int getAnnee()
	{
		// TODO à compléter.
		return annee;
	}
	
	/**
	 * Retourne le montant du capital restant dû au début 
	 * de la période.
	 */
	
	public double getCapitalInitial()
	{
		// TODO à compléter.
		return capitalInitial;
	}
	
	/**
	 * Retourne le montant des intérêts versés pendant la période.
	 */
	
	public double getInterets()
	{
		// TODO à compléter.
		return interets;
	}

	/**
	 * Retourne le montant du capital amorti pendant la période.
	 */
	
	public double getAmortissements()
	{
		// TODO à compléter.
		return amortissements;
	}

	/**
	 * Retourne le montant de l'annuité pendant la période.
	 */
	
	public double getAnnuite()
	{
		// TODO à compléter.
		return annuite;
	}
	
	/**
	 * Retourne le montant du capital restant dû à la fin
	 * de la période.
	 */
	
	public double getCapitalFinal()
	{
		// TODO à compléter.
		return capitalFinal;
	}
	
	/**
	 * Retourne la première ligne du tableau d'amortissement pour
	 * le crédit passé en paramètre.
	 */
	
	public static Ligne premiereLigne(Credit credit)
	{
		Ligne premiereLigne;
		double amortissement;
		
		if (credit.typeCredit == Credit.AMORTISSEMENT_CONSTANTS)
		{
			amortissement = credit.montantEmprunt/credit.duree;
		}
		else
		{
			amortissement = credit.annuiteMax-(credit.montantEmprunt/100*credit.taux);
		}
		
		premiereLigne = new Ligne(1, 
				credit.montantEmprunt, 
				credit.taux*credit.montantEmprunt/100,
				amortissement,
				credit.annuiteMax,
				credit.montantEmprunt-amortissement);
		
		return premiereLigne;
	}

	/**
	 * Retourne la ligne suivant la ligne courante pour le 
	 * passé en paramètre. Retoure null si la ligne courante est
	 * la dernière ligne.
	 */
	
	public Ligne ligneSuivante(Credit credit)
	{
		int annee = this.annee + 1;
		double capitalInitial = this.getCapitalFinal();
		double interets = credit.taux*capitalInitial/100;
		double amortissements;
		double annuite;
		
		if (credit.typeCredit == Credit.ANNUITES_CONSTANTES)
		{
			amortissements = credit.annuiteMax-(capitalInitial/100*credit.taux);
			annuite = this.annuite;
		}
		else
		{
			amortissements = this.amortissements;
			annuite = amortissements + interets;
		}
		
		double capitalFinal = this.getCapitalFinal() - amortissements;
		
		return new Ligne(annee, capitalInitial, interets, amortissements, annuite , capitalFinal);
	}
}
