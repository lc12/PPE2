package amortissements;

import java.lang.Math;
/**
 * ReprÃ©sente un crÃ©dit.
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
	 * CrÃ©Ã©e un crÃ©dit.
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
	 * RetournÃ© le montant empruntÃ©.
	 */
	
	public double montantEmprunte()
	{
		return montantEmprunt;
	}
	
	/**
	 * Retourne le montant de la plus grande annuitÃ©. 
	 */
	
	public double annuiteMaximale()
	{
		return annuiteMax;
	}
	
	/**
	 * Retourne le taux du crÃ©dit.
	 */
	
	public double taux()
	{
		return taux;
	}
	
	/**
	 * Retourne nombre d'annuitÃ©s Ã  verser.
	 */
	
	public int duree()
	{
		return duree;
	}
	
	/**
	 * Retourne le tableau d'amortissement du crÃ©dit.
	 */
	
	public TableauAmortissement getTableauAmortissement()
	{
		return new TableauAmortissement(this);
	}
	
	/**
	 * Retourne un crÃ©dit en calculant automatiquement le taux.
	 * @param typeCredit
	 * @param montantEmprunte
	 * @param annuiteMaximale
	 * @param duree
	 * @return Le credit cree avec le taux calcule
	 */
	public static Credit calculeTaux(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			int duree)
	{
		double taux;
		
		if (typeCredit == ANNUITES_CONSTANTES)
		{
			taux = calcAnuitConstanteDichTaux(montantEmprunte, annuiteMaximale, duree, 50, 0, 100);
		}
		else
		{
			taux = (annuiteMaximale-(montantEmprunte/duree)*100)/montantEmprunte;
		}
		
		return new Credit(typeCredit, montantEmprunte, annuiteMaximale, taux, duree);
	}
	
	/**
	 * Calcule par dichotomis le taux.
	 * @param montantEmprunte
	 * @param annuiteMaximal
	 * @param duree
	 * @param taux
	 * @param min
	 * @param max
	 * @return le taux trouve
	 */
	private static double calcAnuitConstanteDichTaux(double montantEmprunte, double annuiteMaximal, int duree, 
			double taux, double min, double max)
	{
		if (!precisionOk(montantEmprunte, annuiteMaximal, duree, taux))
		{
			if (montantEmprunte*(taux/(1- Math.pow((1+taux), (double)-duree))) > annuiteMaximal)
			{
				return calcAnuitConstanteDichTaux( montantEmprunte, annuiteMaximal, duree, taux/2 , min, taux-1);
			}
			else
			{
				return calcAnuitConstanteDichTaux( montantEmprunte, annuiteMaximal, duree, taux+(max-taux/2), taux+1, max);
			}
		}
		else
		{
			return taux;
		}
	}
	
	/**
	 * Test si la precision est acceptable pour l'etat des variable actuelle par
	 * rapport aux resultats attendu.
	 * @param montantEmprunte
	 * @param annuiteMaximal
	 * @param duree
	 * @param taux
	 * @return Un boolean true si la precision est ok sinon false
	 */
	private static boolean precisionOk(double montantEmprunte, double annuiteMaximal, int duree, 
			double taux)
	{
		return (annuiteMaximal - montantEmprunte*(taux/(1- Math.pow((1+taux), (double)-duree))) < 0.10 
				&& annuiteMaximal - montantEmprunte*(taux/(1- Math.pow((1+taux), (double)-duree))) > -0.10);
	}
	
	/**
	 * Retourne un crédit en calculant automatiquement la durée.
	 * @param typeCredit
	 * @param montantEmprunte
	 * @param annuiteMaximale
	 * @param taux
	 * @return retourne le credit crée avec le montant calculé
	 */
	public static Credit calculeDuree(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			double taux)
	{
		int duree;
		
		if (typeCredit == ANNUITES_CONSTANTES)
		{
			duree = calcAnuitConstanteDichDuree(montantEmprunte, annuiteMaximale, 275, taux, 0, 550);
		}
		else
		{
			duree = (int)(montantEmprunte/(annuiteMaximale-(montantEmprunte/100*taux)));
		}
		
		return new Credit(typeCredit, montantEmprunte, annuiteMaximale, taux, duree);
	}
	
	/**
	 * calcule par dichotomie la duree
	 * @param montantEmprunte
	 * @param annuiteMaximal
	 * @param duree
	 * @param taux
	 * @param min
	 * @param max
	 * @return la duree
	 */
	private static int calcAnuitConstanteDichDuree(double montantEmprunte, double annuiteMaximal, int duree, 
			double taux, double min, double max)
	{
		if (!precisionOk(montantEmprunte, annuiteMaximal, duree, taux))
		{
			if (montantEmprunte*(taux/(1- Math.pow((1+taux), (double)-duree))) > annuiteMaximal)
			{
				return calcAnuitConstanteDichDuree( montantEmprunte, annuiteMaximal, (int)duree/2, taux , min, duree-1);
			}
			else
			{
				return calcAnuitConstanteDichDuree( montantEmprunte, annuiteMaximal, (int)(duree+(max-duree/2)), taux, taux+1, max);
			}
		}
		else
		{
			return duree;
		}
	}

	/**
	 * Retourne un crÃedit en calculant automatiquement le montant
	 * 	qu'il est possible d'emprunter.
	 */
	
	/**
	 * Retourne un credit en calculant automatiquement la valeur de l'emprunt
	 * @param typeCredit
	 * @param annuiteMaximale
	 * @param taux
	 * @param duree
	 * @return le credit cree avec la valeur calculé
	 */
	public static Credit calculeMontantEmprunte(int typeCredit, 
			double annuiteMaximale,	double taux, int duree)
	{
		double montantEmprunte;
		
		if (typeCredit == ANNUITES_CONSTANTES)
		{
			montantEmprunte = calcAnuitConstanteDichMontant(5000000, annuiteMaximale, duree, taux, 1, 1000000);
		}
		else
		{
			montantEmprunte = annuiteMaximale/(1/duree+taux);
		}
		
		return new Credit(typeCredit, montantEmprunte, annuiteMaximale, taux, duree);
	}
	
	/**
	 * Calcule par dichotomi le montant du prèt
	 * @param montantEmprunte
	 * @param annuiteMaximal
	 * @param duree
	 * @param taux
	 * @param min
	 * @param max
	 * @return leMontant de du pret calculé
	 */
	private static int calcAnuitConstanteDichMontant(double montantEmprunte, double annuiteMaximal, int duree, 
			double taux, double min, double max)
	{
		if (!precisionOk(montantEmprunte, annuiteMaximal, duree, taux))
		{
			if (montantEmprunte*(taux/(1- Math.pow((1+taux), (double)-duree))) > annuiteMaximal)
			{
				return calcAnuitConstanteDichMontant( montantEmprunte/2, annuiteMaximal, duree, taux , min, duree-1);
			}
			else
			{
				return calcAnuitConstanteDichMontant( montantEmprunte+(max-duree/2), annuiteMaximal, duree, taux, taux+1, max);
			}
		}
		else
		{
			return duree;
		}
	}

	/**
	 * Retourne un credit en calculant automatiquement
	 * l'annuite maximale.
	 */
	
	public static Credit calculeAnuiteMaximale(int typeCredit, 
			double montantEmprunte,	double taux, int duree)
	{
		double annuite;
		
		if (typeCredit == ANNUITES_CONSTANTES)
		{
			annuite = montantEmprunte*(taux/(1- Math.pow((1+taux), (double)-duree)));
		}
		else
		{
			annuite = montantEmprunte/duree+montantEmprunte/100*taux;
		}
		
		return new Credit(typeCredit, montantEmprunte, annuite , taux, duree);
	}
	
	
}