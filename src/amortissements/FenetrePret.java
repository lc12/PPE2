package amortissements;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FenetrePret extends JFrame{

	Object[][] tabGraph;
	private JPanel container = new JPanel(new BorderLayout());
	public FenetrePret(TableauAmortissement unTab)
	{
		tabGraph= new Object[unTab.getNbLignes()][6];
		JButton boutonHelp = new JButton("Help");
		this.setTitle("Pret");
		this.setLocationRelativeTo(null);
		
		String[] entetes = {"Année", "Capital Initial", "Interet", "Amortissement", "Anuité", "Capital Final"};
		
		for (int i = 0; i < unTab.getNbLignes(); i++) {
			for (int j = 0; j < 6; j++) {
				switch (j) {
				case 0:
					tabGraph[i][j] = unTab.getLigne(i).getAnnee();
					break;
				case 1:
					tabGraph[i][j] = Math.round(unTab.getLigne(i).getCapitalInitial());
					break;
				case 2:
					tabGraph[i][j] = Math.round(unTab.getLigne(i).getInterets());
					break;
				case 3:
					tabGraph[i][j] = Math.round(unTab.getLigne(i).getAmortissements());
					break;
				case 4:
					tabGraph[i][j] = Math.round(unTab.getLigne(i).getAnnuite());
					break;
				case 5:
					tabGraph[i][j] = Math.round(unTab.getLigne(i).getCapitalFinal());
					break;
				default:
					break;
				}
				
			}
		}
		
		JTable tableau = new JTable(tabGraph, entetes);
		tableau.setEnabled(false);
		this.setSize(600,(int)(tableau.getRowHeight()*tableau.getRowCount()+48));
		this.setResizable(false);
		container.add(tableau.getTableHeader(), BorderLayout.NORTH);
        container.add(tableau, BorderLayout.CENTER);
        this.setContentPane(container);
		this.setVisible(true);
	}
}
