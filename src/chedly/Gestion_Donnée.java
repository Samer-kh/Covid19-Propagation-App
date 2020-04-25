package chedly;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.util.Arrays;

public class Gestion_Donnée {
	File fichier;
	String gouvernorat[] = {"Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili","Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zagouan"};
	
	Gestion_Donnée(File F)
	{
		fichier=F;
	}
	public static int[] lecturedonnées(String ville , LocalDate date) throws IOException // Lire les données d'un gouvernorat (Cas total , Cas guéris , Décès)
	{
		String ligne;
		int cas=0;
		int gueris=0;
		int deces=0;
		FileReader F = new FileReader("villes/"+ville+".txt");
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
	public static void ajoutdonnées(String nomfichier) throws IOException
	{
		BufferedReader in= new BufferedReader( new FileReader(nomfichier+".txt"));
		String ligne;
		String gouv;
		LocalDate[]test= {};
		test= Gestion_Donnée.datesdonnées();
		if (Arrays.asList(test).contains(LocalDate.parse(nomfichier)) != true)
		{
			while((ligne=in.readLine()) != null)
			{
				String donnée[]=ligne.split(" ");
				gouv=donnée[0];
				try {
				FileWriter f = new FileWriter("villes/"+gouv+".txt",true); // True pour ne pas écraser le contenu
				f.write(nomfichier+" "+donnée[1]+" "+donnée[2]+" "+donnée[3]+"\n");
				f.close();
				}
				catch(IOException e)
				{
					System.out.println("Erreur");
					e.printStackTrace();
				}
				
			}
			
			in.close();
		}
		else
		{
			System.out.println("Date Existe");
		}
		
	}
	
	public static LocalDate[] datesdonnées() throws IOException
	{
		String ligne;
		LocalDate date;
		LocalDate [] tab = new LocalDate[100];
		int i=0;
		BufferedReader in= new BufferedReader ( new FileReader ("villes/tunis.txt"));
		while ((ligne=in.readLine()) !=null)
		{
			String donnée[]=ligne.split(" ");
			date=LocalDate.parse(donnée[0]);
			tab[i]=date;
			i++;
		}
		return tab;
	}	
}
