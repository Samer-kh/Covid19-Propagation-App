package Principale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Date;

public class ConteneurFenetre extends JPanel  { 
	public  File f = new File("test.txt");
	public ConteneurFenetre()
		{ super(); }
	public void ajouterBoutton(JButton bouton)
	{    
			//JButton bouton= new JButton(nomBouton);
		//	bouton.setSize(50, 30);
		//	bouton.setBounds(30, 50, 90, 20);
		   // bouton.addActionListener(this );
		    this.add(bouton);	
		
	}
	public void ajouterChampsText()
	{
		JTextField text=new JTextField();
		text.setBounds(130,50,100,20);
	
		this.add(text);
	}
	public void ajouterTitre(String TitreDuChamps)
	{
		JLabel etiquette=new JLabel(TitreDuChamps);
		this.add(etiquette);
	}
	public void ajouterBoutonAvecText()
	{  
		 BoutonAvecText champs=new  BoutonAvecText ();
		 ajouterTitre("donner le nom du gouvernorat");
		 this.add(champs.GouvernoratSaisie);
		 ajouterTitre("donner le nombre du décés");
		 this.add(champs.nombreDécésSaisie);
		 ajouterTitre("donner le nombre des inféctés");
		 this.add(champs.nombreInféctéSaisie);
		 ajouterTitre("donner le nombre des Rétablis");
		 this.add(champs.nombreRetablisSaisie);
		 this.add(champs.bouton);
		 champs.reglageBoutonAvecText();
		
		 
	}
	public void ajouterBoutonAvecTextàuneDate(String[][] obj)
	{  JComboBox jour;
	 JComboBox mois;
	 JComboBox annee;
		 BoutonAvecText champs=new  BoutonAvecText ();
		 ajouterTitre("donner le nom du gouvernorat");
		 this.add(champs.GouvernoratSaisie);
		 ajouterTitre("donner le nombre du décés");
		 this.add(champs.nombreDécésSaisie);
		 ajouterTitre("donner le nombre des inféctés");
		 this.add(champs.nombreInféctéSaisie);
		 ajouterTitre("donner le nombre des Rétablis");
		 this.add(champs.nombreRetablisSaisie);
		 this.add(champs.bouton);
		 champs.reglageBoutonAvecText();
		
		 
	}
}
//utiliser s'il y a ajout
class BoutonAvecText  {
 JButton bouton;
 JComboBox GouvernoratSaisie;
 TextField nombreDécésSaisie;
 TextField nombreInféctéSaisie;
 TextField nombreRetablisSaisie;
 String nomGouvernorat;
 int nombreDécés;
 int nombreInfécté;
 int nombreRetablis;
 JComboBox datesPossibles;

public BoutonAvecText()
{String[] regions= {"Tunis","Monastir","Sousse","Mahdia","Nabeul"};
	bouton=new JButton("Valider");
	GouvernoratSaisie=new JComboBox(regions);
	nombreDécésSaisie=new TextField();
	nombreInféctéSaisie=new TextField();
	nombreRetablisSaisie=new TextField();
	reglageBoutonAvecText();
}
public void reglageBoutonAvecText()//throws MyException
{      
	  bouton.addActionListener(new ActionListener()
		 {public void actionPerformed(ActionEvent evt) {
		
		 nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
		  nombreDécés=Integer.parseInt(nombreDécésSaisie.getText());
		 nombreInfécté=Integer.parseInt(nombreInféctéSaisie.getText());
		 nombreRetablis=Integer.parseInt(nombreRetablisSaisie.getText());
		// System.out.println(nomGouvernorat+" "+nombreDécés);
		 }
		 
		 });
	  
	}
public String toString(Object obj ) {
	String ch=obj.toString();
	return ch+"hello";
	
}
public void ajouterZoneDate(Date[] table)
{
	JComboBox datesPossibles=new JComboBox(table);
		
}


}
class MyException extends Exception{}

class Modification extends BoutonAvecText{
	JComboBox jour;
	 JComboBox mois;
	 JComboBox annee;
	 public Modification(String[][] obj ) {
		 String[] regions= {"Tunis","Monastir","Sousse","Mahdia","Nabeul"};
		bouton=new JButton("Valider");
		GouvernoratSaisie=new JComboBox(regions);
		nombreDécésSaisie=new TextField();
		nombreInféctéSaisie=new TextField();
		nombreRetablisSaisie=new TextField();
	 }
public void reglageBoutonAvecText() {
	
}
public String[][] dateSéparé (String[][] obj)
{ String [] jour;
 	}
	 
}
//public void textValueChanged(TextEvent txt) {
//      Object source = txt.getSource();
//    TextField  x=(TextField)source;
//    String t=text.getText();
//text.addActionListener(this);

//nomGouvernorat=GouvernoratSaisie.getText();
		// if (ch!="")
			// nomGouvernorat=ch;
	//	 else 
		//	 throw new MyException();
  