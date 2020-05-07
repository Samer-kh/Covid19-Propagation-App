package gouvernorat;

import java.awt.Color;
import java.time.LocalDate;


import javax.swing.JPanel;
import javax.swing.JTable;

public class conteneur_fenetre_gouvernorat extends JPanel{
	
	
	private JTable tab ;
	
	
	public conteneur_fenetre_gouvernorat(String nom) //constructeur du conteneur à la date actuelle
	{
		super();
		
	
		
		this.setBackground(new Color(25,0,51));
		String[] col_name= {"nombre total de cas confirmés","nombre total de cas guéris","nombre total des décès"};
		Object[][] row= { {" cas confirmés"," cas guéris","  décès"},Gestion_Donnée.lecturedonnées(nom)};
		tab=new JTable(row,col_name);
		this.add(tab);
		
		
		
		
		
	};
	
	public conteneur_fenetre_gouvernorat(String nom , LocalDate d) //constructeur du conteneur à la date d
	{
		super();
		
		this.setBackground(new Color(25,0,51));
		String[] col_name= {"nombre total de cas confirmés","nombre total de cas guéris","nombre total des décès"};
		Object[][] row= { {" cas confirmés"," cas guéris","  décès"},Gestion_Donnée.lecturedonnées(nom,d)};
		tab=new JTable(row,col_name);
		this.add(tab);
	};
}
