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
		
		//FenetredAcceuil fen=new FenetredAcceuil();	
  LogIn i=new LogIn ();       
	}
	
	public static void messageErreur (String message)
	{ JOptionPane d = new JOptionPane();
	  d.showMessageDialog( new JFrame() , message,
		        "Warning",JOptionPane.WARNING_MESSAGE);}
}

// la fenetre principale d'acceuil 
class FenetredAcceuil extends JFrame   
	{ //le conteneur des onglets :l'ensemble des onglets
	  private JTabbedPane tabbedPane = new JTabbedPane();
	  //les dimensions du bouton de fermeture des onglets
	  private Dimension closeButtonSize;
	  //un compteur pour le nombre des onglets a déja été ouverts et qui sont actuellemnt ouverts
 	//  private int tabCounter = 0;
	  //création des 3 boutons permanants de la fenetre D'acceuil
	  private JButton ajouter= new JButton("Ajouter");
	  private JButton importer = new JButton("Importer");
	  private JButton modifier = new JButton("Modifier");
	  
	public FenetredAcceuil() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//le titre de la fenetre d'acceuil
	   this.setTitle("Interface Administrateur");
	   //Ajouter le traitement qui va etre fait suite à l'action de l'administrateur sur le bouton d'ajout:l'ajout d'un onglet et ses composants  
		ajouter.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  OngletAjouter("Ajouter des données");
		 
		      }
		 
		    });
		 //Ajouter le traitement qui va etre fait suite à l'action de l'administrateur sur le bouton de modification 
		modifier.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  ongletdeModification("Modifier des données");
		 
		      }
		    });
		 //Ajouter le traitement qui va etre fait suite à l'action de l'administrateur sur le bouton d'importation principale
		importer.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e) {
       		{	//Creation d'un JFile chooser avec Home comme répertoire de recherche par défaut
       			JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());		 
	         /* Récuperer l'entier qui prend la valeur 1 si l'action est de fermer la fenetre du filechooser
	        *  et 0 si l'admin a choisie un fichier et permet d'imposer que le JFilechooser support que l'opération d'ouverture d'un fichier*/	            
		   	int actionAdmin = chooser.showOpenDialog(null);
		   	if (actionAdmin == JFileChooser.APPROVE_OPTION) {
		   		           //récupérer le fichier choisi par l'admin
			    			File fichierChoisi = chooser.getSelectedFile();	
			    			//extraire le chemin de ce fichier
				    		String ch=fichierChoisi.getAbsolutePath();
				    		//extraire le nom du fichier du path(le nom du fichier est sous la forme :aaaa-mm-jj)
				   		String	ch1=ch.replace("\\" ,"/" );
				   		String ch2 [] = ch1.split("/");
						String fichier= ch2[ch2.length-1];						
						String interm []= fichier.split("\\.");
						String nomFichier= interm[0];
						if(!interm[1].equals("txt"))
							Principal.messageErreur("veuillez saisir un fichier text");
						else
						{if(LocalDate.parse(nomFichier).isBefore(LocalDate.of(2020,03, 02)))
							Principal.messageErreur("Le fichier doit contenir des informations d'une date après le 02-03-2020");
						else
						{
				    	/*appel à la methode de la classe gestion des donnees qui prend le chemin du fichier importé et fait
							l'ajout des donnees contenu dans ce fichier aux différentes fichiers des gouvernorats*/
				    	try
				    		{
				    		Gestion_Donnée.ajoutdonnéeschemin(ch1);
				    		}
			            catch(IOException evt)
				           {			            
			            	evt.printStackTrace();
			            	}}
		    			}} }} });
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
	
	//Créer l'onglet d'ajout de donnée et ses composantes
	public void OngletAjouter(String nomOnglet) {
		  //un composant majoritaire de l'onglet d'ajout:le contenu de cet onglet
		   final FenetreAjouter contenuOnglet = new FenetreAjouter();		
		   //le panel principale de l'onglet
		   JPanel Onglet = new JPanel();	
		   Onglet.setOpaque(false);
		   //le titre de l'onglet
		    JLabel labelOnglet = new JLabel( nomOnglet);
		    //le bouton de fermeture de l'onglet
		    JButton boutonFermer = new JButton("x");
		    boutonFermer.setPreferredSize(closeButtonSize);
		    boutonFermer.addActionListener(new ActionListener() {		    	
		   public void actionPerformed(ActionEvent e) {
			   //numéro onglet à supprimer
		        int numeroOnglet = tabbedPane.indexOfComponent(contenuOnglet);
		        //supprimer l'onglet numéro :numeroOnglet
		        tabbedPane.remove(numeroOnglet);}
		    });
		    //ajouter le titre de l'onglet et le bouton de fermeture
		    Onglet.add(labelOnglet, BorderLayout.WEST);
		    Onglet.add(boutonFermer, BorderLayout.EAST);
		    //ajouter le composant majoritaire 
		    tabbedPane.addTab(null, contenuOnglet);
		    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()- 1, Onglet);
		 //   FenetreAjouter n=new FenetreAjouter();
			  
		  }
	//Créer l'onglet de modification des donnée et ses composantes
  public void ongletdeModification(String nomOnglet) {
	 //le tableau contenant tous les dates disponibles dans chacun des fichiers
	  LocalDate[] TableauDesDates=new LocalDate[100];
	  try 
	  {//appel à la fonction de la classe Gestion_Donnée qui retourne un tableau contenant tous les dates enregistrées dans les fichiers
		  TableauDesDates=Gestion_Donnée.datesdonnées();  
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
		    tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, Onglet);}
	  catch(IOException e)
	  {e.printStackTrace();}	
		    
}}

