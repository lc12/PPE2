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
		return new TableauAmortissement(this);
	}
	
	/**
	 * Retourne un crédit en calculant automatiquement le taux.
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
			taux = calcAnuitConstanteDichTaux(montantEmprunte, annuiteMaximale, duree, 0, 100);
		}
		else
		{
			taux = (annuiteMaximale-(montantEmprunte/duree))/(montantEmprunte/100);
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
	public static double calcAnuitConstanteDichTaux(double montantEmprunte, double annuiteMaximal, int duree, 
			 double min, double max)
	{
		double taux = (min+max)/2;
		if (!precisionOk(montantEmprunte, annuiteMaximal, duree, taux))
		{
			if (montantEmprunte*taux/(1- Math.pow(1+taux, (double)-duree)) > annuiteMaximal)
			{
				return calcAnuitConstanteDichTaux( montantEmprunte, annuiteMaximal, duree , min, taux);
			}
			else
			{
				return calcAnuitConstanteDichTaux( montantEmprunte, annuiteMaximal, duree, taux, max);
			}
		}
		else
		{
			return taux;
		}
	}
	
	
	/**
	 * Retourne un cr�dit en calculant automatiquement la dur�e.
	 * @param typeCredit
	 * @param montantEmprunte
	 * @param annuiteMaximale
	 * @param taux
	 * @return retourne le credit cr�e avec le montant calcul�
	 */
	public static Credit calculeDuree(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			double taux)
	{
		int duree;
		if (typeCredit == ANNUITES_CONSTANTES)
		{
			duree = calcAnuitConstanteDichDuree(montantEmprunte, annuiteMaximale, taux, 0, 80);
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
	private static int calcAnuitConstanteDichDuree(double montantEmprunte, double annuiteMaximal, 
			double taux, double min, double max)
	{
		int duree = (int)((min+max)/2);
		if (!precisionOk(montantEmprunte, annuiteMaximal, duree, taux))
		{
			if (montantEmprunte*taux/(1- Math.pow(1+taux, (double)-duree)) < annuiteMaximal)
			{
				return calcAnuitConstanteDichDuree( montantEmprunte, annuiteMaximal, taux , min, duree);
			}
			else
			{
				return calcAnuitConstanteDichDuree( montantEmprunte, annuiteMaximal, taux, duree, max);
			}
		}
		else
		{
			return duree;
		}
	}

	/**
	 * Retourne un cr�edit en calculant automatiquement le montant
	 * 	qu'il est possible d'emprunter.
	 */
	
	/**
	 * Retourne un credit en calculant automatiquement la valeur de l'emprunt
	 * @param typeCredit
	 * @param annuiteMaximale
	 * @param taux
	 * @param duree
	 * @return le credit cree avec la valeur calcul�
	 */
	public static Credit calculeMontantEmprunte(int typeCredit, 
			double annuiteMaximale,	double taux, int duree)
	{
		double montantEmprunte;
		
		if (typeCredit == ANNUITES_CONSTANTES)
		{
			montantEmprunte = calcAnuitConstanteDichMontant(annuiteMaximale, duree, taux, 1, 1000000);
		}
		else
		{
			montantEmprunte = annuiteMaximale/(1/duree+taux);
		}
		
		return new Credit(typeCredit, montantEmprunte, annuiteMaximale, taux, duree);
	}
	
	/**
	 * Calcule par dichotomi le montant du pr�t
	 * @param montantEmprunte
	 * @param annuiteMaximal
	 * @param duree
	 * @param taux
	 * @param min
	 * @param max
	 * @return leMontant de du pret calcul�
	 */
	private static double calcAnuitConstanteDichMontant(double annuiteMaximal, int duree, 
			double taux, double min, double max)
	{
		double montantEmprunte = (min+max)/2;
		System.out.println(montantEmprunte);
		if (!precisionOk(montantEmprunte, annuiteMaximal, duree, taux))
		{
			if (montantEmprunte*taux/(1- Math.pow(1+taux, (double)-duree)) > annuiteMaximal)
			{
				return calcAnuitConstanteDichMontant(annuiteMaximal, duree, taux , min, montantEmprunte);
			}
			else
			{
				return calcAnuitConstanteDichMontant(annuiteMaximal, duree, taux, montantEmprunte, max);
			}
		}
		else
		{
			return montantEmprunte;
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
			annuite = montantEmprunte*taux/(1- Math.pow(1+taux, (double)-duree));
		}
		else
		{
			annuite = montantEmprunte/duree+montantEmprunte/100*taux;
		}
		
		return new Credit(typeCredit, montantEmprunte, annuite , taux, duree);
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
		double annuite = montantEmprunte*taux/(1- Math.pow(1+taux, (double)-duree));
		System.out.println("annuite" + annuite);
		return Math.abs(annuite - annuiteMaximal) < 10;
		// return (annuiteMaximal - ((montantEmprunte*taux)/(1- (Math.pow((1+taux), (double)-duree)))) < 0.01 
		//		&& annuiteMaximal - ((montantEmprunte*taux)/(1- (Math.pow((1+taux), (double)-duree))))*annuiteMaximal > -0.01);
	}
	
}