package Principale;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class Principal {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Fenetre fen=new Fenetre();
        
	}

}
class Fenetre extends JFrame   implements ActionListener{
	public ConteneurFenetre contenu=new  ConteneurFenetre();
	JButton importer;
	JButton ajouter;
    JButton modifier;
    JButton supprimer;
	public Fenetre() {
		super();
		importer= new JButton("importer un fichier");
		ajouter= new JButton("Ajouter");
		modifier= new JButton("Modifier");
		supprimer= new JButton("Supprimer");
		 contenu.ajouterBoutton(importer);
		    contenu.ajouterBoutton(ajouter);
		    contenu.ajouterBoutton(supprimer);
		    contenu.ajouterBoutton(modifier);
		    ajouter.addActionListener(this);
		    modifier.addActionListener(this);
		    supprimer.addActionListener(this);
		this.setSize(1000, 1000);
		this.setTitle("Interface Administrateur");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	    this.setResizable(false);
	    this.setContentPane(contenu);
	  //  contenu.ajouterBoutonAvecText();
	   
	   // this.remove(supprimer
	    
	}
	
	public void actionPerformed(ActionEvent evenement) {
				this.remove(supprimer);
				this.remove(ajouter);
				this.remove(importer);
				this.remove(modifier);
				if(evenement.getSource()==ajouter)
				contenu.ajouterBoutonAvecText();
			//	else
				//	if(evenement.getSource()==modifier)
					///	contenu.aj
	}
}

/*une methode qui retourne le jframe courant pour changer son panel quand l'utilisateur 
 * choisie l'opération à effectuer càd ajout,modification,suppression
 */
	//public static JFrame retourJframeCourant()
//	{
//		return this.getContentFrame();
//	}
	
	
//}
