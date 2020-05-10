package interfaceAdministrateur;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import chedly.Gestion_Donnée;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FenetredAcceuil fen=new FenetredAcceuil();	
 // LogIn i=new LogIn ();       
	}
	
	public static void messageErreur (String message)
	{ JOptionPane d = new JOptionPane();
	  d.showMessageDialog( new JFrame() , message,
		        "Warning",JOptionPane.WARNING_MESSAGE);}
}

// la fenetre d'acceuil 
class FenetredAcceuil extends JFrame   
	{
	  private JTabbedPane tabbedPane = new JTabbedPane();
	  //les dimensions du bouton de fermeture des onglets
	  private Dimension closeButtonSize;
	  //un compteur pour le nombre des onglets a déja été ouverts et qui sont actuellemnt ouverts
 	  private int tabCounter = 0;
	  //les 3 boutons permanants de la fenetre principale
	  private JButton ajouter= new JButton("Ajouter");
	  private JButton importer = new JButton("Importer");
	  private JButton modifier = new JButton("Modifier");
	  
	public FenetredAcceuil() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setTitle("Interface Administrateur");
	   //Ajouter le traitement qui va etre fait suite à l'action de l'administrateur sur le bouton d'ajout principale 
		ajouter.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  ajouterOnglet("Ajouter des données");
		 
		      }
		 
		    });
		 //Ajouter le traitement qui va etre fait suite à l'action de l'administrateur sur le bouton de modification principale
		modifier.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  ajouterr("Modifier des données");
		 
		      }
		    });
		 //Ajouter le traitement qui va etre fait suite à l'action de l'administrateur sur le bouton d'importation principale
		importer.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e) {
       		{	JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());		 
	            // Récuperer l'un entier qui prend la valeur 1 si l'action est de fermer la fenetre du filechooser et 0 si l'admin a choisie un fichier
		   	int actionAdmin = chooser.showOpenDialog(null);
		    	if (actionAdmin == JFileChooser.APPROVE_OPTION) {
		    		//Imposer de choisir un fichier text uniquement en utilisant un filtre
		    		
			    		    System.out.println(actionAdmin);
			    			File selectedFile = chooser.getSelectedFile();
				    		
				    			String ch=selectedFile.getAbsolutePath();
				   		String	ch1=ch.replace("\\" ,"/" );
				   		String ch2 [] = ch1.split("/");
						String interm= ch2[ch2.length-1];
						String interm1 []= interm.split("\\.");
						String datech= interm1[0];
						if(!interm1[1].contentEquals("txt"))
							Principal.messageErreur("veuillez saisir un fichier text");
						else
						{if(LocalDate.parse(interm1[0]).isBefore(LocalDate.of(2020,03, 02)))
							Principal.messageErreur("Le fichier doit contenir des informations d'une date après le 02-03-2020");
						else
						{
				    	//appel à la methode de la classe gestion des donnees qui prend le chemin du fichier importé et fait l'ajout des donnees contenu dans ce fichier
				    	try
				    		{
				    			Gestion_Donnée.ajoutdonnéeschemin(ch1);}
			            catch(IOException evt)
				           {
			            	//System.out.println("erreur");
			            	evt.printStackTrace();
			            	}}
		    			}} }
		    	
		      
		 
		    		} });
	//ajouter et positionner les onglets au centre de la fenetre ,les boutons sur les bordures droite,gauche et bas de la fenetre 
		this.add(tabbedPane, BorderLayout.CENTER);
	   this.add(ajouter, BorderLayout.EAST);
	   this.add(modifier, BorderLayout.WEST);
	   this.add(importer, BorderLayout.SOUTH);
	   //Ajouter l'option de l'arret de l'exécution du programme 
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   //dimensionner la fenetre principale de l'administrateur
	   this.setSize(new Dimension(600, 600));
	   this.setVisible(true);
	}
	//Ajouter un onglet d'ajout de donnée
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
	  //LocalDate[] l=new LocalDate[19];                //pour tester il faut appeler la methode de gestion de donnee
		// int j=0;                                           //pour tester
		// for(int i=1;i<=12;i++)                           //pour tester
	//	 { l[j]=LocalDate.of(2020+i,i,i);j++;}
	  LocalDate[] TableauDesDates=new LocalDate[100];
	//  LocalDate[] TableauDesDates=Gestion_Donnée.datesdonnées();
	  try 
	  { TableauDesDates=Gestion_Donnée.datesdonnées();}
	  catch(IOException evt)
	  {System.out.println("exception");}
	  
	  final FenetreModifier contenuOnglet = new FenetreModifier(TableauDesDates);
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
{ 
	JButton bouton;
JComboBox GouvernoratSaisie;
TextField nombreDécésSaisie;
TextField nombreInféctéSaisie;
TextField nombreRetablisSaisie;
String nomGouvernorat;
int nombreDécés;
  int nombreInfécté;
int nombreRetablis;
public FenetreAjouter()
{String[] regions= {"Ariana","Beja","BenArous","Bizerte","Gabes","Gafsa","Jendouba",
		"Kairouan","Kasserine","Kebili","Kef","Mahdia","Manouba","Medenine",
		"Monastir","Nabeul","Sfax","SidiBouzid","Siliana","Tataouine","Sousse","Tozeur","Tunis","Zaghouan"};
      this.setBackground(new Color(231, 228, 220));
	bouton=new JButton("Valider");
	
	GouvernoratSaisie=new JComboBox(regions);
	nombreDécésSaisie=new TextField();
	nombreDécésSaisie.setPreferredSize(new Dimension(100,20));
	nombreInféctéSaisie=new TextField();
	nombreInféctéSaisie.setPreferredSize(new Dimension(100,20));
	nombreRetablisSaisie=new TextField();
	nombreRetablisSaisie.setPreferredSize(new Dimension(170,20));
	
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
	 
	 reglageBoutonAvecText(regions);
	
}
public void reglageBoutonAvecText(String[] regions)
{      bouton.addActionListener(new ActionListener()
           {public void actionPerformed(ActionEvent evt) {

          nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
           try
           {  nombreDécés=Integer.parseInt(nombreDécésSaisie.getText());
             nombreInfécté=Integer.parseInt(nombreInféctéSaisie.getText());
           nombreRetablis=Integer.parseInt(nombreRetablisSaisie.getText());
             DateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); // Format de la date
	          Date date = new Date(); // Date actuelle
	         String datech= format.format(date); // Date d'aujourd'hui en chaine de caractéres
		String[] ch=Gestion_Donnée.derniéreligne( nomGouvernorat).split(" ");
          if(!ch[0].equals(datech))
          { Gestion_Donnée.remplirfichier( nomGouvernorat ,nombreInfécté , nombreDécés ,  nombreRetablis);
            for(int i=0;i<24;i++)
          { if(regions[i]!=nomGouvernorat)
		 Gestion_Donnée.remplirfichier( regions[i] ,0 , 0 , 0);}}
         else
	       if((ch[1].equals("0"))&&(ch[2].equals("0"))&&(ch[3].equals("0")))
	         	Gestion_Donnée.modifierdonnées(LocalDate.parse(ch[0]), nombreInfécté, nombreRetablis,nombreDécés, nomGouvernorat);
	       else
		Principal.messageErreur ("les informations d'aujourd'hui reliés à cette région sont déjà ajoutés auparavant");

         }
           catch(NumberFormatException e)
          {Principal.messageErreur("Veuillez saisir que des chiffres");}

        catch(IOException e)
          {}

        }
//appel a la methode d'ajout de la classe gestion des donnees
});
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
	JComboBox jour;
	 JComboBox mois;
	 JComboBox annee;
	 public FenetreModifier(LocalDate[] obj ) {
		 this.setBackground(new Color(226, 227, 220));
		 String[] regions= {"Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili",
					"Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana"
					,"Sousse","Tataouine","Tozeur","Tunis","Zagouan"};
				bouton=new JButton("Valider");
				GouvernoratSaisie=new JComboBox(regions);
				nombreDécésSaisie=new TextField();
				nombreDécésSaisie.setPreferredSize(new Dimension(100,20));
				nombreInféctéSaisie=new TextField();
				nombreInféctéSaisie.setPreferredSize(new Dimension(100,20));
				nombreRetablisSaisie=new TextField();
				nombreRetablisSaisie.setPreferredSize(new Dimension(100,20));
				
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
	
	 
public void reglage(LocalDate[] obj) 
{
	bouton.addActionListener(new ActionListener()
	 {public void actionPerformed(ActionEvent evt) {
	//if((nombreDécésSaisie.getText()!=null)&&(nombreInféctéSaisie.getText()!=null) &&(nombreRetablisSaisie.getText()!=null))
	{ nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
	try
	{  nombreDécés=Integer.parseInt(nombreDécésSaisie.getText());
	 nombreInfécté=Integer.parseInt(nombreInféctéSaisie.getText());
	 nombreRetablis=Integer.parseInt(nombreRetablisSaisie.getText());}
	catch(NumberFormatException e)
	 {Principal.messageErreur("Veuillez saisir que des chiffres");}
	 }
	 nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
	 int j=Integer.parseInt(jour.getSelectedItem().toString());
	 int m =Integer.parseInt(mois.getSelectedItem().toString());
	 int a=Integer.parseInt(annee.getSelectedItem().toString());	
	 if (estAvant(j,m,a,obj[0]))
	 {	  String x=obj[0].toString();
	       Principal.messageErreur("Date erronée! \n  veuiller choisir une date après la date du début de la pandémie suivante :"+x);
	  }
	  else
	  { if (estApres(j,m,a,obj[indice(obj)]))
	  {	  String x=obj[indice(obj)].toString();
	  Principal.messageErreur("Date erronée! \n  veuiller choisir une date avant la derniére date enregistrée suivante:"+x);
	  }
	  else
	  {  if (!estPresent(obj, LocalDate.of(a,m,j) ))
		     Principal.messageErreur("Date introuvable");
			 
		  else 
		  { LocalDate date=LocalDate.of(a,m,j);
	       try
	       { Gestion_Donnée.modifierdonnées ( date , nombreInfécté , nombreDécés ,  nombreRetablis , nomGouvernorat);}
	       catch(IOException evt2)
	       {System.out.print("exception1");}}}
	  }}
	//else
		//throw new MyException();//; ex.messageErreur();}
	
	 });}

		

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

 