class FenetreAjouter extends JPanel 
{ 
//le bouton de validation des données à ajouter
JButton bouton;
//une liste déroulante pour le nom de gouvernorat et 3 champs de saisies 
JComboBox GouvernoratSaisie;
TextField nombreDécésSaisie;
TextField nombreInféctéSaisie;
TextField nombreRetablisSaisie;
String nomGouvernorat;
//les données saisies
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
	 
	 reglageFenetreAjouter(regions);
	
}
public void reglageFenetreAjouter(String[] regions)
{      bouton.addActionListener(new ActionListener()
           {public void actionPerformed(ActionEvent evt) {
          //récupérer les données  saisies par l'administrateur
          nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
           try
           {  nombreDécés=Integer.parseInt(nombreDécésSaisie.getText());
             nombreInfécté=Integer.parseInt(nombreInféctéSaisie.getText());
           nombreRetablis=Integer.parseInt(nombreRetablisSaisie.getText());
             DateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); // Format de la date
	          Date date = new Date(); // Date actuelle
	         String datech= format.format(date); // Date d'aujourd'hui en chaine de caractéres sous le format voulu
		String[] ch=Gestion_Donnée.derniéreligne( nomGouvernorat).split(" ");//récuperer la dérniére date enregisté
		/*si la derniére date enregistré dans le fichier n'est pas la date actuelle càd d'aujourd'hui il va ajouter ces données 
		 * avec la date actuelle sinon il va afficher un message d'erreur  */
          if(!ch[0].equals(datech))
          { Gestion_Donnée.remplirfichier( nomGouvernorat ,nombreInfécté , nombreDécés ,  nombreRetablis);
            for(int i=0;i<24;i++)
          { if(!regions[i].equals(nomGouvernorat))//insérer la date actuelle avec des données de valeur zéro pour tous les gouvernorat sauf le gouvernorat saisie
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
          {e.printStackTrace();}

        }
});
}
}
//le jpanel qui va etre le contenu de l'onglet de modification 
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
				//ajouter les champs de saisie et la liste déroulante et des titres pour chaque élément
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
		try		 
		{//extraire la derniére année enregistrée
		int anneeActuelle=LocalDate.parse(Gestion_Donnée.derniéreligne("Ariana").split(" ")[0]).getYear();
	 Vector vecteur=new Vector();//un vecteur qui doit contenir tout les années enregistrées 
	 for(int j=2020;j<=anneeActuelle;j++)
     	 vecteur.add(j);
	 //créer les listes déroulantes des dates possibles 
	 annee=new JComboBox(vecteur);
	 Vector vecteur1=new Vector();//un vecteur pour les mois possibles
	 for(int i=1;i<=12;i++)
		vecteur1.add(i) ;
	 mois=new JComboBox(vecteur1);
	 Vector vecteur2=new Vector();//un vecteur pour les jours possibles
	 for(int i=1;i<=31;i++)
			 vecteur2.add(i) ;
	jour=new JComboBox(vecteur2);
	//ajouter les listes déroulantes au JPanel avec un titre et le bouton de validation
	JLabel etiquette5=new JLabel("donnez la date de modification");
	 this.add(etiquette5);
	 this.add(jour);
	 this.add(mois);
	 this.add(annee);
	 this.add(bouton);
	 
	 reglageFenetreModifier(obj);
	
		}
		catch(IOException e)
		{e.printStackTrace();}
	 }
	
	 
