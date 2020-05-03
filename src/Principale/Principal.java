package Principale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
//import java.util.Arrays;
///import java.util.Vector;
import java.util.*;
public class Principal {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	// Fenetre fen=new Fenetre();
      LogIn i=new LogIn ();
       
	}

}
class Fenetre extends JFrame   
	{
	  private JTabbedPane tabbedPane = new JTabbedPane();
	  private Dimension closeButtonSize;
	  private int tabCounter = 0;
	  private JButton ajouter= new JButton("Ajouter");
	  private JButton importer = new JButton("Importer");
	  private JButton modifier = new JButton("Modifier");
	public  Fenetre() {
		super();
	
		ajouter.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  ajouterOnglet("Ajouter des données");
		 
		      }
		 
		    });
		modifier.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  ajouterr("Modifier des données");
		 
		      }
		 
		    });
		
		this.add(tabbedPane, BorderLayout.CENTER);
	   this.add(ajouter, BorderLayout.EAST);
	   this.add(modifier, BorderLayout.WEST);
	   this.add(importer, BorderLayout.SOUTH);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setSize(new Dimension(600, 600));
	   this.setVisible(true);
	}
	public void ajouterOnglet(String nomOnglet) {
		    final FenetreAjouter contenuOnglet = new FenetreAjouter();
		   JPanel Onglet = new JPanel();
		   Onglet.setOpaque(false);
		    JLabel labelOnglet = new JLabel( nomOnglet);
		    JButton boutonFermer = new JButton("x");
		    boutonFermer.setPreferredSize(closeButtonSize);
		    boutonFermer.addActionListener(new ActionListener() {
		 
      public void actionPerformed(ActionEvent e) {
		        int numeroOnglet = tabbedPane.indexOfComponent(contenuOnglet);
		        tabbedPane.remove(numeroOnglet);
		        
		      }
		    });
		 
		    Onglet.add(labelOnglet, BorderLayout.WEST);
		    Onglet.add(boutonFermer, BorderLayout.EAST);
		 
		    tabbedPane.addTab(null, contenuOnglet);
		    tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, Onglet);
		    FenetreAjouter n=new FenetreAjouter();
			  
		  }

  public void ajouterr(String nomOnglet) {
	  LocalDate[] l=new LocalDate[19];                //pour tester il faut appeler la methode de gestion de donnee
		 int j=0;                                           //pour tester
		 for(int i=1;i<=12;i++)                           //pour tester
		 { l[j]=LocalDate.of(2020+i,i,i);j++;}
	  final FenetreModifier contenuOnglet = new FenetreModifier(l);
		   JPanel Onglet = new JPanel();
		   Onglet.setOpaque(false);
		    JLabel labelOnglet = new JLabel( nomOnglet);
		    JButton boutonFermer = new JButton("x");
		    boutonFermer.setPreferredSize(closeButtonSize);
		    boutonFermer.addActionListener(new ActionListener() {
		 
    public void actionPerformed(ActionEvent e) {
		        int numeroOnglet = tabbedPane.indexOfComponent(contenuOnglet);
		        tabbedPane.remove(numeroOnglet);
		        
		      }
		    });
		 
		    Onglet.add(labelOnglet, BorderLayout.WEST);
		    Onglet.add(boutonFermer, BorderLayout.EAST);
		 
		    tabbedPane.addTab(null, contenuOnglet);
		    tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, Onglet);
		    
}}
class FenetreAjouter extends JPanel 
{JButton bouton;
JComboBox GouvernoratSaisie;
TextField nombreDécésSaisie;
TextField nombreInféctéSaisie;
TextField nombreRetablisSaisie;
String nomGouvernorat;
int nombreDécés;
int nombreInfécté;
int nombreRetablis;
public FenetreAjouter()
{String[] regions= {"Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili",
		"Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana"
		,"Sousse","Tataouine","Tozeur","Tunis","Zagouan"};
	bouton=new JButton("Valider");
	GouvernoratSaisie=new JComboBox(regions);
	nombreDécésSaisie=new TextField();
	nombreInféctéSaisie=new TextField();
	nombreRetablisSaisie=new TextField();
	
	JLabel etiquette1=new JLabel("donner le nom du gouvernorat     ");
	this.add(etiquette1);
	 this.add(GouvernoratSaisie);
	 JLabel etiquette2=new JLabel("donner le nombre du décés     ");
	 this.add(etiquette2);
	 this.add(nombreDécésSaisie);
	 JLabel etiquette3=new JLabel("donner le nombre des inféctés");
	 this.add(etiquette3);
	 this.add(nombreInféctéSaisie);
	 JLabel etiquette4=new JLabel("donner le nombre des Rétablis");
	 this.add(etiquette4);
	 this.add(nombreRetablisSaisie);
	 this.add(bouton);
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
	  
	  //appel a la methode d'ajout de la classe gestion des donnees
	}

	

}
class FenetreModifier extends JPanel{
	JButton bouton;
	JComboBox GouvernoratSaisie;
	TextField nombreDécésSaisie;
	TextField nombreInféctéSaisie;
	TextField nombreRetablisSaisie;
	String nomGouvernorat;
	int nombreDécés;
	int nombreInfécté;
	int nombreRetablis;
	//JComboBox datesPossibles;
	JComboBox jour;
	 JComboBox mois;
	 JComboBox annee;
	 public FenetreModifier(LocalDate[] obj ) {
		 String[] regions= {"Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili",
					"Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana"
					,"Sousse","Tataouine","Tozeur","Tunis","Zagouan"};
				bouton=new JButton("Valider");
				GouvernoratSaisie=new JComboBox(regions);
				nombreDécésSaisie=new TextField();
				nombreInféctéSaisie=new TextField();
				nombreRetablisSaisie=new TextField();
				
				JLabel etiquette1=new JLabel("donnez le nom du gouvernorat     ");
				this.add(etiquette1);
				 this.add(GouvernoratSaisie);
				 JLabel etiquette2=new JLabel("donnez le nombre du décés     ");
				 this.add(etiquette2);
				 this.add(nombreDécésSaisie);
				 JLabel etiquette3=new JLabel("donnez le nombre des inféctés");
				 this.add(etiquette3);
				 this.add(nombreInféctéSaisie);
				 JLabel etiquette4=new JLabel("donnez le nombre des Rétablis");
				 this.add(etiquette4);
				 this.add(nombreRetablisSaisie);
				 
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
	JLabel etiquette5=new JLabel("donnez la date de modification");
	 this.add(etiquette5);
	 this.add(jour);
	 this.add(mois);
	 this.add(annee);
	 this.add(bouton);
	 reglage(obj);
		 
		 
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
	  d.showMessageDialog( new JFrame() , "Date erronée! \n  veuiller choisir une date après:"+x,
	        "Warning",JOptionPane.WARNING_MESSAGE);}
	  else
	  { if (estApres(j,m,a,obj[indice(obj)]))
	  {	  String x=obj[indice(obj)].toString();
	  JOptionPane d = new JOptionPane();
	  d.showMessageDialog( new JFrame() , "Date erronée! \n  veuiller choisir une date avant:"+x,
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




