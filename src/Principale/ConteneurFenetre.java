package Principale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
//import java.util.Date;
//import java.util.Vector;
import java.time.LocalDate;
import java.util.*;
public class ConteneurFenetre extends JPanel  { 
	public  File f = new File("test.txt");
	public ConteneurFenetre()
		{ super(); }
	   // this.setLayout(new GridLayout(3,3));}
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
/*	public void ajouterBoutonAvecTextàuneDate(String[][] obj)
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
		
		 
	}*/
	public void modifier() {
		 LocalDate[] l=new LocalDate[19];                //pour tester
		 int j=0;                                           //pour tester
		 for(int i=1;i<=12;i++)                           //pour tester
		 { l[j]=LocalDate.of(2020+i,i,i);j++;}           //pour tester
		Modification champs=new Modification(l);        // il faut appeller le fonction de gestion de donnée qui renvoie une tab des dates disponibles
		 ajouterTitre("donner le nom du gouvernorat");
		 this.add(champs.GouvernoratSaisie);
		 ajouterTitre("donner le nombre du décés");
		 this.add(champs.nombreDécésSaisie);
		 ajouterTitre("donner le nombre des inféctés");
		 this.add(champs.nombreInféctéSaisie);
		 ajouterTitre("donner le nombre des Rétablis");
		 this.add(champs.nombreRetablisSaisie);
		 this.add(champs.bouton);
		 this.add(champs.jour);
		 this.add(champs.mois);
		 this.add(champs.annee);
		 champs.reglage(l);

	}
}
//cs sont 3 textField commander par un boutton //il faut faire l'appel à la methode 
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
{String[] regions= {"Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili",
		"Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana"
		,"Sousse","Tataouine","Tozeur","Tunis","Zagouan"};
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
		
		 }
		 
		 });
	  
	}

}
class Modification extends BoutonAvecText{
	JComboBox jour;
	 JComboBox mois;
	 JComboBox annee;
	 public Modification(LocalDate[] obj ) {
	 String[] regions= {"Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili",
					"Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana"
					,"Sousse","Tataouine","Tozeur","Tunis","Zagouan"};
	bouton=new JButton("Valider");
	GouvernoratSaisie=new JComboBox(regions);
	nombreDécésSaisie=new TextField();
	nombreInféctéSaisie=new TextField();
	nombreRetablisSaisie=new TextField();
	 int anneeActuelle=obj[indice(obj)].getYear();
	 Vector vecteur=new Vector();
	 for(int j=2020;j<=anneeActuelle;j++)
     	 vecteur.add(j);
	 annee=new JComboBox(vecteur);
	 Vector vecteur1=new Vector();
	 for(int i=1;i<=12;i++)
		vecteur1.add(i) ;
	 mois=new JComboBox(vecteur1);
	 Vector vecteur2=new Vector();
	 for(int i=1;i<=31;i++)
			 vecteur2.add(i) ;
	jour=new JComboBox(vecteur2);
		 
		 
	 }
	
	 
public void reglage(LocalDate[] obj) {
	bouton.addActionListener(new ActionListener()
	 {public void actionPerformed(ActionEvent evt) {
	
	 nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
	  nombreDécés=Integer.parseInt(nombreDécésSaisie.getText());
	 nombreInfécté=Integer.parseInt(nombreInféctéSaisie.getText());
	 nombreRetablis=Integer.parseInt(nombreRetablisSaisie.getText());
	 nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
	 int j=Integer.parseInt(jour.getSelectedItem().toString());
	 int m =Integer.parseInt(mois.getSelectedItem().toString());
	 int a=Integer.parseInt(annee.getSelectedItem().toString());	
	 if (estAvant(j,m,a,obj[0]))
	 {	  String x=obj[0].toString();
	  JOptionPane d = new JOptionPane();
	  d.showMessageDialog( new JFrame() , "Date erronée! \n veuiller choisir une date après:"+x,
	        "Warning",JOptionPane.WARNING_MESSAGE);}
	  else
	  { if (estApres(j,m,a,obj[indice(obj)]))
	  {	  String x=obj[indice(obj)].toString();
	  JOptionPane d = new JOptionPane();
	  d.showMessageDialog( new JFrame() , "Date erronée! \n veuiller choisir une date avant:"+x,
	        "Warning",JOptionPane.WARNING_MESSAGE);}
	  else
		  if (!estPresent(obj, LocalDate.of(a,m,j) ))
		  {  JOptionPane d = new JOptionPane();
	  d.showMessageDialog( new JFrame() , "Date introuvable",
	        "Warning",JOptionPane.WARNING_MESSAGE);}
	//	  else 
		//	 donneesSaisies  // dans le else il faut appeller le methode qui enregistre les données de la classe gestionDonnée
	  }}});}
//methode qui retourne la derniere date (la valeur non null d'un tableau
public int indice(LocalDate[] obj) {
	int i;
	 for (i=obj.length-1;i>=0;i--)
	 { if(obj[i]!=null)
	 {break;}
	 }return i;
	 }
// methode qui vérifier si une date est présente dans un tableau ou nn
public static boolean estPresent(LocalDate[] obj,LocalDate element)
{ boolean ch=Arrays.asList(obj).contains(element);
	/*for (int i=0;i<obj.length;i++)
	   {if(!obj[i].equals(null))
	      {if  (obj[i].toString().equals(element.toString()))
		     {ch=true;break ;
             }
	      }

       }*/
	return ch;}
public static boolean estAvant(int j,int m,int a,LocalDate obj)  
{ boolean test=false;
	if(LocalDate.of(a,m,j).isBefore(obj))
	test=true;
	return test;
	}
public static boolean estApres(int j,int m,int a,LocalDate obj)  
{ boolean test=false;
	if(LocalDate.of(a,m,j).isAfter(obj))
	test=true;
	return test;
	}}


  