public void reglageFenetreModifier(LocalDate[] obj) 
{
	bouton.addActionListener(new ActionListener()
	 {public void actionPerformed(ActionEvent evt) {
	 nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
	try
	{  nombreDécés=Integer.parseInt(nombreDécésSaisie.getText());
	 nombreInfécté=Integer.parseInt(nombreInféctéSaisie.getText());
	 nombreRetablis=Integer.parseInt(nombreRetablisSaisie.getText());
	
	 
	 nomGouvernorat=GouvernoratSaisie.getSelectedItem().toString();
	 int j=Integer.parseInt(jour.getSelectedItem().toString());
	 int m =Integer.parseInt(mois.getSelectedItem().toString());
	 int a=Integer.parseInt(annee.getSelectedItem().toString());	
	 if (estAvant(j,m,a,obj[0]))
	 
	       Principal.messageErreur("Date erronée! \n  veuiller choisir une date après la date du début de la pandémie suivante 01-03-2020 :");
	  
	  else
	  { if (estApres(j,m,a,LocalDate.parse(Gestion_Donnée.derniéreligne("Ariana").split(" ")[0])))
	  {	  String x=Gestion_Donnée.derniéreligne("Ariana").split(" ")[0];
	  Principal.messageErreur("Date erronée! \n  veuiller choisir une date avant la derniére date enregistrée suivante:"+x);
	  }
	  else
	  {  if (!estPresent(obj, LocalDate.of(a,m,j) ))
		     Principal.messageErreur("Date introuvable");
			 
		  else 
		  { LocalDate date=LocalDate.of(a,m,j);	      
	        Gestion_Donnée.modifierdonnées ( date , nombreInfécté , nombreDécés ,  nombreRetablis , nomGouvernorat);}
	  }}}
	  catch(NumberFormatException e)
		 {Principal.messageErreur("Veuillez saisir que des chiffres");}
	       catch(IOException evt2)
	       {System.out.print("exception1");}
	  }
	
	
	 });}

//methode qui retourne la derniere date (la valeur non null d'un tableau
/*public int indice(LocalDate[] obj) {
	int i;
	 for (i=obj.length-1;i>=0;i--)
	 { if(obj[i]!=null)
	 {break;}
	 }return i;
	 }*/

// methode qui vérifier si une date est présente dans un tableau ou non
 public static boolean estPresent(LocalDate[] obj,LocalDate element)
 { boolean ch=Arrays.asList(obj).contains(element);
	return ch;}
//methode qui vérifier si une date est avant une autre ou non 
public static boolean estAvant(int j,int m,int a,LocalDate obj)  
{ boolean test=false;
	if(LocalDate.of(a,m,j).isBefore(obj))
	test=true;
	return test;
	}
//methode qui vérifier si une date est aprés une autre ou non 
public static boolean estApres(int j,int m,int a,LocalDate obj)  
{ boolean test=false;
	if(LocalDate.of(a,m,j).isAfter(obj))
	test=true;
	return test;
	}}

 