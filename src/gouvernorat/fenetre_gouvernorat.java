package gouvernorat;


import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fenetre_gouvernorat extends JFrame {
	public static void main(String[] args)
	{
		fenetre_gouvernorat f=new fenetre_gouvernorat("samer");
	}
		public conteneur_fenetre_gouvernorat conteneur;
		
		public fenetre_gouvernorat(String nom)
		{
			super();
			this.setTitle(nom);
			Container c=this.getContentPane();
			
			conteneur=new conteneur_fenetre_gouvernorat(nom);
			c.add(conteneur);
			
			this.setSize(300, 300);
			this.setResizable(false);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
		
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
			
		}
		
}
