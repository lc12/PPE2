package amortissements;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenetre extends JFrame{
	private Panneau pan = new Panneau();
	private JButton button = new JButton("Mon premier bouton");
	
	Fenetre(){
		this.setSize(500, 500);
		this.setTitle("Ma Fenetre Test");
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	    this.setVisible(true);
	    pan.add(button);
	    this.setContentPane(pan);
	}
}