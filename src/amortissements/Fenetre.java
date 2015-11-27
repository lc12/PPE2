package amortissements;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	private boolean f1,f2,f3,f4 = false;
	private JPanel container = new JPanel(new GridBagLayout());
	private JCheckBox check1 = new JCheckBox("Annuité Constante");
	private JCheckBox check2 = new JCheckBox("Amortissement Constant");
	private JButton bouton = new JButton("Creer Tableau");
	private JTextField textF1 = new JTextField(10);
	private JLabel lab1 = new JLabel("Montant :");
	private JTextField textF2 = new JTextField(10);
	private JLabel lab2 = new JLabel("Taux :");
	private JTextField textF3 = new JTextField(10);
	private JLabel lab3 = new JLabel("AnuiteMax :");
	private JTextField textF4 = new JTextField(10);
	private JLabel lab4 = new JLabel("Durée :");
	private JLabel help = new JLabel("?");
	
	public Fenetre(){
		Dimension dim = new Dimension(5,5);
		help.setMaximumSize(dim);
		bouton.setEnabled(false);
		help.setForeground(new Color(27, 30 , 130));
		help.addMouseListener(new MouseListenerLabel());
		this.setTitle("Amortissement");
		this.setSize(450,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.weightx = c1.weighty = 1.00;
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 3;
		container.add(check1, c1);
		c1.gridx += 3;
		container.add(check2, c1);
		c1.gridx = 0;
		c1.gridy = 1;
		c1.gridwidth = 1;
		container.add(lab1, c1);
		c1.gridx += 1;
		c1.gridwidth = 2;
		container.add(textF1, c1);
		c1.gridx += 2;
		c1.gridwidth = 1;
		container.add(lab2, c1);
		c1.gridx += 1;
		c1.gridwidth = 2;
		container.add(textF2, c1);
		c1.gridy = 2;
		c1.gridx = 0;
		c1.gridwidth = 1;
		container.add(lab3, c1);
		c1.gridx += 1;
		c1.gridwidth = 2;
		container.add(textF3, c1);
		c1.gridx += 2;
		c1.gridwidth = 1;
		container.add(lab4, c1);
		c1.gridx += 1;
		c1.gridwidth = 2;
		container.add(textF4, c1);
		c1.gridx = 2;
		c1.gridwidth = 3;
		c1.gridy = 3;
		container.add(bouton, c1);
		c1.gridwidth = 1;
		c1.gridx = 5;
		container.add(help, c1);
		check1.addActionListener(new CheckBoxListener());
		check2.addActionListener(new CheckBoxListener());
		textF1.addActionListener(new TextFieldListener());
		textF1.getDocument().addDocumentListener(new TextDocListener());
		textF2.addActionListener(new TextFieldListener());
		textF2.getDocument().addDocumentListener(new TextDocListener());
		textF3.addActionListener(new TextFieldListener());
		textF3.getDocument().addDocumentListener(new TextDocListener());
		textF4.addActionListener(new TextFieldListener());
		textF4.getDocument().addDocumentListener(new TextDocListener());
		bouton.addActionListener(new ButtonListener());
		this.setContentPane(container);
		this.setVisible(true);        
	} 
	
	public boolean justNumber(String s) 
	{
	    boolean ret = false ;
	    try{
	           Double i = Double.parseDouble(s);
	           ret = true ;     //tout c'est bien passé
	     }
	    catch( Exception e )
	    { ret = false ; }      //tiens une erreur 
	     return ret ;
	}
	
	class MouseListenerLabel implements MouseListener
	{
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			try {
				//Desktop.getDesktop().open(new File("C:/Users/Maxime/git/PPE2/src/amortissements/NoticeUtilisateur.pdf"));
				Desktop.getDesktop().open(new File("NoticeUtilisateur.pdf"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class TextDocListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			
			if (!textF1.getText().isEmpty())
				f1 = true;
			if (!textF2.getText().isEmpty())
				f2 = true;
			if (!textF3.getText().isEmpty())
				f3 = true;
			if (!textF4.getText().isEmpty())
				f4 = true;

			checkerLesCases();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {

			if (textF1.getText().isEmpty())
				f1 = false;
			if (textF2.getText().isEmpty())
				f2 = false;
			if (textF3.getText().isEmpty())
				f3 = false;
			if (textF4.getText().isEmpty())
				f4 = false;
			
			checkerLesCases();
		}
		
		
		
	}
	
	public void checkerLesCases()
	{
		boolean nok = (!(f1 && f2 && f3) && !(f2 && f3 && f4) && !(f3 && f4 && f1) && !(f4 && f1 && f2));
		if (nok)
		{
			textF1.setEnabled(true);
			textF2.setEnabled(true);
			textF3.setEnabled(true);
			textF4.setEnabled(true);
		}

		if (f1 && f2 && f3)
			textF4.setEnabled(false);
		else if (f2 && f3 && f4)
			textF1.setEnabled(false);
		else if (f3 && f4 && f1)
			textF2.setEnabled(false);
		else if (f4 && f1 && f2)
			textF3.setEnabled(false);
		
		if (!nok && (check1.isSelected() || check2.isSelected()) 
				&& (!f1 || justNumber(textF1.getText()))
				&& (!f2 || justNumber(textF2.getText())) 
				&& (!f3 || justNumber(textF3.getText()))
				&& (!f4 || justNumber(textF4.getText())))
			bouton.setEnabled(true);
		else
			bouton.setEnabled(false);
	}
	
	class CheckBoxListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (((JCheckBox)e.getSource()).isSelected())
			{
				if (((JCheckBox)e.getSource()).equals(check1))
				{
					check2.setSelected(false);
				}
				else
				{
					check1.setSelected(false);
				}
			}
			checkerLesCases();
		}
	}
	
	class TextFieldListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (((JTextField)e.getSource()).getText() != "")
			{
				System.out.println(((JTextField)e.getSource()).getText());
			}
		}
	}
	
	class ButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Credit unCredit = null;
			if (f1 && f2 && f3)
				unCredit = Credit.calculeDuree(check1.isSelected() ? 2 : 1, Double.parseDouble(textF1.getText()), Double.parseDouble(textF3.getText()), Double.parseDouble(textF2.getText()));
			else if (f2 && f3 && f4)
				unCredit = Credit.calculeMontantEmprunte(check1.isSelected() ? 2 : 1, Double.parseDouble(textF3.getText()), Double.parseDouble(textF2.getText()), Integer.parseInt(textF4.getText()));
			else if (f3 && f4 && f1)
				unCredit = Credit.calculeTaux(check1.isSelected() ? 2 : 1, Double.parseDouble(textF1.getText()), Double.parseDouble(textF3.getText()), Integer.parseInt(textF4.getText()));
			else if (f4 && f1 && f2)
				unCredit = Credit.calculeAnuiteMaximale(check1.isSelected() ? 2 : 1, Double.parseDouble(textF1.getText()), Double.parseDouble(textF2.getText()), Integer.parseInt(textF4.getText()));
			
			TableauAmortissement unTableau = new TableauAmortissement(unCredit);
			String info = new String(" Le credit est d'un montant de : " + Math.round(unCredit.montantEmprunt)
					+ " un taux de : " + (double)Math.round(unCredit.taux*10)/10 +"%. "
					+ "Le total des interets s'élève à : " + calcTotInterets(unTableau) +".");
			FenetrePret uneFen = new FenetrePret(unTableau, info);
		}
		
		private String calcTotInterets(TableauAmortissement unTab)
		{
			int tot = 0;
			for (Ligne laLigne : unTab.tabAmor) {
				tot += laLigne.interets;
			}
			return Integer.toString(tot);
		}
	}
}