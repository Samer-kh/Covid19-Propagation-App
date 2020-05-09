package chedly;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gestion_Donn�e {
	public static int[] lecturedonn�es(String ville , LocalDate date) throws IOException // Lire les donn�es d'un gouvernorat (Cas total , Cas gu�ris , D�c�s)
	{
		String ligne;
		int cas=0;
		int gueris=0;
		int deces=0;
		String chemin = System.getProperty("user.dir"); //chemin du projet
		FileReader F = new FileReader(chemin+"/villes/"+ville+".txt");
		BufferedReader in = new BufferedReader (F); // Lire le fichier
		while((ligne=in.readLine())!=null) // Lecture ligne par ligne
		{
			String donn�e[]=ligne.split(" "); // Diviser la chaine � chaque espace trouv� et la mettre dans un tableau
			LocalDate datedonn�e = LocalDate.parse(donn�e[0]); // Prendre le premier �l�ment et le transformer en date
			if (date.isAfter(datedonn�e)) // Comparer les dates
			{
				cas+=Integer.parseInt(donn�e[1]);
				gueris+=Integer.parseInt(donn�e[2]);
				deces+=Integer.parseInt(donn�e[3]);
			}
			else
				break;
		}
		in.close(); // Fermer le fichier
		int[] resultat = {cas, gueris , deces}; // Tableau contenant le r�sultat final
		return resultat;
	}
	public static LocalDate[] datesdonn�es() throws IOException
	{
		String ligne;
		LocalDate date;
		LocalDate [] tab = new LocalDate[100];
		int i=0;
		String chemin = System.getProperty("user.dir"); //Chemin du projet
		BufferedReader in= new BufferedReader ( new FileReader (chemin+"/villes/tunis.txt")); //Lit les dates de la ville de Tunis (toutes les villes ont les m�me dates donc il suffit d'en prendre une seule
		while ((ligne=in.readLine()) !=null)
		{
			String donn�e[]=ligne.split(" "); //Divise la chaine puis prend le premier champ qui pr�sente la date
			date=LocalDate.parse(donn�e[0]);
			tab[i]=date; // Stocke les donn�es dans un tableau
			i++;
		}
		return tab; // Retourne le tableau
	}	
	public static void modifierdonn�es (LocalDate date , int cas , int gueris , int deces , String ville) throws IOException // Prend les param�tres suivants pour modifier les donn�es dans une ville
	{
		String ligne;
		String res;
		LocalDate d;
		List<String> list = new ArrayList<String>();
		String chemin = System.getProperty("user.dir"); // Chemin du projet
		BufferedReader in=new BufferedReader (new FileReader (chemin+"/villes/"+ville+".txt")); // Chemin de la ville a modifier
		while((ligne=in.readLine())!=null)
		{
			String donn�e[]=ligne.split(" ");
			d=LocalDate.parse(donn�e[0]);
			if (date.equals(d))
				{
				donn�e[1]=Integer.toString(cas);
				donn�e[2]=Integer.toString(gueris);
				donn�e[3]=Integer.toString(deces);
				res=String.join(" ", donn�e);
				list.add(res);
				}
			else
				list.add(ligne);
		} // Dans cette boucle while , les donn�es du fichier sont stock�es dans une liste , la ligne a modifier est modif�e puis stock�e dans la liste
		FileWriter f1 = new FileWriter(chemin+"/villes/"+ville+".txt");
		BufferedWriter bw1 = new BufferedWriter(f1);
		bw1.write(list.get(0)+"\n");
		bw1.close(); 
		for(int i=1; i<list.size(); i++)
		{
			FileWriter f = new FileWriter(chemin+"/villes/"+ville+".txt",true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(list.get(i) + "\n");
			bw.close();
		} // Dans cette boucle for , on �crit le fichier a nouveau a partir des �l�ments de la liste
	}
	public static int[] lecturedonn�es(String ville) throws IOException // Celle ci donne les donn�es de la derni�re date directement (M�me chose que lecturedonn�es)
	{
		String ligne;
		int cas=0;
		int gueris=0;
		int deces=0;
		String chemin = System.getProperty("user.dir");
		FileReader F = new FileReader(chemin+"/villes/"+ville+".txt");
		BufferedReader in = new BufferedReader (F); 
		while((ligne=in.readLine())!=null)
		{
			String donn�e[]=ligne.split(" ");
				cas+=Integer.parseInt(donn�e[1]);
				gueris+=Integer.parseInt(donn�e[2]);
				deces+=Integer.parseInt(donn�e[3]);
		}
		in.close();
		int[] resultat = {cas, gueris , deces};
		return resultat;
	}
	public static void ajoutdonn�eschemin(String chemin) throws IOException // Celle si permet d'ajouter un fichier avec Jfilechooser (prend en param�tre uniquement le chemin)
	{
		String ch [] = chemin.split("/");
		String interm= ch[ch.length-1];
		String interm1 []= interm.split("\\.");
		String datech= interm1[0]; // Toutes les variables en haut sont utilis�es pour prendre la date sans le .txt
		String ligne;
		LocalDate[] test = {};
		FileReader F = new FileReader (chemin);
		String cheminproj = System.getProperty("user.dir"); // Chemin du projet
		BufferedReader in = new BufferedReader (F);
		test= Gestion_Donn�e.datesdonn�es(); // Pour voir si la date est d�j� remplie ou pas
		if (Arrays.asList(test).contains(LocalDate.parse(datech))!=true)
		{
			while ((ligne=in.readLine())!= null)
			{
				
				String donn�e[]=ligne.split(" ");
				String Ville= donn�e[0];
				String cas = donn�e[1];
				String gueris = donn�e[2];
				String deces = donn�e[3];
				try 
				{
					FileWriter f = new FileWriter(cheminproj+"/villes/"+Ville+".txt" , true);
					f.write(datech+" "+cas+" "+gueris+" "+deces+"\n");
					f.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
				
			} // Dans cette boucle on remplit les donn�es de chaque ville
		in.close();
		}
	}
	public static void remplirfichier(String Ville , int cas , int deces , int gueris) // Cette fonction permet a l'administrateur de remplir manuellement.
	{
		DateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); // Format de la date
		Date date = new Date(); // Date actuelle
		String chemin = System.getProperty("user.dir"); // Chemin du projet
		try 
		{
			String datech= format.format(date); // Date d'aujourd'hui en chaine de caract�res
			FileWriter f = new FileWriter(chemin+"/villes/"+Ville+".txt" , true);
			f.write(datech+" "+Integer.toString(cas)+" "+Integer.toString(deces)+" "+Integer.toString(gueris)+"\n"); // Ecriture dans le fichier selon le format utilis�
			f.close();
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static int[] lecturetunisie () throws IOException
	{
		String gouvernorats [] = {"Ariana","Beja","BenArous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili","Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana","Tataouine","Sousse","Tozeur","Tunis","Zaghouan"};
		int i;
		int cas=0;
		int deces=0;
		int gueris=0;
		for (i=0 ; i<24 ; i++)
		{
			int res [] = Gestion_Donn�e.lecturedonn�es(gouvernorats[i]);
			cas+= res[0];
			gueris+= res[1];
			deces+=res[2];
		}
		int[] resultat = {cas, gueris , deces};
		return resultat;
	}
	public static int[] lecturetunisie (LocalDate date) throws IOException
	{
		String gouvernorats [] = {"Ariana","Beja","BenArous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili","Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana","Tataouine","Sousse","Tozeur","Tunis","Zaghouan"};
		int i;
		int cas=0;
		int deces=0;
		int gueris=0;
		for (i=0 ; i<24 ; i++)
		{
			int res [] = Gestion_Donn�e.lecturedonn�es(gouvernorats[i],date);
			cas+= res[0];
			gueris+= res[1];
			deces+=res[2];
		}
		int[] resultat = {cas, gueris , deces};
		return resultat;
	}
	public static LocalDate[] datesdonn�es(String ville) throws IOException
	{
		String ligne;
		LocalDate date;
		LocalDate [] tab = new LocalDate[100];
		int i=0;
		String chemin = System.getProperty("user.dir"); //Chemin du projet
		BufferedReader in= new BufferedReader ( new FileReader (chemin+"/villes/"+ville+".txt")); //Lit les dates de la ville de Tunis (toutes les villes ont les m�me dates donc il suffit d'en prendre une seule
		while ((ligne=in.readLine()) !=null)
		{
			String donn�e[]=ligne.split(" "); //Divise la chaine puis prend le premier champ qui pr�sente la date
			date=LocalDate.parse(donn�e[0]);
			tab[i]=date; // Stocke les donn�es dans un tableau
			i++;
		}
		return tab; // Retourne le tableau
	}
	public static String derni�religne (String ville) throws IOException
	{
		String ligne;
		String cheminproj = System.getProperty("user.dir"); // Chemin du projet
		BufferedReader in= new BufferedReader ( new FileReader (cheminproj+"/villes/"+ville+".txt"));
		while ((ligne=in.readLine()) !=null)
		{
		}
		return ligne;
	}
}
