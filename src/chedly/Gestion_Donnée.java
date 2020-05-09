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

public class Gestion_Donnée {
	public static int[] lecturedonnées(String ville , LocalDate date) throws IOException // Lire les données d'un gouvernorat (Cas total , Cas guéris , Décès)
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
			String donnée[]=ligne.split(" "); // Diviser la chaine à chaque espace trouvé et la mettre dans un tableau
			LocalDate datedonnée = LocalDate.parse(donnée[0]); // Prendre le premier élément et le transformer en date
			if (date.isAfter(datedonnée)) // Comparer les dates
			{
				cas+=Integer.parseInt(donnée[1]);
				gueris+=Integer.parseInt(donnée[2]);
				deces+=Integer.parseInt(donnée[3]);
			}
			else
				break;
		}
		in.close(); // Fermer le fichier
		int[] resultat = {cas, gueris , deces}; // Tableau contenant le résultat final
		return resultat;
	}
	public static LocalDate[] datesdonnées() throws IOException
	{
		String ligne;
		LocalDate date;
		LocalDate [] tab = new LocalDate[100];
		int i=0;
		String chemin = System.getProperty("user.dir"); //Chemin du projet
		BufferedReader in= new BufferedReader ( new FileReader (chemin+"/villes/tunis.txt")); //Lit les dates de la ville de Tunis (toutes les villes ont les même dates donc il suffit d'en prendre une seule
		while ((ligne=in.readLine()) !=null)
		{
			String donnée[]=ligne.split(" "); //Divise la chaine puis prend le premier champ qui présente la date
			date=LocalDate.parse(donnée[0]);
			tab[i]=date; // Stocke les données dans un tableau
			i++;
		}
		return tab; // Retourne le tableau
	}	
	public static void modifierdonnées (LocalDate date , int cas , int gueris , int deces , String ville) throws IOException // Prend les paramétres suivants pour modifier les données dans une ville
	{
		String ligne;
		String res;
		LocalDate d;
		List<String> list = new ArrayList<String>();
		String chemin = System.getProperty("user.dir"); // Chemin du projet
		BufferedReader in=new BufferedReader (new FileReader (chemin+"/villes/"+ville+".txt")); // Chemin de la ville a modifier
		while((ligne=in.readLine())!=null)
		{
			String donnée[]=ligne.split(" ");
			d=LocalDate.parse(donnée[0]);
			if (date.equals(d))
				{
				donnée[1]=Integer.toString(cas);
				donnée[2]=Integer.toString(gueris);
				donnée[3]=Integer.toString(deces);
				res=String.join(" ", donnée);
				list.add(res);
				}
			else
				list.add(ligne);
		} // Dans cette boucle while , les données du fichier sont stockées dans une liste , la ligne a modifier est modifée puis stockée dans la liste
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
		} // Dans cette boucle for , on écrit le fichier a nouveau a partir des éléments de la liste
	}
	public static int[] lecturedonnées(String ville) throws IOException // Celle ci donne les données de la dernière date directement (Même chose que lecturedonnées)
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
			String donnée[]=ligne.split(" ");
				cas+=Integer.parseInt(donnée[1]);
				gueris+=Integer.parseInt(donnée[2]);
				deces+=Integer.parseInt(donnée[3]);
		}
		in.close();
		int[] resultat = {cas, gueris , deces};
		return resultat;
	}
	public static void ajoutdonnéeschemin(String chemin) throws IOException // Celle si permet d'ajouter un fichier avec Jfilechooser (prend en paramétre uniquement le chemin)
	{
		String ch [] = chemin.split("/");
		String interm= ch[ch.length-1];
		String interm1 []= interm.split("\\.");
		String datech= interm1[0]; // Toutes les variables en haut sont utilisées pour prendre la date sans le .txt
		String ligne;
		LocalDate[] test = {};
		FileReader F = new FileReader (chemin);
		String cheminproj = System.getProperty("user.dir"); // Chemin du projet
		BufferedReader in = new BufferedReader (F);
		test= Gestion_Donnée.datesdonnées(); // Pour voir si la date est déjà remplie ou pas
		if (Arrays.asList(test).contains(LocalDate.parse(datech))!=true)
		{
			while ((ligne=in.readLine())!= null)
			{
				
				String donnée[]=ligne.split(" ");
				String Ville= donnée[0];
				String cas = donnée[1];
				String gueris = donnée[2];
				String deces = donnée[3];
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
				
				
			} // Dans cette boucle on remplit les données de chaque ville
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
			String datech= format.format(date); // Date d'aujourd'hui en chaine de caractéres
			FileWriter f = new FileWriter(chemin+"/villes/"+Ville+".txt" , true);
			f.write(datech+" "+Integer.toString(cas)+" "+Integer.toString(deces)+" "+Integer.toString(gueris)+"\n"); // Ecriture dans le fichier selon le format utilisé
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
			int res [] = Gestion_Donnée.lecturedonnées(gouvernorats[i]);
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
			int res [] = Gestion_Donnée.lecturedonnées(gouvernorats[i],date);
			cas+= res[0];
			gueris+= res[1];
			deces+=res[2];
		}
		int[] resultat = {cas, gueris , deces};
		return resultat;
	}
	public static LocalDate[] datesdonnées(String ville) throws IOException
	{
		String ligne;
		LocalDate date;
		LocalDate [] tab = new LocalDate[100];
		int i=0;
		String chemin = System.getProperty("user.dir"); //Chemin du projet
		BufferedReader in= new BufferedReader ( new FileReader (chemin+"/villes/"+ville+".txt")); //Lit les dates de la ville de Tunis (toutes les villes ont les même dates donc il suffit d'en prendre une seule
		while ((ligne=in.readLine()) !=null)
		{
			String donnée[]=ligne.split(" "); //Divise la chaine puis prend le premier champ qui présente la date
			date=LocalDate.parse(donnée[0]);
			tab[i]=date; // Stocke les données dans un tableau
			i++;
		}
		return tab; // Retourne le tableau
	}
	public static String derniéreligne (String ville) throws IOException
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
