package amortissements;

import java.lang.Math;
/**
 * Représente un crédit.
 */

public class Credit 
{
	public final static int AMORTISSEMENT_CONSTANTS = 1,
			ANNUITES_CONSTANTES = 2;

	int typeCredit;
	double annuiteMax;
	double montantEmprunt;
	double taux;
	int duree;
	
	
	
	/**
	 * Créée un crédit.
	 */
	
	Credit (int typeCredit, double montantEmprunte, double annuiteMaximale,
			double taux, int duree)
	{
		this.typeCredit = typeCredit;
		this.annuiteMax = annuiteMaximale;
		this.montantEmprunt = montantEmprunte;
		this.taux = taux;
		this.duree = duree;
	}
	
	/**
	 * Retourné le montant emprunté.
	 */
	
	public double montantEmprunte()
	{
		return montantEmprunt;
	}
	
	/**
	 * Retourne le montant de la plus grande annuité. 
	 */
	
	public double annuiteMaximale()
	{
		return annuiteMax;
	}
	
	/**
	 * Retourne le taux du crédit.
	 */
	
	public double taux()
	{
		return taux;
	}
	
	/**
	 * Retourne nombre d'annuités à verser.
	 */
	
	public int duree()
	{
		return duree;
	}
	
	/**
	 * Retourne le tableau d'amortissement du crédit.
	 */
	
	public TableauAmortissement getTableauAmortissement()
	{
		// TODO à compléter.
		return null;
	}
	
	/**
	 * Retourne un crédit en calculant automatiquement le taux.
	 */
	
	public static Credit calculeTaux(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			int duree)
	{
		Credit cred = new Credit(typeCredit,montantEmprunte,annuiteMaximale, (annuiteMaximale-(montantEmprunte/duree)*100)/montantEmprunte,duree);
		return cred;
	}
	
	/**
	 * Retourne un crédit en calculant automatiquement la durée.
	 */
	
	public static Credit calculeDuree(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			double taux)
	{
		// TODO à compléter
		
		return null;
	}

	/**
	 * Retourne un crédit en calculant automatiquement le montant
	 * 	qu'il est possible d'emprunter.
	 */
	
	public static Credit calculeMontantEmprunte(int typeCredit, 
			double annuiteMaximale,	double taux, int duree)
	{
		// TODO à compléter
		return null;
	}

	/**
	 * Retourne un crédit en calculant automatiquement
	 * l'annuité maximale.
	 */
	
	public static Credit calculeAnuiteMaximale(int typeCredit, 
			double montantEmprunte,	double taux, int duree)
	{
		double anuite;
		
		if (typeCredit == ANNUITES_CONSTANTES)
		{
			anuite = montantEmprunte*(taux/(1- Math.pow((1+taux), (double)-duree)));
		}
		else
		{
			anuite = montantEmprunte/duree+montantEmprunte/100*taux;
		}
		
		return new Credit(typeCredit, montantEmprunte, anuite , taux, duree);
	}
	
	
}
