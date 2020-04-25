package chedly;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.util.Arrays;

public class Gestion_Donn�e {
	File fichier;
	String gouvernorat[] = {"Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili","Kef","Mahdia","Manouba","Medenine","Monastir","Nabeul","Sfax","SidiBouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zagouan"};
	
	Gestion_Donn�e(File F)
	{
		fichier=F;
	}
	public static int[] lecturedonn�es(String ville , LocalDate date) throws IOException // Lire les donn�es d'un gouvernorat (Cas total , Cas gu�ris , D�c�s)
	{
		String ligne;
		int cas=0;
		int gueris=0;
		int deces=0;
		FileReader F = new FileReader("villes/"+ville+".txt");
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
	public static void ajoutdonn�es(String nomfichier) throws IOException
	{
		BufferedReader in= new BufferedReader( new FileReader(nomfichier+".txt"));
		String ligne;
		String gouv;
		LocalDate[]test= {};
		test= Gestion_Donn�e.datesdonn�es();
		if (Arrays.asList(test).contains(LocalDate.parse(nomfichier)) != true)
		{
			while((ligne=in.readLine()) != null)
			{
				String donn�e[]=ligne.split(" ");
				gouv=donn�e[0];
				try {
				FileWriter f = new FileWriter("villes/"+gouv+".txt",true); // True pour ne pas �craser le contenu
				f.write(nomfichier+" "+donn�e[1]+" "+donn�e[2]+" "+donn�e[3]+"\n");
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
	
	public static LocalDate[] datesdonn�es() throws IOException
	{
		String ligne;
		LocalDate date;
		LocalDate [] tab = new LocalDate[100];
		int i=0;
		BufferedReader in= new BufferedReader ( new FileReader ("villes/tunis.txt"));
		while ((ligne=in.readLine()) !=null)
		{
			String donn�e[]=ligne.split(" ");
			date=LocalDate.parse(donn�e[0]);
			tab[i]=date;
			i++;
		}
		return tab;
	}	
}
