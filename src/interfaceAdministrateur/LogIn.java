package interfaceAdministrateur;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//la fenetre du connexion
public class LogIn extends JFrame implements ActionListener {
	String administrateur="admin";
	String adminPassword="admin";
	JButton SeConnecter;
	JTextField nomAdmin;
	JPasswordField motDePasse;
	
	public LogIn() 
	{    nomAdmin=new JTextField();
    nomAdmin.setPreferredSize(new Dimension(200,20));
    motDePasse=new JPasswordField();
    motDePasse.setPreferredSize(new Dimension(200,20));
    SeConnecter=new JButton("Se connecter");
        this.setLocation(500,200);
		this.setSize(400,200);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    this.setResizable(true);  
	    this.setTitle("Se connecter"); 
	    JPanel panel=new JPanel();  
	    panel.setBackground(new Color(236, 228, 219));
	    JLabel userName = new JLabel("Nom de l'administrateur :");
	    JLabel password = new JLabel("Mot De Passe :");
	    panel.add(userName);
	    panel.add(nomAdmin);
	    panel.add(password);
	    panel.add(motDePasse);
	    panel.add(SeConnecter);
	    this.setLayout(null);   
	    SeConnecter.addActionListener(this); 
	    this.setContentPane(panel);
	}
	
	public void connexionValide() 
	{FenetredAcceuil fen = new FenetredAcceuil();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(!nomAdmin.getText().equals(administrateur))
		   Principal.messageErreur("nom administrateur invalide");			 
	      else
	    	  if(! motDePasse.getText().equals(adminPassword) )
	    		  Principal.messageErreur("Mot De Passe Invalide");
	    	 
	    	  else 
	    		  connexionValide();
	}
}