package Principale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
	    this.setResizable(true);
	    this.setContentPane(contenu);
	  //  JMenuBar menuBar = new JMenuBar();
	 //   this.contenu.add(menuBar);
	  //  menuBar.setBounds(0, 0, 1000, 40);
	   this.contenu.setLayout(new BorderLayout());
	   BarreDeMenu();
	 
	    
	}
	
	public void actionPerformed(ActionEvent evenement) {
				this.remove(supprimer);
				this.remove(ajouter);
				this.remove(importer);
				this.remove(modifier);
				if(evenement.getSource()==ajouter)
				contenu.ajouterBoutonAvecText();
				else
					if(evenement.getSource()==modifier)
						contenu.modifier();
					else
	                       if(evenement.getSource()==supprimer)
		contenu.modifier();
				}
	public void BarreDeMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		JMenuItem ajoute = new JMenuItem("ajouter");
		menu1.add(ajoute);
		JMenuItem importer = new JMenuItem("importer");
		menu1.add(importer);
		JMenuItem modifier = new JMenuItem( "Modifier");
		menu1.add(modifier);
		JMenu menu2 = new JMenu("a propos");
		 menuBar.setBounds(0, 0, 1000, 40);
		 this.contenu.add(menuBar);
		
		
		
	}
}


