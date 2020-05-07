package gouvernorat;

import java.awt.Color;
import java.time.LocalDate;


import javax.swing.JPanel;
import javax.swing.JTable;

public class conteneur_fenetre_gouvernorat extends JPanel{
	
	
	private JTable tab ;
	
	
	public conteneur_fenetre_gouvernorat(String nom) //constructeur du conteneur � la date actuelle
	{
		super();
		
	
		
		this.setBackground(new Color(25,0,51));
		String[] col_name= {"nombre total de cas confirm�s","nombre total de cas gu�ris","nombre total des d�c�s"};
		Object[][] row= { {" cas confirm�s"," cas gu�ris","  d�c�s"},Gestion_Donn�e.lecturedonn�es(nom)};
		tab=new JTable(row,col_name);
		this.add(tab);
		
		
		
		
		
	};
	
	public conteneur_fenetre_gouvernorat(String nom , LocalDate d) //constructeur du conteneur � la date d
	{
		super();
		
		this.setBackground(new Color(25,0,51));
		String[] col_name= {"nombre total de cas confirm�s","nombre total de cas gu�ris","nombre total des d�c�s"};
		Object[][] row= { {" cas confirm�s"," cas gu�ris","  d�c�s"},Gestion_Donn�e.lecturedonn�es(nom,d)};
		tab=new JTable(row,col_name);
		this.add(tab);
	};
}
